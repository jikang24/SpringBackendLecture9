package org.example.Head03_OOP.example12;

public class Main{
    public static void main(String[] args) {
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.printValues();

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.printInstanceValue();
    }
}
