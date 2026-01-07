package org.example.Head03_OOP.example19;

//import java.io.File;
//import java.io.FileReader;
//
//public class CompileErrorExample {
//    public static void main(String[] args) {
//        FileReader reader = new FileReader("test.txt");
//    }
//}

public class RuntimeErrorExample {
    public static void main(String[] args) {
        int[] scores = {99, 84, 24};
        System.out.println(scores[2]);
    }
}
