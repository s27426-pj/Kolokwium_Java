package s27426Bank.Bank;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final ClientStorage clientStorage;
    private final TransactionStorage transactionStorage;

    public TransactionService(ClientStorage clientStorage, TransactionStorage transactionStorage) {
        this.clientStorage = clientStorage;
        this.transactionStorage = transactionStorage;
    }

    public Client makeTransaction(int clientId,double value){
        Client client = clientStorage.getClient(clientId);
        if (client != null) {
            if (client.getBalance() > value){
                Transaction transaction = new Transaction(clientId,value,TransactionStatus.ACCEPTED)
                transactionStorage.addTransaction(transaction);
            }

        return client;}
        else {
            throw new RuntimeException("Client don`t exist");
        }
    }
}
