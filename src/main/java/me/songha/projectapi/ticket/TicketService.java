package me.songha.projectapi.ticket;

import lombok.RequiredArgsConstructor;
import me.songha.projectapi.common.repository.CommonRepository;
import me.songha.projectapi.coupon.Coupon;
import me.songha.projectapi.coupon.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final CouponRepository couponRepository;
    private final CommonRepository commonRepository;

    public Ticket save(TicketIssuedDto.InsertRequest ticketInsertRequestDto) {
        Coupon coupon = couponRepository.findById(ticketInsertRequestDto.getCouponId()).orElse(null);
        return ticketRepository.save(ticketInsertRequestDto.toEntity(coupon));
    }

    public Ticket update(TicketIssuedDto.UpdateRequest ticketUpdateRequestDto) {
        Ticket ticket = ticketRepository
                .findById(ticketUpdateRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("not found"));

        ticket.updateTicketResult(TicketResult.builder()
                .resultLog(ticketUpdateRequestDto.getResultLog())
                .resultCode(ticketUpdateRequestDto.getResultCode())
                .build());

        return ticketRepository.save(ticket);
    }

    public List<TicketDto> findTicketsByUserIdAndCouponIds(String userId, List<Long> couponIds) {
        return commonRepository.findTicketsByUserIdAndCouponIds(userId, couponIds);
    }

    public List<TicketDto> findTicketsByUserIdAndPromotionId(String userId, Long promotionId) {
        return commonRepository.findTicketsByUserIdAndPromotionId(userId, promotionId);
    }
}
