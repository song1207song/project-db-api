package me.songha.projectapi.coupon;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.ticket.Ticket;
import me.songha.projectapi.ticket.TicketDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponWithTicketsDto {
    private CouponDto coupon;
    private List<TicketDto.Response> tickets = new ArrayList<>();

    @Builder
    public CouponWithTicketsDto(Coupon coupon) {
        this.coupon = new CouponDto(coupon);
        setTicketDtoList(coupon.getTickets());
    }

    private void setTicketDtoList(List<Ticket> ticketsFromEntity) {
        for (Ticket ticket : ticketsFromEntity) {
            TicketDto.Response ticketResponse = TicketDto.Response.builder()
                    .ticket(ticket)
                    .build();
            tickets.add(ticketResponse);
        }
    }

    public int getRemaining() {
        return coupon.getLimit() - tickets.size();
    }
}
