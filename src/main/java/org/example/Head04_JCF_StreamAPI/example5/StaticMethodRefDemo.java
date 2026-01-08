package org.example.Head04_JCF_StreamAPI.example5;

import java.util.function.Function;

public class StaticMethodRefDemo {
    public static int doubleValue(int x) {
        return x * 2;
    }

    public static void main(String[] args) {

//        Function<Integer, Integer> f1 = num -> StaticMethodRefDemo.doubleValue(num);

        Function<Integer, Integer> g2 = StaticMethodRefDemo::doubleValue;

        System.out.println(g2.apply(10));
    }
}
