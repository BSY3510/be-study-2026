package com.example.be_study_2026.week10;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private int orderPrice;

    private int count;

    public static OrderItem createOrderItem(Menu menu, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.menu = menu;
        orderItem.orderPrice = menu.getPrice();
        orderItem.count = count;

        menu.decreaseQuantity(count);
        return orderItem;
    }

    public void cancel() {
        getMenu().addQuantity(count);
    }

    protected void setOrder(Order order) {
        this.order = order;
    }

}
