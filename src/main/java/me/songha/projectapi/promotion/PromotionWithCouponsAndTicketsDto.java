package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.coupon.Coupon;
import me.songha.projectapi.coupon.CouponWithTicketsDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PromotionWithCouponsAndTicketsDto {
    private PromotionDto promotion;
    private List<CouponWithTicketsDto> coupons = new ArrayList<>();

    @Builder
    public PromotionWithCouponsAndTicketsDto(Promotion promotion) {
        this.promotion = new PromotionDto(promotion);
        setCouponWithTicketsDtoList(promotion.getCoupons());
    }

    private void setCouponWithTicketsDtoList(List<Coupon> couponsFromEntity) {
        for (Coupon coupon : couponsFromEntity) {
            CouponWithTicketsDto couponWithTicketsDto = CouponWithTicketsDto.builder()
                    .coupon(coupon)
                    .build();
            coupons.add(couponWithTicketsDto);
        }
    }
}
