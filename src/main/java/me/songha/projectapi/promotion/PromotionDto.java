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
            this.coupons = couponDtoList(promotion.getCoupons());
        }

        private List<CouponDto.Response> couponDtoList(List<Coupon> coupons) {
            List<CouponDto.Response> couponResponseList = new ArrayList<>();
            for (Coupon coupon : coupons) {
                CouponDto.Response couponResponse = CouponDto.Response.builder()
                        .coupon(coupon)
                        .build();
                couponResponseList.add(couponResponse);
            }
            return couponResponseList;
        }
    }

}
