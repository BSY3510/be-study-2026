package com.example.be_study_2026.week2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

}
