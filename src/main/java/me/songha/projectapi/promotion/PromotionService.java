package me.songha.projectapi.promotion;

import lombok.RequiredArgsConstructor;
import me.songha.projectapi.common.repository.CommonRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;
    private final CommonRepository commonRepository;

    public Promotion findById(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }

//    public PromotionDto.ResponseWithCouponsAndTickets searchPromotionWithCoupons(Long id) {
//        return commonRepository.searchPromotionWithCoupons(id);
//    }
}
