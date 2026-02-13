package com.example.be_study_2026.week9;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> searchOrders(String userName, Integer minPrice);
}
