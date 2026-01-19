package org.example.Head05_Algorithm.example3;

import java.util.List;

public class AfterGenericMethodExample {
    public static void main(String[] args) {
        List<String> list = List.of("Apple", "Banana", "Cherry");
        List<Integer> number = List.of(1, 2, 3);
        List<User> users = List.of(new User("Alice"), new User("Bob"));


        PrinterAfterGenericMethod.printList(list, s -> "String: " + s);
        PrinterAfterGenericMethod.printList(number, n -> "Integer: " + n);
        PrinterAfterGenericMethod.printList(users, u -> "User: " + u.getName());

        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        PrinterAfterGenericMethod.printList(doubleList, d -> "Double: " + d);
    }
}
