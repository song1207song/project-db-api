package me.songha.projectapi.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public TicketDto.Response save(@RequestBody TicketDto.InsertRequest ticketInsertRequestDto) {
        return new TicketDto.Response(ticketService.save(ticketInsertRequestDto));
    }
}
