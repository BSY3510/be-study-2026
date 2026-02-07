package com.example.be_study_2026.week4_advanced;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListStudy {
    public static void main(String[] args) {

        long start;
        long end;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(50000, -1);
        }
        end = System.nanoTime();
        System.out.println("ArrayList 중간 삽입 나노초: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(50000, -1);
        }
        end = System.nanoTime();
        System.out.println("LinkedList 중간 삽입 나노초: " + (end - start));
    }

}
