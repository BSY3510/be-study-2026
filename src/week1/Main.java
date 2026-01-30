package week1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("James", 85));
        studentList.add(new Student("Kim", 60));
        studentList.add(new Student("Park", 70));
        studentList.add(new Student("Lee", 90));
        studentList.add(new Student("Kate", 75));

        // 기능1: 점수가 80점 이상인 학생의 이름만 출력
        System.out.println("[80점 이상인 학생 명단]");
        for (Student student : studentList) {
            if (student.getScore() >= 80) {
                System.out.println(student.getName());
            }
        }

        // 기능1 스트림 버전
        studentList.stream().filter(student -> student.getScore() >= 80).map(s -> s.getName()).forEach(s -> System.out.println(s));
        // 기능1 스트림 버전 - 람다 단축키
        studentList.stream().filter(student -> student.getScore() >= 80).map(Student::getName).forEach(System.out::println);

        System.out.println();

        // 기능2 5명 점수의 평균을 구해서 출력
        double mean_score = 0;
        for (Student student : studentList) {
            mean_score += student.getScore();
        }
        System.out.printf("학생 평균점수: %.2f\n", mean_score/studentList.size());

        // 기능2 스트림 버전
        double meanScoreStream = studentList.stream().mapToInt(Student::getScore).average().orElse(0.0);
        System.out.printf("학생 평균점수: %.2f\n", meanScoreStream);

    }
}
