package eecs1022.lab7.bank.model;

public class Client {

    String name;
    double bal;
    String[] statement = new String[0];

    public Client(String name, double bal) {
        this.name = name;
        this.bal = bal;
    }

    public void increaseSize() {
        String[] temp = new String[this.statement.length + 1];
        for (int i = 0; i < this.statement.length; i++) {
            temp[i] = this.statement[i];
        }
        this.statement = temp;
    }

    public String getStatus() {
        String result = this.name + ": $" + String.format("%.2f", this.bal);
        if (this.statement.length == 0) {
            increaseSize();
        }
        this.statement[0] = result;
        return result;
    }

    public String[] getStatement() {
        String[] temp = this.statement;
        return temp;
    }

    public void deposit(double v) {
        this.bal += v;
        Transaction temp = new Transaction("DEPOSIT", v);
        increaseSize();
        this.statement[0] = getStatus();
        this.statement[this.statement.length - 1] = temp.getStatus();
    }

    public void withdraw(double v) {
        this.bal -= v;
        Transaction temp = new Transaction("WITHDRAW", v);
        increaseSize();
        this.statement[this.statement.length - 1] = temp.getStatus();
    }
}
