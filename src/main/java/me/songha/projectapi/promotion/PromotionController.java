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
    public PromotionDto.Response findById(@PathVariable Long id) {
        return new PromotionDto.Response(promotionService.findById(id));
    }
}
