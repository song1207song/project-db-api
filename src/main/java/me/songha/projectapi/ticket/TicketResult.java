package me.songha.projectapi.ticket;

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
public class TicketResult {

    @Column(name = "result_code", length = 16)
    @Size(max = 16)
    private String resultCode;

    @Column(name = "result_log", length = 2048)
    @Size(max = 2048)
    private String resultLog;
}
