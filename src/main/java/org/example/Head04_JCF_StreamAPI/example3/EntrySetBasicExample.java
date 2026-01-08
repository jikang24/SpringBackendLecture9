package org.example.Head04_JCF_StreamAPI.example3;

import java.util.HashMap;
import java.util.Map;

public class EntrySetBasicExample {
    public static void main(String[] args) {
        Map<String, Integer> capitals = new HashMap<>();
        capitals.put("Korea", 82);
        capitals.put("Japan", 81);
        capitals.put("Vietnam", 84);

        for (Map.Entry<String, Integer> entry : capitals.entrySet()) {
            System.out.println("Country: " + entry.getKey() + ", International Number: " + entry.getValue());

        }
    }
}
