package org.example.Head04_JCF_StreamAPI.example2;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");
        fruits.add("Grape");
        System.out.println("After add: " + fruits);

        String firstFruit = fruits.get(1);
        System.out.println("First Fruit: " + firstFruit);

        fruits.remove(1);
        fruits.remove("Mango");
        System.out.println("After remove index: 1 " + fruits);

        System.out.println("List size: " + fruits.size());

        fruits.add("Watermelon");
        System.out.println("After add2: " + fruits);

        fruits.clear();
        System.out.println("After clear: " + fruits);

    }
}
