package me.songha.projectapi.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public Coupon findById(Long id) {
        return couponRepository.findById(id).orElse(null);
    }
}
