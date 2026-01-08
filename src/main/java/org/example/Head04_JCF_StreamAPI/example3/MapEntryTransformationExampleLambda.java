package org.example.Head04_JCF_StreamAPI.example3;

import java.util.HashMap;
import java.util.Map;

public class MapEntryTransformationExampleLambda {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("kim", 90);
        scores.put("Lee", 85);
        scores.put("Park", 92);

        scores.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(result -> System.out.println("Student Info: " + result));
    }
}
