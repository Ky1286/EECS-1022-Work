package eecs1022.lab7.bank.model;

public class Transaction {

    String status;
    double value;

    public Transaction(String deposit, double v) {
        this.status = deposit;
        this.value = v;
    }

    public String getStatus() {
        String result = "Transaction " + this.status +": $" + String.format("%.2f", this.value);
        return result;
    }
}
