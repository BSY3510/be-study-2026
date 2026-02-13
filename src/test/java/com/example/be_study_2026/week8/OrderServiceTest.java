package com.example.be_study_2026.week8;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("N+1 문제 확인: 주문 내역을 조회하면 쿼리 폭발")
    void checkNPlusOne() {
        System.out.println("=============== [1] 주문 조회 시작 (findAll) ===============");
//        List<Order> orders = orderRepository.findAll();   // N+1 문제 발생
        List<Order> orders = orderRepository.findAllWithFetchJoin();
        System.out.println("=============== [1] 주문 조회 끝 (총 " + orders.size() + "개) ===============");

        System.out.println("=============== [2] 상세 내역 접근 (Lazy Loading) ===============");
        for (Order order : orders) {
            System.out.println("주문자: " + order.getMember().getUsername());

            for (OrderItem orderItem : order.getOrderItems()) {
                System.out.println(" - 메뉴: " + orderItem.getMenu().getName());
            }
        }
        System.out.println("=============== [2] 상세 내역 접근 끝 ===============");
    }

}
