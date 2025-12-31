package org.example.Head02_JavaProgramming;

public class ReferenceExample {
    public static void main(String[] args){
        int a = 10;
        int b = a;
        b = 20;

        System.out.println(a);

         int[] arr1 = {1,2,3};
         int[] arr2 = arr1;
         arr2[0] = 100;

         System.out.println(arr1[0]);




    }
}
