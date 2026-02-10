package com.example.be_study_2026.week5_advanced;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final Map<String, PaymentMethod> paymentMethods;

    public PaymentService(Map<String, PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void process(String payMethod, int amount) {
        PaymentMethod method = paymentMethods.get(payMethod + "Payment");

        if (method == null) {
            throw new IllegalArgumentException("지원하지 않는 결제 수단입니다: " + payMethod);
        }
        method.pay(amount);
    }
}
