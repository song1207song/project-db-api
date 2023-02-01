package me.songha.projectapi.ticket;

import lombok.RequiredArgsConstructor;
import me.songha.projectapi.common.model.TicketSearchCondition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public TicketIssuedDto.Response save(@RequestBody TicketIssuedDto.InsertRequest ticketInsertRequestDto) {
        return new TicketIssuedDto.Response(ticketService.save(ticketInsertRequestDto));
    }

    @PatchMapping
    public TicketIssuedDto.Response update(@RequestBody TicketIssuedDto.UpdateRequest ticketUpdateRequestDto) {
        return new TicketIssuedDto.Response(ticketService.update(ticketUpdateRequestDto));
    }

    @GetMapping("/my/tickets")
    public List<TicketDto> findTicketsByUserIdAndCouponIds(TicketSearchCondition condition) {
        return ticketService.findTicketsByUserIdAndCouponIds(condition.getUserId(), condition.getCouponIds());
    }

    @GetMapping("/my/tickets/promotion-id/{promotionId}/user-id/{userId}")
    public List<TicketDto> findTicketsByUserIdAndPromotionId(@PathVariable Long promotionId, @PathVariable String userId) {
        return ticketService.findTicketsByUserIdAndPromotionId(userId, promotionId);
    }
}
