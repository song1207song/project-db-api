package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.common.model.ValidDateTime;
import me.songha.projectapi.coupon.Coupon;
import me.songha.projectapi.coupon.CouponDto;

import java.util.ArrayList;
import java.util.List;

public class PromotionDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ResponseWithCoupons {
        private Long id;
        private String name;
        private String title;
        private ValidDateTime validDateTime;
        private List<CouponDto.Response> coupons;

        @Builder
        public ResponseWithCoupons(Promotion promotion) {
            if (promotion == null) return;

            this.id = promotion.getId();
            this.name = promotion.getName();
            this.title = promotion.getTitle();
            this.validDateTime = promotion.getValidDateTime();
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

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ResponseWithCouponsAndTickets {
        private Long id;
        private String name;
        private String title;
        private ValidDateTime validDateTime;
        private List<CouponDto.ResponseWithTickets> couponsWithTickets;

        @Builder
        public ResponseWithCouponsAndTickets(Promotion promotion) {
            if (promotion == null) return;

            this.id = promotion.getId();
            this.name = promotion.getName();
            this.title = promotion.getTitle();
            this.validDateTime = promotion.getValidDateTime();
            setCouponDtoList(promotion.getCoupons());
        }

        private void setCouponDtoList(List<Coupon> couponsFromEntity) {
            couponsWithTickets = new ArrayList<>();
            for (Coupon coupon : couponsFromEntity) {
                CouponDto.ResponseWithTickets couponResponse = CouponDto.ResponseWithTickets.builder()
                        .coupon(coupon)
                        .build();
                couponsWithTickets.add(couponResponse);
            }
        }
    }
}
