package org.example.Head05_Algorithm.example4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class MapToTextFileExample {
    public static void main(String[] args) {
        Map<String, Integer> stockMap = new HashMap<>();
        stockMap.put("apple", 1000);
        stockMap.put("banana", 1500);
        stockMap.put("Cherry", 1200);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("stock.txt"))) {

            for (Map.Entry<String, Integer> entry : stockMap.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();
            }

            // 더 안전한 형식
            // bw.write(entry.getKey() + "=" + entry.getValue());
            // JSON 형식
            // bw.write("\"" + entry.getKey() + "\":" + entry.getValue

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
