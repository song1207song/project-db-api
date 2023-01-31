package me.songha.projectapi.common.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.songha.projectapi.ticket.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.songha.projectapi.coupon.QCoupon.coupon;
import static me.songha.projectapi.ticket.QTicket.ticket;

@Repository
@RequiredArgsConstructor
public class CommonRepository {
    private final JPAQueryFactory jpaQueryFactory;

    /*
        select
        ticket0_.id as id1_2_,
        ticket0_.coupon_id as coupon_i7_2_,
        ticket0_.created_at as created_2_2_,
        ticket0_.updated_at as updated_3_2_,
        ticket0_.result_code as result_c4_2_,
        ticket0_.result_log as result_l5_2_,
        ticket0_.user_id as user_id6_2_
    from
        ticket ticket0_
    inner join
        coupon coupon1_
            on ticket0_.coupon_id=coupon1_.id
    where
        (
            coupon1_.id in (? , ? , ?)
        )
        and ticket0_.user_id=?

     */
    public List<Tuple> findTicketsByUserIdAndCouponIds(String userId, List<Long> couponIds) {
        return jpaQueryFactory.select(ticket, coupon)
                .from(ticket)
                .innerJoin(ticket.coupon, coupon)
                .where(coupon.id.in(couponIds)
                        .and(ticket.userId.eq(userId)))
                .fetch();
    }

    // Tuple 이 service 계층이나 controller 계층에까지 쓰이는건 좋지 않은 디자인
    // 그러므로 dto 를 사용하는 것이 좋음
    // @QueryProjection 를 사용하면 QClass 를 만들수 있어서 좋음
    // 대신에 전반 계층에 걸쳐 querydsl 의존도가 높아진다는 단점이 있음

}
