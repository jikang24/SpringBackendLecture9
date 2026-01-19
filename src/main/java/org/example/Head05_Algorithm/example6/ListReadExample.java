package org.example.Head05_Algorithm.example6;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.List;

public class ListReadExample {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.ser"))) {

            // 제네릭 타입 캐스팅 -> 안전성 경고가 나옴
            // @SuppressWarnings("unchecked")
            List<User> loadedList = (List<User>) ois.readObject();
            System.out.println("역직렬화된 리스트:");
            for (User user : loadedList) {
                System.out.println(user);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
