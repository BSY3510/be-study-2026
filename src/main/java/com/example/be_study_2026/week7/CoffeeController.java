package com.example.be_study_2026.week7;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoffeeController {

    private final BaristaService baristaService;

    @GetMapping("/order")
    public Menu orderCoffee(@RequestParam(value = "name") String menuName) {
        return baristaService.orderCoffee(menuName);
    }

    @GetMapping("/menus")
    public List<Menu> getMenus() {
        return baristaService.getAllMenus();
    }

    @PostMapping("/admin/menu")
    public String addMenu(@RequestBody MenuRequest request) {
        baristaService.addMenu(request.name(), request.price(), request.quantity());
        return "메뉴 등록 완료: " + request.name;
    }

    @PutMapping("/admin/menu/{id}")
    public String updateMenu(@PathVariable Long id, @RequestBody MenuRequest request) {
        baristaService.updateMenuPrice(id, request.price());
        return "메뉴 가격 수정 완료";
    }

    @DeleteMapping("/admin/menu/{id}")
    public String deleteMenu(@PathVariable Long id) {
        baristaService.deleteMenu(id);
        return "메뉴 삭제 완료";
    }

    public record MenuRequest(String name, int price, int quantity) {}
}
