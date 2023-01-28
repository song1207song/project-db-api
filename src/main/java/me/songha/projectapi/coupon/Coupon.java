package me.songha.projectapi.coupon;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.songha.projectapi.common.model.DateTime;
import me.songha.projectapi.promotion.Promotion;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

@Entity
@Table(name = "coupon")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 64)
    @NotNull
    @Size(max = 64)
    private String name;

    @Column(name = "type", length = 32)
    @NotNull
    @Size(max = 32)
    private String type;

    @Column(name = "group_type", length = 32)
    @NotNull
    @Size(max = 32)
    private String groupType;

    @Column(name = "issuance_limit")
    @NotNull
    private int limit;

    @Column(name = "start_at")
    @NotNull
    private ZonedDateTime startAt;

    @Column(name = "end_at")
    @NotNull
    private ZonedDateTime endAt;

    @Embedded
    private DateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;
}
