package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.coupon.Coupon;
import me.songha.projectapi.coupon.CouponDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PromotionWithCouponsDto {
    private PromotionDto promotion;
    private List<CouponDto> coupons = new ArrayList<>();

    @Builder
    public PromotionWithCouponsDto(Promotion promotion) {
        this.promotion = new PromotionDto(promotion);
        setCouponDtoList(promotion.getCoupons());
    }

    private void setCouponDtoList(List<Coupon> couponsFromEntity) {
        for (Coupon coupon : couponsFromEntity) {
            CouponDto couponDto = CouponDto.builder()
                    .coupon(coupon)
                    .build();
            coupons.add(couponDto);
        }
    }
}
