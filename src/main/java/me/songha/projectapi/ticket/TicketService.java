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
}
