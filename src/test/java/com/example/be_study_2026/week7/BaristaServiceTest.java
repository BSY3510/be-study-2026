package com.example.be_study_2026.week7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class BaristaServiceTest {

    @Autowired
    private BaristaService baristaService;

    @Autowired
    private MenuRepository menuRepository;

    @AfterEach
    void tearDown() {
        menuRepository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        menuRepository.deleteAll();
    }

    @Test
    @DisplayName("메뉴 등록 및 조회 테스트")
    @Transactional
    void addMenu() {
        // given (준비)
        String name = "카페모카";
        int price = 5000;
        int quantity = 10;

        // when (실행)
        baristaService.addMenu(name, price, quantity);

        // then (검증)
        Menu findMenu = menuRepository.findByName(name).orElseThrow();
        
        assertThat(findMenu).isNotNull();                   // 메뉴가 없으면 안됨
        assertThat(findMenu.getName()).isEqualTo(name);     // 이름이 같아야 함
        assertThat(findMenu.getPrice()).isEqualTo(price);   // 가격이 같아야 함

    }

    @Test
    @DisplayName("동시에 100명이 주문을 해도 재고는 정확히 줄어들어야 함")
    void concurrentOrder() throws InterruptedException {
        // given
        String menuName = "아메리카노";
        baristaService.addMenu(menuName, 4000, 100);

        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        // when
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    baristaService.orderCoffee(menuName);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();

        // then
        List<Menu> allMenus = menuRepository.findAll();
        Menu findMenu = allMenus.get(0);

        assertThat(findMenu.getName()).isEqualTo(menuName);
        assertThat(findMenu.getQuantity()).isEqualTo(0);

    }

}