package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.common.model.DateTime;
import me.songha.projectapi.coupon.Coupon;

import java.util.List;

public class PromotionDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private String name;
        private List<Coupon> coupons;
        private DateTime dateTime;

        public Response(Promotion promotion) {
            this.name = promotion.getName();
            this.dateTime = promotion.getDateTime();
            this.coupons = promotion.getCoupons();
        }
    }

}
