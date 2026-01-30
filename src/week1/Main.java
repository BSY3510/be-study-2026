package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        // Map
        String text = "apple banana apple orange banana apple";
        String[] wordList = text.split(" ");
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : wordList) {
            if (wordMap.containsKey(word)) {
                Integer newValue = wordMap.get(word) + 1;
                wordMap.put(word, newValue);
            }
            else {
                wordMap.put(word, 1);
            }
        }
        System.out.println(wordMap);

        // Map 개선1: getOrDefault()
        wordMap = new HashMap<>();
        for (String word : wordList) {
            wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
        }
        System.out.println(wordMap);

        // Map 개선2: Stream
        Map<String, Integer> wordMap2 = Arrays.stream(text.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        System.out.println(wordMap2);

        // Map 개선3: 최적화
        Map<String, Integer> wordMap3 = Arrays.stream(text.split(" ")).collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
        System.out.println(wordMap3);

    }
}
