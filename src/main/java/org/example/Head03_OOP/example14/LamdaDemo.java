package org.example.Head03_OOP.example14;

public class LamdaDemo {
    public static void main(String[] args) {
        MyCalculator addAnon = new MyCalculator() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("익명 클래스 덧셈: 3 + 5 = " + addAnon.operate(3,5));

        MyCalculator multiplyAnon = new MyCalculator() {
            @Override
            public int operate(int a, int b) {
                return a * b;
            }
        };

        System.out.println("익명 클래스 곱셈: " + multiplyAnon.operate(5,8));


        MyCalculator addLamda = (a,b) -> a + b;
        System.out.println("(타입캐스팅)람다 곱셈: 3 + 5 = " + (double)addLamda.operate(3,5));

        MyCalculator multiplyLamda = (a,b) -> a * b;
        System.out.println("람다 곱셈 : 5 * 8 = " + multiplyLamda.operate(5,8));

    }

}
