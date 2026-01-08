package org.example.Head04_JCF_StreamAPI.example3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapEntryTransformationExample {
//    public static void main(String[] args) {
//        Map<String, Integer> scores = new HashMap<>();
//        scores.put("Kim", 90);
//        scores.put("Lee", 85);
//        scores.put("Park", 92);
//
//        Function<Map.Entry<String, Integer>, String> entryToString =
//                new Function<Map.Entry<String, Integer>, String>() {
//                    @Override
//                    public String apply(Map.Entry<String, Integer> entry) {
//                        return entry.getKey() + ": " + entry.getValue();
//                    }
//                };
//
//        scores.entrySet().stream()
//                .map(entryToString)
//                .forEach(result -> System.out.println("Student Info: " + result));
//    }

    public static void main(String[] args) {
        Map<String, String> scores = new HashMap<>();
        scores.put("Kim", "Ten");
        scores.put("Lee", "Five");
        scores.put("Park", "Six");

        Function<Map.Entry<String, String>, String> entryToString =
                new Function<Map.Entry<String, String>, String>() {
                    @Override
                    public String apply(Map.Entry<String, String> entry) {
                        return entry.getKey().toLowerCase() + ": " + entry.getValue().toUpperCase();
                    }
                };

        scores.entrySet().stream()
                .map(entryToString)
                .forEach(result -> System.out.println("Student Info: " + result));
    }
}
