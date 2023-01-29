package me.songha.projectapi.coupon;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.songha.projectapi.common.model.DateTime;
import me.songha.projectapi.common.model.ValidDateTime;
import me.songha.projectapi.promotion.Promotion;
import me.songha.projectapi.quest.Quest;
import me.songha.projectapi.ticket.Ticket;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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

    @Embedded
    private ValidDateTime validDateTime;

    @Embedded
    private DateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @OneToMany(mappedBy = "coupon", fetch = FetchType.LAZY)
    private List<Ticket> tickets = new ArrayList<>();

    // optional = false 이란?
    // 1:1 관계 + null일 수 없는 상황일 경우 left outer join 대신 inner join 을 사용하고 싶을 때 적용
    @OneToOne(mappedBy = "coupon", fetch = FetchType.EAGER, optional = false)
    private Quest quest;
}
