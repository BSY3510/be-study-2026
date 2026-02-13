package com.example.be_study_2026.week10;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// 아직 회원가입 기능이 없기에 서버 실행 시 DB에 계정 넣는 코드 생성
@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Menu menu1 = new Menu("아메리카노", 4000, 100);
        Menu menu2 = new Menu("라떼", 4500, 100);

        Member member1 = new Member(
            "user01",
            passwordEncoder.encode("1234"),
            "USER"
        );
        Member member2 = new Member(
            "user02",
            passwordEncoder.encode("1234"),
            "USER"
        );

        if (memberRepository.findByUsername("admin").isEmpty()) {
            memberRepository.save(new Member(
                "admin",
                passwordEncoder.encode("1234"),
                "ADMIN"
            ));
        }
        if (memberRepository.findByUsername("user01").isEmpty()) {
            memberRepository.save(member1);
        }
        if (memberRepository.findByUsername("user02").isEmpty()) {
            memberRepository.save(member2);
        }
        if (menuRepository.count() == 0) {
            menuRepository.save(menu1);
            menuRepository.save(menu2);
        }

        if (orderRepository.count() == 0) {
            OrderItem item1 = OrderItem.createOrderItem(menu1, 2);
            OrderItem item2 = OrderItem.createOrderItem(menu2, 1);
            OrderItem item3 = OrderItem.createOrderItem(menu1, 1);

            Order order1 = Order.createOrder(member1, List.of(item1, item2));
            Order order2 = Order.createOrder(member2, List.of(item3));

            orderRepository.saveAll(List.of(order1, order2));
        }

        System.out.println("========== 초기 데이터 세팅 완료 ==========");
    }

}
