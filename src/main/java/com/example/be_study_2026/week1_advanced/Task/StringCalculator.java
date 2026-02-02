package com.example.be_study_2026.week1_advanced.Task;

import java.util.Arrays;

public class StringCalculator {

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private void validPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
    }

    private int toInt(String numberText) {
        try {
            int number = Integer.parseInt(numberText);
            validPositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private String[] textSplit(String text) {
        return text.split("[,:]");
    }

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return Arrays.stream(textSplit(text)).mapToInt(this::toInt).sum();
    }

}
