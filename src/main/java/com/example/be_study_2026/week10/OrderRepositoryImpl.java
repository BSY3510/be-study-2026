package com.example.be_study_2026.week10;

import static com.example.be_study_2026.week9.QMember.member;
import static com.example.be_study_2026.week9.QOrder.order;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Order> searchOrders(String userNameParam, Integer minPriceParam) {
        return queryFactory
            .selectFrom(order)
            .join(order.member, member)
            .where(
                userNameEq(userNameParam),
                minPriceGoe(minPriceParam)
            )
            .fetch();
    }

    private BooleanExpression userNameEq(String userName) {
        return userName != null ? member.username.eq(userName) : null;
    }

    private BooleanExpression minPriceGoe(Integer minPrice) {
        return null;
    }

}
