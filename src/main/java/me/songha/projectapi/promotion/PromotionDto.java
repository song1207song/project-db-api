package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PromotionDto {
    private Long id;
    private String name;
    private String title;
    private ZonedDateTime startAt;
    private ZonedDateTime endAt;

    @Builder
    public PromotionDto(Promotion promotion) {
        this.id = promotion.getId();
        this.name = promotion.getName();
        this.title = promotion.getTitle();
        this.startAt = promotion.getValidDateTime().getStartAt();
        this.endAt = promotion.getValidDateTime().getEndAt();
    }

}
