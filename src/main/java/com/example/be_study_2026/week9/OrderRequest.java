package com.example.be_study_2026.week9;

import java.util.List;

public record OrderRequest(Long memberId, List<OrderItemRequest> items) {

    public record OrderItemRequest(Long menuId, int count) {

    }
}
