package week1_advanced;

public class Main {
    public static void main(String[] args) {
        KakaoPayment kakaoPayment = new KakaoPayment();
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        PaymentService paymentService = new PaymentService();

        paymentService.process(kakaoPayment, 2000);
        paymentService.process(creditCardPayment, 5000);
    }
}
