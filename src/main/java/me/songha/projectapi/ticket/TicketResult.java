package me.songha.projectapi.ticket;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketResult {

    @Column(name = "result_code")
    private String resultCode;

    @Column(name = "result_text")
    private String resultText;
}
