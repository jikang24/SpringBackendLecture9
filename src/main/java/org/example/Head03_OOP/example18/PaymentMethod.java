package org.example.Head03_OOP.example18;

public enum PaymentMethod {
    Credit_Card("신용카드"),
    Account_Transfer("계좌이체"),
    Mobile_Payment("핸드폰 결제");
    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }

}
