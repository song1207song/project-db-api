package me.songha.projectapi.coupon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponWithRewardLeftDto {
    private CouponDto coupon;
    @JsonIgnore
    private Long issuedAmount;

    public Long getRewardLeft() {
        return coupon.getLimit() - issuedAmount;
    }

    @QueryProjection
    public CouponWithRewardLeftDto(Coupon coupon, Long issuedAmount) {
        this.coupon = new CouponDto(coupon);
        this.issuedAmount = issuedAmount;
    }
}
