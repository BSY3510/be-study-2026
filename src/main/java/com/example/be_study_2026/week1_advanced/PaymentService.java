package com.example.be_study_2026.week1_advanced;

public class PaymentService {
    public void process(PaymentMethod method, int amount) {
        method.pay(amount);
    }
}
