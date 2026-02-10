package com.example.be_study_2026.week5_advanced;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/pay")
    public String pay(@RequestParam String method, @RequestParam int amount) {
        paymentService.process(method, amount);
        return String.format("%s 방식으로 %d원 결제 요청 완료!", method, amount);
    }
}