package org.example.Head03_OOP.example8;

public class UserAccount {
    private final String accountId;
    private double balance;

    public UserAccount(String accountId) {
        if (accountId == null || accountId.isBlank()){
            throw new IllegalArgumentException("계좌 ID는 필수입니다.");
        }
        this.accountId = accountId;
        this.balance = 0;
    }

    public String getAccountId() {
        return accountId;
    }


    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("0보다 커야 합니다.");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("출금액은 0보다 커야 합니다.");
        }
        if (balance < amount) {
            throw new IllegalStateException("잔액이 부족합니다.");
        }
        balance -= amount;
    }


    public double getBalance() {
        return balance;
    }
}

