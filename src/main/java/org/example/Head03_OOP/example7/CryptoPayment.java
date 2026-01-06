package org.example.Head03_OOP.example7;

public class CryptoPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("크립토: " + amount + "원 결제 완료.");
    }
}
