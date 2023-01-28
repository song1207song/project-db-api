package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.songha.projectapi.common.model.DateTime;
import me.songha.projectapi.coupon.Coupon;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "promotion")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 64)
    @NotNull
    private String name;

    @Column(name = "status")
    @NotNull
    private int status;

    @OneToMany(mappedBy = "promotion")
    private List<Coupon> coupons = new ArrayList<>();

    @Embedded
    private DateTime dateTime;
}
