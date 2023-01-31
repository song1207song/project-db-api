package me.songha.projectapi.ticket;

import com.querydsl.core.Tuple;
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
    public TicketDto.Response save(@RequestBody TicketDto.InsertRequest ticketInsertRequestDto) {
        return new TicketDto.Response(ticketService.save(ticketInsertRequestDto));
    }

    @PatchMapping
    public TicketDto.Response update(@RequestBody TicketDto.UpdateRequest ticketUpdateRequestDto) {
        return new TicketDto.Response(ticketService.update(ticketUpdateRequestDto));
    }

    @GetMapping("/my/tickets")
    public List<Tuple> myTickets(TicketSearchCondition condition) {
        return ticketService.findTicketsByUserIdAndCouponIds(condition.getUserId(), condition.getCouponIds());
    }
}
