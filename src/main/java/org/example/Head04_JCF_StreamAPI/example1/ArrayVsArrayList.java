package org.example.Head04_JCF_StreamAPI.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayVsArrayList {
    public static void main(String[] args) {
        // Array 예시
        int[] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        System.out.println("Array: " + Arrays.toString(arr));
//         arr[3] = 40; -> 런티암 에러 ArrayIndexOutOfBoundException

        //ArrayList 예시
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("ArrayList: " + list);
        list.remove(Integer.valueOf(20));
        System.out.println("removed 20 -> " + list);

    }
}
