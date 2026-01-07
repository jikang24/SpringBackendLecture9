package org.example.Head03_OOP.example18;

public class PaymentMethodDemo {
    public static void main(String[] args) {
        for (PaymentMethod pm : PaymentMethod.values()) {
            System.out.println(pm.name() + " : " + pm.getDisplayName());
        }


    }
}
