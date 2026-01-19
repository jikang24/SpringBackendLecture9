package org.example.Head05_Algorithm.example4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {
    public static void main(String[] args) {
        // FileReader로 텍스트 파일을 한 글자씩 읽는 예시
        // try-with-resources: 자동으로 close() 호출
        // 프로젝트 루트 경로에 example.txt 파일 위치
        try(FileReader fr = new FileReader("example.txt")) {
            int data;// 한 문자의 ASCII/유니코드 값

            // read()는 한 문자씩 읽음
            // 파일 끝에 도달하면 -1을 반환
            while ((data = fr.read()) != -1){
                System.out.println( (char)data);// 읽은 문자를 출력

                // 10_000자 파일일 경우 10_000 번 디스크에 접근해야 함
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        // FileWriter로 텍스트 파일에 한 글자씩 쓰는 예시
        try(FileWriter fw = new FileWriter("output.txt")){
            String content = "Hello File I/O";
            for (char c : content.toCharArray()) {
                fw.write(c);// 한 문자씩 디스크에 쓰기
                // 매번 디스크 I/O 발생 -> 느림
            }

            fw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
