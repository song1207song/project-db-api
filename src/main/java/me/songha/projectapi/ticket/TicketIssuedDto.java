package me.songha.projectapi.ticket;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.coupon.Coupon;
import me.songha.projectapi.coupon.CouponDto;

import java.time.ZonedDateTime;

public class TicketIssuedDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long id;
        private String userId;
        private String resultCode;
        private String resultLog;
        private CouponDto coupon;
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;

        @Builder
        public Response(Ticket ticket) {
            if (ticket == null) return;

            this.id = ticket.getId();
            this.userId = ticket.getUserId();
            this.coupon = new CouponDto(ticket.getCoupon());

            if (ticket.getTicketResult() != null) {
                this.resultCode = ticket.getTicketResult().getResultCode();
                this.resultLog = ticket.getTicketResult().getResultLog();
            }

            if (ticket.getDateTime() != null) {
                this.createdAt = ticket.getDateTime().getCreatedAt();
                this.updatedAt = ticket.getDateTime().getUpdatedAt();
            }
        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class InsertRequest {
        private String userId;
        private Long couponId;

        @Builder
        public InsertRequest(String userId, Long couponId) {
            this.userId = userId;
            this.couponId = couponId;
        }

        public Ticket toEntity(Coupon coupon) {
            return Ticket.builder()
                    .userId(userId)
                    .coupon(coupon)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdateRequest {
        private Long id;
        private String resultCode;
        private String resultLog;

        @Builder
        public UpdateRequest(Ticket ticket) {
            if (ticket == null) return;

            this.id = ticket.getId();
            this.resultCode = ticket.getTicketResult().getResultCode();
            this.resultLog = ticket.getTicketResult().getResultLog();
        }

    }
}
