package org.example.Head05_Algorithm.example1;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.remove(1);
        System.out.println(linkedList);

    }
}
