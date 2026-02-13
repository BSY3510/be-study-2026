package com.example.be_study_2026.week9;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public Long order(OrderRequest request) {
        Member member = memberRepository.findById(request.memberId()).orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderRequest.OrderItemRequest itemRequest : request.items()) {
            Menu menu = menuRepository.findById(itemRequest.menuId()).orElseThrow(() -> new IllegalArgumentException("메뉴가 없습니다."));
            OrderItem orderItem = OrderItem.createOrderItem(menu, itemRequest.count());
            orderItems.add(orderItem);
        }

        Order order = Order.createOrder(member, orderItems);

        orderRepository.save(order);

        return order.getId();
    }

}
