package com.example.be_study_2026.week1_advanced.Task;

public class CalculatorTest {
    public static void main(String[] args) {
        StringCalculator cal = new StringCalculator();

        // 테스트 케이스 1
        int result = cal.add("1,2");
        if (result == 3) System.out.println("Test 1 Passed");
        else System.out.println("Test 1 Failed");

        // 테스트 케이스 2
        result = cal.add("1:2");
        if (result == 3) System.out.println("Test 2 Passed");
        else System.out.println("Test 2 Failed");

        // 테스트 케이스 3
        result = cal.add("1,2:3");
        if (result == 6) System.out.println("Test 3 Passed");
        else System.out.println("Test 3 Failed");

    }

}
