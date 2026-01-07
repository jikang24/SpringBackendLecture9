package org.example.Head03_OOP.example12;

public class Outer {
    private static int staticValue = 100;
    private int instanceValue = 200;

    public static class  StaticNested{
        public void printValues(){
            System.out.println("Outer.staticValue: " + staticValue);
//          System.out.println("instance Value = : " + new Outer().instanceValue);
        }
    }
    public class Inner {
        public void printInstanceValue(){
            System.out.println("Outer instanceValue: " + instanceValue);
        }
    }
}
