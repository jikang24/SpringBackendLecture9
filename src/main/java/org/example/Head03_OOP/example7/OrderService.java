package org.example.Head03_OOP.example7;

public class OrderService {
    public void processPayment(Payment method, double amount){
        method.pay(amount);

    }
}
