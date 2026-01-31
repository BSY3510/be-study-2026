package week1_advanced;

public class PaymentService {
    public void process(PaymentMethod method, int amount) {
        method.pay(amount);
    }
}
