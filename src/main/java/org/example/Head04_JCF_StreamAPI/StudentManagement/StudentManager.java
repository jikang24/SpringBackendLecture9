package org.example.Head04_JCF_StreamAPI.StudentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private List<Student> students;
    private Set<String> studentNames;
    private Map<String, Integer> scoreMap;

    public StudentManager() {
        students = new ArrayList<>();
        studentNames = new HashSet<>();
        scoreMap = new HashMap<>();
    }
    public void addStudent(Student student, int score) {
        if (studentNames.contains(student.getName())){
            System.out.println("[Error] 이미 존재하는 학생 이름입니다.");
            return;
        }

        students.add(student);
        studentNames.add(student.getName());
        scoreMap.put(student.getName(), score);
        System.out.println("[Info] 새로운 학생이 등록 되었습니다: " + student);

    }

    public void removeStudent (String name){
        Student target = null;
        for (Student s : students) {
            if(s.getName().equals(name)){
                target = s;
                break;
            }
        }if(target != null) {
            students.remove(target);
            studentNames.remove(name);
            scoreMap.remove(name);
            System.out.println("[Info] 학생이 삭제 되었습니다: " + name);
        }else {
            System.out.println("[Error] 해당 이름의 학생을 찾을 수 없습니다.");
        }

    }public void printAllStudents(){
        System.out.println("=== 학생 목록 ===");
        for (Student s : students) {
            System.out.println(s);
        }
    }public void printScore(String name){
        Integer score = scoreMap.get(name);
        if (score != null) {
            System.out.println("[Info] " + name + "의 점수" + score );
        }else {
            System.out.println("[Error] 점수를 찾을 수 없습니다." );
        }
    }

}
