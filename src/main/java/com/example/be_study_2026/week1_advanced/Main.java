package com.example.be_study_2026.week1_advanced;

public class Main {
    public static void main(String[] args) {
        KakaoPayment kakaoPayment = new KakaoPayment();
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        PaymentService paymentService = new PaymentService();

        paymentService.process(kakaoPayment, 2000);
        paymentService.process(creditCardPayment, 5000);
    }
}
