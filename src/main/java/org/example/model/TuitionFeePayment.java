package org.example.model;

public class TuitionFeePayment {
    private double totalTuition;
    private double balance;

    public TuitionFeePayment() {}

    public TuitionFeePayment(double totalTuition, double balance) {
        this.totalTuition = totalTuition;
        this.balance = balance;
    }

    public double getTotalTuition() {
        return totalTuition;
    }

    public void setTotalTuition(double totalTuition) {
        this.totalTuition = totalTuition;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "TuitionFeePayment{" +
                "totalTuition=" + totalTuition +
                ", balance=" + balance +
                '}';
    }
}
