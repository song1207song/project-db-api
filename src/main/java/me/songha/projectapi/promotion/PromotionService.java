package me.songha.projectapi.promotion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public Promotion findById(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }
}
