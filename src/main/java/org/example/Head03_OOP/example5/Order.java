package org.example.Head03_OOP.example5;

public class Order {
    private Payment payment;

    public Order(Payment payment) {
        this.payment = payment;
    }

    public void process(double amount) {
        payment.pay(amount);
    }
//    public void cancel(double amount) {
//        payment.cancel(amount);
//    }
}
