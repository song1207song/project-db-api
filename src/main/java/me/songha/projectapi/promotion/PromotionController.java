package me.songha.projectapi.promotion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping("/id/{id}")
    public PromotionDto findById(@PathVariable Long id) {
        return new PromotionDto(promotionService.findById(id));
    }

    @GetMapping("/id/{id}/coupons/tickets")
    public PromotionWithCouponsAndTicketsDto findByIdWithCouponsAndTickets(@PathVariable Long id) {
        return new PromotionWithCouponsAndTicketsDto(promotionService.findById(id));
    }

}
