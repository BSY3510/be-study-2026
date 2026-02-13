package com.example.be_study_2026.week8;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o " +
            "join fetch o.member " +
            "join fetch o.orderItems oi " +
            "join fetch oi.menu")
    List<Order> findAllWithFetchJoin();

}
