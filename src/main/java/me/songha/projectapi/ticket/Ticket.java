package me.songha.projectapi.ticket;

import lombok.*;
import me.songha.projectapi.common.model.DateTime;
import me.songha.projectapi.coupon.Coupon;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Column(name = "user_id", length = 64)
    @NotNull
    @Size(max = 64)
    private String userId;

    @Embedded
    private TicketResult ticketResult;

    @Embedded
    private DateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @Builder
    public Ticket(String userId, TicketResult ticketResult, Coupon coupon) {
        this.userId = userId;
        this.ticketResult = ticketResult;
        this.coupon = coupon;
    }

    public void updateTicketResult(TicketResult ticketResult) {
        this.ticketResult = ticketResult;
    }
}
