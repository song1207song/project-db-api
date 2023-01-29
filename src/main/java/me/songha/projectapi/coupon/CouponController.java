package me.songha.projectapi.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/coupon")
public class CouponController {
    private final CouponService couponService;

    @GetMapping("/id/{id}")
    public CouponDto findById(@PathVariable Long id) {
        return new CouponDto(couponService.findById(id));
    }

    @GetMapping("/id/{id}/tickets")
    public CouponWithTicketsDto findByIdWithTickets(@PathVariable Long id) {
        return new CouponWithTicketsDto(couponService.findById(id));
    }

}
