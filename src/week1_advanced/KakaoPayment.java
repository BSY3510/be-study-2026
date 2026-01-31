package week1_advanced;

public class KakaoPayment implements PaymentMethod{

    @Override
    public void pay(int amount) {
        System.out.printf("카카오페이로 %d원 결제합니다.\n", amount);
    }
}
