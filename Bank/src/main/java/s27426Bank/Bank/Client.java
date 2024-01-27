package s27426Bank.Bank;
public class Client {
    private int id;
    private double balance;
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
    public Client(int id,double balance){
        this.id = id;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}