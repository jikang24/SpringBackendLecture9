package org.example.Head05_Algorithm.GameSavePractice;

import java.io.*;
import java.time.LocalDateTime;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    private String playerName;
    private int level;
    private int experience;
    private int gold;
    private LocalDateTime saveTime;

    private transient boolean isPaused;
//    private transient boolean isDead;
    private transient int fps;

    public GameState(String playerName) {
        this.playerName = playerName;
        this.level = 1;
        this.experience = 0;
        this.gold = 100;
        this.saveTime = LocalDateTime.now();
    }

    public static void save(GameState state, String fileName){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            System.out.println("게임이 저장되었습니다: " + fileName);

        }catch (IOException e){
            System.err.println("저장 실패: " + e.getMessage());
        }
    }

    public static GameState load(String fileName){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (GameState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("로드 실패: " + e.getMessage());
            return null;
        }
    }
}
