package com.example.be_study_2026.week3;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaristaService {

    private final MenuRepository menuRepository;

    public void addMenu(String name, int price) {
        Menu menu = new Menu(name, price);
        menuRepository.save(menu);
    }

    public Menu makeCoffee(String menuName) {
        // 메모리 측면 비효율적인 방법
//        List<Menu> menus = menuRepository.findAll();
//        return menus.stream().filter((menu) -> menu.getName().equals(menuName)).findFirst().orElseThrow(() -> new IllegalArgumentException("해당 메뉴(" + menuName + ")는 없습니다."));
        return menuRepository.findByName(menuName).orElseThrow(() -> new IllegalArgumentException("해당 메뉴(" + menuName + ")는 없습니다."));
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

}
