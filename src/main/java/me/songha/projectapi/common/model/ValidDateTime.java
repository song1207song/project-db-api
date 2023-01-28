package me.songha.projectapi.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Embeddable
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ValidDateTime {

    @Column(name = "start_at")
    @NotNull
    private ZonedDateTime startAt;

    @Column(name = "end_at")
    @NotNull
    private ZonedDateTime endAt;
}
