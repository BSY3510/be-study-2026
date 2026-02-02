package com.example.be_study_2026.week1;

import java.util.List;

public class Barista {

    private String name;

    public Barista() {}

    public Barista(String name) {
        this.name = name;
    }

    public Menu makeMenu(String coffeeName, List<Menu> menuList) {
        return menuList.stream().filter(m -> m.getName().equals(coffeeName)).findFirst().orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 존재하지 않습니다."));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
