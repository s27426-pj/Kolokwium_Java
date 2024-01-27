package s27426Bank.Bank;

public class Transaction {
    private Client client;
    private double value;
    private ClientStorage status;
    public Client getClient() {
        return client;
    }

    public Transaction(Client client,double value,ClientStorage status){
        this.client = client;
        this.value = value;
        this.status = status;
    }
    public double getValue() {
        return value;
    }

    public ClientStorage getStatus() {
        return status;
    }

    public void setStatus(ClientStorage status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
