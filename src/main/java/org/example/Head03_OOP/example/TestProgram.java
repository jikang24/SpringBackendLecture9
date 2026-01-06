package org.example.Head03_OOP.example;

public class TestProgram {
    public static void main(String[] args) {
        orderJava order = new orderJava();

        orderJava newOrder = new orderJava("1212", true);
        System.out.println(order.getOrderId());
        System.out.println(order.getIsPaid());

        order.setOrderId("김김김");
        order.setIsPaid(false);

        System.out.println(order.getOrderId());
        System.out.println(order.getIsPaid());

    }
}
