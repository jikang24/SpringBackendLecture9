package org.example.Head05_Algorithm.example3;

import java.util.List;

public class PrinterBeforeGenericMethod {

    public void printStringList(List<String> list){
        for(String s : list){
            System.out.println("String: " + s);
        }
    }

    public void printIntegerList(List<Integer> list){
        for(Integer i : list){
            System.out.println("Integer: " + i);
        }
    }

    public void printUserList(List<User> list){
        for (User u : list){
            System.out.println("User: " + u.getName());
        }
    }
}
