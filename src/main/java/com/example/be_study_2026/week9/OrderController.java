package com.example.be_study_2026.week9;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public String createOrder(@RequestBody OrderRequest request) {
        Long orderId = orderService.order(request);
        return "주문 완료, 주문 번호: " + orderId;
    }

}
