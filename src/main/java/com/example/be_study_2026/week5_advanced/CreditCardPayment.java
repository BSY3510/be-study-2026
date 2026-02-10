package com.example.be_study_2026.week5_advanced;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(int amount) {
        System.out.printf("신용카드로 %d원 결제합니다.\n", amount);
    }
}
