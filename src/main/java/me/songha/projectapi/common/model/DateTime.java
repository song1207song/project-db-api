package me.songha.projectapi.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Embeddable
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DateTime {

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @NotNull
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
