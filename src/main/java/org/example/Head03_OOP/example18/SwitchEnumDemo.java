package org.example.Head03_OOP.example18;

public class SwitchEnumDemo {
    public static void main(String[] args) {
        PaymentMethod method = PaymentMethod.Credit_Card;
        switch (method) {
            case Credit_Card :
                System.out.println("신용카드 결제 선택" + method.getDisplayName());
                break;
            case Account_Transfer:
                System.out.println("계좌이체 결제 선택" + method.getDisplayName());
                break;
            case Mobile_Payment:
                System.out.println("모바일 결제 선택" + method.getDisplayName());
                break;
        }
        System.out.println(PaymentMethod.Credit_Card);
    }
}
