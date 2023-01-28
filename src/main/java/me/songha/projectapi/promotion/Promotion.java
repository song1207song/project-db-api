package me.songha.projectapi.promotion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.songha.projectapi.common.model.DateTime;
import me.songha.projectapi.common.model.ValidDateTime;
import me.songha.projectapi.coupon.Coupon;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Column(name = "name", length = 32)
    @NotNull
    @Size(max = 32)
    private String name;

    @Column(name = "title", length = 64)
    @NotNull
    @Size(max = 64)
    private String title;

    @Column(name = "status")
    @NotNull
    private int status;

    @Embedded
    private ValidDateTime validDateTime;

    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
    private List<Coupon> coupons = new ArrayList<>();

    @Embedded
    private DateTime dateTime;
}
