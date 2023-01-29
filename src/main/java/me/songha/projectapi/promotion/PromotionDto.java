package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PromotionDto {
    private Long id;
    private String name;
    private String title;
    private ZonedDateTime startAt;
    private ZonedDateTime endAt;

    @Builder
    public PromotionDto(Promotion promotion) {
        this.id = promotion.getId();
        this.name = promotion.getName();
        this.title = promotion.getTitle();
        this.startAt = promotion.getValidDateTime().getStartAt();
        this.endAt = promotion.getValidDateTime().getEndAt();
    }

//    public static class ResponseWithCoupons {
//        private Long id;
//        private String name;
//        private String title;
//        private ValidDateTime validDateTime;
//        private List<CouponDto> coupons;
//
//        @Builder
//        public ResponseWithCoupons(Promotion promotion) {
//            if (promotion == null) return;
//
//            this.id = promotion.getId();
//            this.name = promotion.getName();
//            this.title = promotion.getTitle();
//            this.validDateTime = promotion.getValidDateTime();
//            setCouponDtoList(promotion.getCoupons());
//        }
//
//        private void setCouponDtoList(List<Coupon> couponsFromEntity) {
//            coupons = new ArrayList<>();
//            for (Coupon coupon : couponsFromEntity) {
//                CouponDto.Response couponResponse = CouponDto.Response.builder()
//                        .coupon(coupon)
//                        .build();
//                coupons.add(couponResponse);
//            }
//        }
//    }

//    @Getter
//    @NoArgsConstructor(access = AccessLevel.PROTECTED)
//    public static class ResponseWithCouponsAndTickets {
//        private Long id;
//        private String name;
//        private String title;
//        private ZonedDateTime startAt;
//        private ZonedDateTime endAt;
//        private List<Coupon> coupons;
//
//        @QueryProjection
//        public ResponseWithCouponsAndTickets(Long id, String name, String title
//                , ZonedDateTime startAt, ZonedDateTime endAt
//                , List<Coupon> coupons) {
//            this.id = id;
//            this.name = name;
//            this.title = title;
//            this.startAt = startAt;
//            this.endAt = endAt;
//            this.coupons = coupons;
//        }
//    }

    //    @Getter
//    @NoArgsConstructor(access = AccessLevel.PROTECTED)
//    public static class ResponseWithCouponsAndTickets {
//        private Long id;
//        private String name;
//        private String title;
//        private ValidDateTime validDateTime;
//        private List<CouponDto.ResponseWithTickets> couponsWithTickets;
//
//        @Builder
//        public ResponseWithCouponsAndTickets(Promotion promotion) {
//            if (promotion == null) return;
//
//            this.id = promotion.getId();
//            this.name = promotion.getName();
//            this.title = promotion.getTitle();
//            this.validDateTime = promotion.getValidDateTime();
//            setCouponDtoList(promotion.getCoupons());
//        }

//        private void setCouponDtoList(List<Coupon> couponsFromEntity) {
//            couponsWithTickets = new ArrayList<>();
//            for (Coupon coupon : couponsFromEntity) {
//                CouponDto.ResponseWithTickets couponResponse = CouponDto.ResponseWithTickets.builder()
//                        .coupon(coupon)
//                        .build();
//                couponsWithTickets.add(couponResponse);
//            }
//        }
//    }
}
