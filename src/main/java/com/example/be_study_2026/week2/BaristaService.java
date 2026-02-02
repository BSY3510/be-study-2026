package com.example.be_study_2026.week2;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BaristaService {

    private final List<Menu> menuList;

    public BaristaService() {
        this.menuList = new ArrayList<>();
        menuList.add(new Menu("아메리카노", 4000));
        menuList.add(new Menu("라떼", 4500));
        menuList.add(new Menu("콜라", 1500));
    }

    public Menu makeCoffee(String menuName) {
        return menuList.stream().filter(m -> m.getName().equals(menuName)).findFirst().orElseThrow(() -> new IllegalArgumentException("해당 메뉴(" + menuName +")는 없습니다."));
    }

}
