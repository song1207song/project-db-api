package me.songha.projectapi.ticket;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketResult {

    @Column(name = "result_code", length = 16)
    @Size(max = 16)
    private String resultCode;

    @Column(name = "result_log", length = 2048)
    @Size(max = 2048)
    private String resultLog;

    @Builder
    public TicketResult(String resultCode, String resultLog) {
        this.resultCode = resultCode;
        this.resultLog = resultLog;
    }
}
