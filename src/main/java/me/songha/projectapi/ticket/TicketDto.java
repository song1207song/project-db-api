package me.songha.projectapi.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.songha.projectapi.coupon.Coupon;
import me.songha.projectapi.coupon.CouponDto;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketDto {
    private Long id;
    private String userId;
    private CouponDto coupon;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @QueryProjection
    public TicketDto(Long id, String userId, Coupon couponEntity, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.coupon = new CouponDto(couponEntity);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    public Long getCouponId() {
        return coupon.getId();
    }
}
