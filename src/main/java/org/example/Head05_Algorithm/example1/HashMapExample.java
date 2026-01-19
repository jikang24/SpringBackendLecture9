package org.example.Head05_Algorithm.example1;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("apple", 1000);
        map.put("banana",1500);
        map.put("apple",1200);

        System.out.println(map.get("apple"));// 1200

        System.out.println(map.containsKey("banana"));// true
    }
}

// 빈도수 카운터
// Map<String, Integer> wordCount = new HashMap<>();
// for(String word : words) {
//		wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
// }
