package me.songha.projectapi.coupon;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponQuest {
    @Column(name = "quest_type", length = 32)
    @Size(max = 32)
    private String type;

    @Column(name = "quest_value")
    private int value;
}
