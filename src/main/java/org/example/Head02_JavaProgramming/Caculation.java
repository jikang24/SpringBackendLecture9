package org.example.Head02_JavaProgramming;

public class Caculation {
    public static void main(String[] args) {
        int age = 30;
        double temperature = 36.6;
        boolean isOpen = false;

        System.out.println("나이: " + age);
        System.out.println("체온: " + temperature);
        System.out.println("영업 여부: " + isOpen);

        int x = 12, y = 5;

        System.out.println("합 " + (x + y));
        System.out.println("차 " + (x - y));
        System.out.println("곱 " + (x * y));
        System.out.println("몫 " + (x / y));
        System.out.println("나머지 " + (x % y));

        int score = 92;
        String result = (score >= 90) ? "A학점" : "B학점";
        System.out.println("성적: " + result);

    }
}
