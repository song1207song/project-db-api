package me.songha.projectapi.coupon;

import lombok.RequiredArgsConstructor;
import me.songha.projectapi.common.repository.CommonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final CommonRepository commonRepository;

    public CouponDto findById(Long id) {
        return new CouponDto(couponRepository.findById(id).orElse(null));
    }

    public List<CouponWithRewardLeftDto> findTicketsByUserIdAndPromotionId(String userId, Long promotionId) {
        return commonRepository.findCouponsWithRewardLeft(userId, promotionId);
    }

}
