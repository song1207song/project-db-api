package me.songha.projectapi.coupon;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponDto {
    private Long id;
    private String name;
    private String type;
    private String groupType;
    private int limit;
    private ZonedDateTime startAt;
    private ZonedDateTime endAt;
    private String questType;
    private int questValue;

    @Builder
    public CouponDto(Coupon coupon) {
        if(coupon == null) return;

        this.id = coupon.getId();
        this.name = coupon.getName();
        this.type = coupon.getType();
        this.groupType = coupon.getGroupType();
        this.limit = coupon.getLimit();
        this.startAt = coupon.getValidDateTime().getStartAt();
        this.endAt = coupon.getValidDateTime().getEndAt();
        if (coupon.getCouponQuest() != null) {
            this.questType = coupon.getCouponQuest().getType();
            this.questValue = coupon.getCouponQuest().getValue();
        }
    }

}
