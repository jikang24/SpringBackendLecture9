package org.example.Head04_JCF_StreamAPI.example4;

import java.util.List;

public class ForEachFruitsExampleLambda {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Cherry");

        fruits.stream()
                .forEach(fruit -> System.out.println("Fruit: " + fruit));

    }
}
