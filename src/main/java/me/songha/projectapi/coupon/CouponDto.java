package me.songha.projectapi.coupon;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.ticket.Ticket;
import me.songha.projectapi.ticket.TicketDto;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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
            this.startAt = coupon.getValidDateTime().getStartAt();
            this.endAt = coupon.getValidDateTime().getEndAt();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ResponseWithTickets {
        private Long id;
        private String name;
        private String type;
        private String groupType;
        private int limit;
        private ZonedDateTime startAt;
        private ZonedDateTime endAt;
        private List<TicketDto.Response> tickets;

        @Builder
        public ResponseWithTickets(Coupon coupon) {
            if (coupon == null) return;

            this.id = coupon.getId();
            this.name = coupon.getName();
            this.type = coupon.getType();
            this.groupType = coupon.getGroupType();
            this.limit = coupon.getLimit();
            this.startAt = coupon.getValidDateTime().getStartAt();
            this.endAt = coupon.getValidDateTime().getEndAt();
            setTicketDtoList(coupon.getTickets());
        }

        private void setTicketDtoList(List<Ticket> ticketsFromEntity) {
            tickets = new ArrayList<>();
            for (Ticket ticket : ticketsFromEntity) {
                TicketDto.Response ticketResponse = TicketDto.Response.builder()
                        .ticket(ticket)
                        .build();
                tickets.add(ticketResponse);
            }
        }
    }
}
