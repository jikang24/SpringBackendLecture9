package org.example.Head05_Algorithm.example3;

import java.util.ArrayList;
import java.util.List;

public class BeforeGenericMethodExample {
    public static void main(String[] args) {
        List<String> string = List.of("Apple", "Banana", "Cherry");
        List<Integer> number = List.of(1, 2, 3);
        List<User> users = List.of(new User("Alice"), new User("Bob"));

        PrinterBeforeGenericMethod printer = new PrinterBeforeGenericMethod();

        printer.printStringList(string);
        printer.printIntegerList(number);
        printer.printUserList(users);
    }
}
