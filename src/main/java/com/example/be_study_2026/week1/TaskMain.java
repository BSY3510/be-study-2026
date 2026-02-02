package com.example.be_study_2026.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Barista barista = new Barista("barista1");
        Customer customer = new Customer("customer1");

        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("아메리카노", 4000));
        menuList.add(new Menu("라떼", 4500));

        System.out.print("원하시는 메뉴를 말해주세요: ");
        String coffeeName = sc.next();

        Menu menu = customer.order(barista, coffeeName, menuList);
        System.out.println("<주문 정보>");
        System.out.printf("메뉴명: %s\n", menu.getName());
        System.out.printf("가격: %d\n", menu.getPrice());

        sc.close();
    }

}
