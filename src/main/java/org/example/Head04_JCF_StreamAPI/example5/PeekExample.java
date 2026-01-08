package org.example.Head04_JCF_StreamAPI.example5;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("One", "Two", "Three");

        long count = items.stream()
                .peek(s -> System.out.println("[peek 1] " + s))
                .filter(s -> s.length() > 3)
                .peek(s -> System.out.println("[peek 2] " + s))
                .count();

        System.out.println("Count of filtered items: " + count);
    }
}
