package org.example.Head04_JCF_StreamAPI.example5;

import java.util.Arrays;
import java.util.List;

public class DistinctExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Bob");

        names.stream()
                .distinct()
                .forEach(name -> System.out.println("Distinct name: " + name));
    }
}
