package org.example.Head04_JCF_StreamAPI.example3;

import java.util.HashMap;
import java.util.Map;

public class FilterMapExampleLamda {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kim", 90);
        scores.put("Lee", 87);
        scores.put("Park", 75);

        scores.entrySet().stream()
                .filter(entry -> entry.getValue() >= 80)
                .forEach(entry ->
                        System.out.println("High Scorer: " + entry.getKey()
                                + " => " + entry.getValue()));
    }
}
