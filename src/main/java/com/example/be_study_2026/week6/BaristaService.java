package com.example.be_study_2026.week6;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaristaService {

    private final MenuRepository menuRepository;

    @Transactional
    public void addMenu(String name, int price) {
        Menu menu = new Menu(name, price);
        menuRepository.save(menu);
    }

    @Transactional
    public void updateMenuPrice(Long id, int newPrice) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 메뉴(id = " + id + ")가 없습니다."));

        menu.updatePrice(newPrice);

        // @Transactional 을 통해 save 명시하지 않아도 Spring이 변경을 확인하고 DB를 업데이트
//        menuRepository.save(menu);
    }

    @Transactional
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
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
