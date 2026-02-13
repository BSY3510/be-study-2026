package com.example.be_study_2026.week9;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("QueryDSL 동적 쿼리: 이름이 있으면 이름으로 검색, 없으면 전체 조회")
    void dynamicQuery() {
        // 1. 이름으로 검색
        List<Order> result1 = orderRepository.searchOrders("user01", null);
        System.out.println("결과1 개수: " + result1.size());

        // 2. 검색 조건 없음 -> 전체 조회
        List<Order> result2 = orderRepository.searchOrders(null, null);
        System.out.println("결과2 개수: " + result2.size());
    }

}
