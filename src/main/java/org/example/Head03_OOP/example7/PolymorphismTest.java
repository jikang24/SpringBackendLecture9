package org.example.Head03_OOP.example7;

public class PolymorphismTest {
    public static void main(String[] args) {
        Payment[] payments = new Payment[]
                {
                        new CreditCardPayment(),
                        new AccountTransferPayment(),
                        new CryptoPayment()
                };
        OrderService service = new OrderService();
        service.processPayment(new CreditCardPayment(), 10000);
        service.processPayment(new AccountTransferPayment(), 20000);
        service.processPayment(new CryptoPayment(), 45000);
        double[] paymentAmounts = new double[]{
                30000,
                70000,
                100000
        };
        for(Payment p : payments) {
            if (p instanceof CreditCardPayment){
                service.processPayment(p,paymentAmounts[0]);
            } else if (p instanceof AccountTransferPayment) {
                service.processPayment(p,paymentAmounts[1]);
            } else if (p instanceof CryptoPayment) {
                service.processPayment(p,paymentAmounts[2]);
            } else {
                service.processPayment(p,1000);
            }
        }
    }
}
