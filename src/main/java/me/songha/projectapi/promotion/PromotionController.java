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

//    @GetMapping("/id/{id}/coupons")
//    public PromotionDto.ResponseWithCoupons findById(@PathVariable Long id) {
//        return new PromotionDto.ResponseWithCoupons(promotionService.findById(id));
//    }

//    @GetMapping("/id/{id}/coupons/v2")
//    public PromotionDto.ResponseWithCouponsAndTickets searchPromotionWithCoupons(@PathVariable Long id) {
//        return promotionService.searchPromotionWithCoupons(id);
//    }

    // todo 조회된 쿼리를 보니 수정이 필요함 n+1 문제인가?
//    @GetMapping("/id/{id}/coupons/tickets")
//    public PromotionDto.ResponseWithCouponsAndTickets findByIdWithCouponsAndTickets(@PathVariable Long id) {
//        return new PromotionDto.ResponseWithCouponsAndTickets(promotionService.findById(id));
//    }
}
