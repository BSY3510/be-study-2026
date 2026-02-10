package com.example.be_study_2026.week5_advanced;

import org.springframework.stereotype.Component;

@Component
public class KakaoPayment implements PaymentMethod {

    @Override
    public void pay(int amount) {
        System.out.printf("카카오페이로 %d원 결제합니다.\n", amount);
    }
}
