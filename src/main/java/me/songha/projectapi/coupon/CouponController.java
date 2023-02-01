package me.songha.projectapi.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/coupon")
public class CouponController {
    private final CouponService couponService;

    @GetMapping("/id/{id}")
    public CouponDto findById(@PathVariable Long id) {
        return couponService.findById(id);
    }

    @GetMapping("/promotion-id/{promotionId}/user-id/{userId}")
    public List<CouponWithRewardLeftDto> findTicketsByUserIdAndPromotionId(@PathVariable Long promotionId, @PathVariable String userId) {
        return couponService.findTicketsByUserIdAndPromotionId(userId, promotionId);
    }

}
