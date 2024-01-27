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

    public String createAccount(int clientId,double value){
        if (clientStorage.getClient(clientId) == null) {
            Client client = new Client(clientId, value);
            clientStorage.addClient(client);
            return "Klient zarejestrowany";
        }
        else return "Klient już istnieje";
    }


    public String makeTransaction(int clientId,double value){
        Client client = clientStorage.getClient(clientId);
        String wynik = "";
        if (client != null) {
            if (client.getBalance() > value){
                Transaction transaction = new Transaction(client,value,TransactionStatus.ACCEPTED);
                transactionStorage.addTransaction(transaction);
                client.setBalance(client.getBalance() - value);
                wynik += client.getBalance();
                wynik += transaction.getStatus();
            } else if (client.getBalance() < value) {
                Transaction transaction = new Transaction(client,value,TransactionStatus.DECLINED);
                transactionStorage.addTransaction(transaction);
                wynik += transaction.getStatus();
            }
            return wynik;
        }
        else {
            throw new RuntimeException("Client don`t exist");
        }
    }
}
