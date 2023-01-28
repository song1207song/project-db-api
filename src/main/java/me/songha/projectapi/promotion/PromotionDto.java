package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.coupon.Coupon;
import me.songha.projectapi.coupon.CouponDto;

import java.util.ArrayList;
import java.util.List;

public class PromotionDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long id;
        private String name;
        private List<CouponDto.Response> coupons;

        public Response(Promotion promotion) {
            if (promotion == null) return;

            this.id = promotion.getId();
            this.name = promotion.getName();
            setCouponDtoList(promotion.getCoupons());
        }

        private void setCouponDtoList(List<Coupon> couponsFromEntity) {
            coupons = new ArrayList<>();
            for (Coupon coupon : couponsFromEntity) {
                CouponDto.Response couponResponse = CouponDto.Response.builder()
                        .coupon(coupon)
                        .build();
                coupons.add(couponResponse);
            }
        }
    }

}
