package me.songha.projectapi.ticket;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.songha.projectapi.common.model.DateTime;
import me.songha.projectapi.coupon.Coupon;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ticket")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    @NotNull
    private String userId;

    @Embedded
    private TicketResult ticketResult;

    @Embedded
    private DateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
}
