package org.example.Head03_OOP.example16;

public class EnumBasicTest {
    public enum LevelType {
        DEBUG, INFO, WARN, ERROR
    }

    public static void main(String[] args) {
        for (LevelType lvl : LevelType.values()) {
            System.out.println(lvl + "ordinal = " + lvl.ordinal());
        }
        LevelType today = LevelType.DEBUG;
        System.out.println("name(): " + today.name());
    }


}
