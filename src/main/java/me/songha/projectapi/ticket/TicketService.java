package me.songha.projectapi.ticket;

import lombok.RequiredArgsConstructor;
import me.songha.projectapi.coupon.Coupon;
import me.songha.projectapi.coupon.CouponRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final CouponRepository couponRepository;

    public Ticket save(TicketDto.InsertRequest ticketInsertRequestDto) {
        Coupon coupon = couponRepository.findById(ticketInsertRequestDto.getCouponId()).orElse(null);
        return ticketRepository.save(ticketInsertRequestDto.toEntity(coupon));
    }

    public Ticket update(TicketDto.UpdateRequest ticketUpdateRequestDto) {
        Ticket ticket = ticketRepository
                .findById(ticketUpdateRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("not found"));

        ticket.updateTicketResult(TicketResult.builder()
                .resultLog(ticketUpdateRequestDto.getResultLog())
                .resultCode(ticketUpdateRequestDto.getResultCode())
                .build());

        return ticketRepository.save(ticket);
    }
}
