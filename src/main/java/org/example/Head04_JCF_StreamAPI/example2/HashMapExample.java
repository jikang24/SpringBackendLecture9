package org.example.Head04_JCF_StreamAPI.example2;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> Scores = new HashMap<>();

        Scores.put("Kim", 90);
        Scores.put("Lee", 85);
        Scores.put("Park", 92);
        Scores.put("Jang", 80);
        Scores.put("Kang", 80);
        System.out.println("After put: " + Scores);

        Scores.put("Lee", 88);
        Scores.put("Ryu", 77);
        System.out.println("After updating 'Lee': " + Scores);

        int parkScore = Scores.get("Park");
        System.out.println("Park's score: " + parkScore);

        System.out.println("Contains 'Kim'? " + Scores.containsKey("Kim"));
        System.out.println("Contains 'Choi'? " + Scores.containsKey("Choi"));

        Scores.remove("Kim");
        System.out.println("After remove 'Kim': " + Scores);

        System.out.println("Map size: " + Scores.size());

        System.out.println("All keys: " + Scores.keySet());

        Scores.clear();
        System.out.println("After clear: " + Scores);
    }
}
