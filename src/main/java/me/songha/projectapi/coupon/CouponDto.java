package me.songha.projectapi.coupon;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

public class CouponDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long id;
        private String name;
        private String type;
        private String groupType;
        private int limit;
        private ZonedDateTime startAt;
        private ZonedDateTime endAt;

        @Builder
        public Response(Coupon coupon) {
            if (coupon == null) return;

            this.id = coupon.getId();
            this.name = coupon.getName();
            this.type = coupon.getType();
            this.groupType = coupon.getGroupType();
            this.limit = coupon.getLimit();
            this.startAt = coupon.getStartAt();
            this.endAt = coupon.getEndAt();
        }

    }

}
