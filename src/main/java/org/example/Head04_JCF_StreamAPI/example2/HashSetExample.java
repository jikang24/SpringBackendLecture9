package org.example.Head04_JCF_StreamAPI.example2;

import java.util.Set;
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<>();

        countries.add("Korea");
        countries.add("Japan");
        countries.add("China");
        countries.add("Korea");

        System.out.println("After add: " + countries);

        System.out.println("Contains 'Japan'? " + countries.contains("Japan"));

        countries.remove("China");
        System.out.println("After remove 'China': " + countries);

        System.out.println("Set size: " + countries.size());

        countries.clear();
        System.out.println("After clear: " + countries);
    }
}
