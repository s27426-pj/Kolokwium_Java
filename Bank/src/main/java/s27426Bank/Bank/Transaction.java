package s27426Bank.Bank;

public class Transaction {
    private Client client;
    private double value;
    private TransactionStatus status;
    public Client getClient() {
        return client;
    }

    public Transaction(Client client,double value,TransactionStatus status){
        this.client = client;
        this.value = value;
        this.status = status;
    }
    public double getValue() {
        return value;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
