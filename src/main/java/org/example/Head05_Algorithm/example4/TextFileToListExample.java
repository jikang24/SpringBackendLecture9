package org.example.Head05_Algorithm.example4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileToListExample {
    public static void main(String[] args) {
        List<String> loadedItems = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("items.txt"))) {
            String line;

            while ((line = br.readLine()) != null){
                if(!line.trim().isEmpty()){
                    loadedItems.add(line);
                }
                if(line.startsWith("#")) continue;

//                if(!isValidData(line)) continue;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("로드된 리스트: " + loadedItems);
    }

}
