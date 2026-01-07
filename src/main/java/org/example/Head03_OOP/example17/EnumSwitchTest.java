package org.example.Head03_OOP.example17;

public class EnumSwitchTest {
    public enum OredrStatus {
        Ordered, Ready, Delivered
    }

    public static void printStatus(OredrStatus status){
        switch (status){
            case Ordered :
                System.out.println("주문됨");
                break;
            case Ready :
                System.out.println("준비됨");
                break;
            case Delivered :
                System.out.println("배달됨");
                break;
        }
    }

    public static void main(String[] args) {
        printStatus(OredrStatus.Ordered);
    }
}
