package org.example.Head04_JCF_StreamAPI.example4;

import java.util.List;

public class ForEachVsForExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        System.out.println("=== Using for loop ===");
        for (int i = 0; i< numbers.size(); i++){
            if (numbers.get(i) % 2 != 0) {
                continue;
            }
            System.out.println(numbers.get(i));
        }
        System.out.println();
        System.out.println("=== Using enhanced for ===");
        for (Integer num : numbers){
            if (num % 2 != 0){
                continue;
            }
            System.out.println("Even number: " + num);
        }
        System.out.println();
        System.out.println("=== Using Stream filter + forEach ===");

        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.println("Even number: " + num));
    }
}
