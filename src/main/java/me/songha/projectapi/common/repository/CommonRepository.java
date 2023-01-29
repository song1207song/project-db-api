package me.songha.projectapi.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommonRepository {
    private final JPAQueryFactory jpaQueryFactory;

//    public PromotionDto.ResponseWithCouponsAndTickets searchPromotionWithCoupons(Long id) {
//        return jpaQueryFactory
//                .select(new QPromotionDto_ResponseWithCouponsAndTickets(
//                        promotion.id,
//                        promotion.name,
//                        promotion.title,
//                        promotion.validDateTime.startAt,
//                        promotion.validDateTime.endAt,
//                        promotion.coupons
//                ))
//                .from(promotion)
//                .innerJoin(promotion.coupons, coupon)
//                .where(promotion.id.eq(id))
//                .fetchFirst();
//    }

}
