package me.songha.projectapi.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.songha.projectapi.coupon.CouponWithRewardLeftDto;
import me.songha.projectapi.coupon.QCouponWithRewardLeftDto;
import me.songha.projectapi.ticket.QTicketDto;
import me.songha.projectapi.ticket.TicketDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.songha.projectapi.coupon.QCoupon.coupon;
import static me.songha.projectapi.ticket.QTicket.ticket;

@Repository
@RequiredArgsConstructor
public class CommonRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<TicketDto> findTicketsByUserIdAndCouponIds(String userId, List<Long> couponIds) {
        return jpaQueryFactory.select(
                        new QTicketDto(ticket.id,
                                ticket.userId,
                                ticket.coupon,
                                ticket.dateTime.createdAt,
                                ticket.dateTime.updatedAt)
                )
                .from(ticket)
                .innerJoin(ticket.coupon, coupon)
                .where(coupon.id.in(couponIds)
                        .and(ticket.userId.eq(userId)))
                .fetch();
    }

    public List<TicketDto> findTicketsByUserIdAndPromotionId(String userId, Long promotionId) {
        return jpaQueryFactory.select(
                        new QTicketDto(ticket.id,
                                ticket.userId,
                                ticket.coupon,
                                ticket.dateTime.createdAt,
                                ticket.dateTime.updatedAt)
                )
                .from(ticket)
                .innerJoin(ticket.coupon, coupon)
                .where(coupon.promotion.id.eq(promotionId)
                        .and(ticket.userId.eq(userId)))
                .fetch();
    }

    public List<CouponWithRewardLeftDto> findCouponsWithRewardLeft(String userId, Long promotionId) {
        return jpaQueryFactory.select(
                        new QCouponWithRewardLeftDto(ticket.coupon, ticket.count().as("issuedAmount"))
                )
                .from(ticket)
                .innerJoin(ticket.coupon, coupon)
                .where(coupon.promotion.id.eq(promotionId)
                        .and(ticket.userId.eq(userId)))
                .groupBy(coupon.id)
                .fetch();
    }

}
