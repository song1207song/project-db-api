package me.songha.projectapi.promotion;

import lombok.RequiredArgsConstructor;
import me.songha.projectapi.common.model.TicketSearchCondition;
import me.songha.projectapi.common.repository.CommonRepository;
import me.songha.projectapi.ticket.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;
    private final CommonRepository commonRepository;

    public Promotion findById(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }

//    public Promotion findWithCouponsAndMyTickets(TicketSearchCondition condition) {
//        List<Ticket> myTickets = commonRepository.findTicketsByUserIdAndCouponIds(condition.getUserId(), condition.getCouponIds());
//        return ;
//    }

}
