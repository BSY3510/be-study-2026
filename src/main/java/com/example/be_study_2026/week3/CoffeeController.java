package com.example.be_study_2026.week3;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoffeeController {

    private final BaristaService baristaService;

    @GetMapping("/order")
    public Menu orderCoffee(@RequestParam(value = "name") String menuName) {
        return baristaService.makeCoffee(menuName);
    }

    @GetMapping("/menus")
    public List<Menu> getMenus() {
        return baristaService.getAllMenus();
    }

    @PostMapping("/admin/menu")
    public String addMenu(@RequestBody MenuRequest request) {
        baristaService.addMenu(request.name, request.price);
        return "메뉴 등록 완료: " + request.name;
    }

    public record MenuRequest(String name, int price) {}
}
