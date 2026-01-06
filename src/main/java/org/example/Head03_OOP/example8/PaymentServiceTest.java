package org.example.Head03_OOP.example8;

public class PaymentServiceTest{
    public static void main(String[] args) {
        //UserAccount 객체 생성
        UserAccount account = new UserAccount("ACC001");
        //PaymentService 객체 생성
        PaymentService paymentService = new PaymentService();

        // 정상 입금 테스트
        account.deposit(10000);

        //System.out.println으로 잔액 조회
        System.out.println("입금 완료: " + account.getBalance());

        // 1. 음수 입금 테스트
        try {
            account.deposit(-5000);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 (음수 입금): " + e.getMessage());
        }

        // 2. 음수 출금 테스트
        try {
            account.withdraw(-3000);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 (음수 출금): " + e.getMessage());
        }

        // 3. 잔액 부족 출금 테스트
        try {
            account.withdraw(11000);
        } catch (IllegalStateException e) {
            System.out.println("예외 발생 (잔액 부족): " + e.getMessage());
        }

        // 4. 정상 결제
        paymentService.processPayment(account, 3000);
        // 5 정상 환불
        paymentService.processRefund(account, 3000);
    }
}
