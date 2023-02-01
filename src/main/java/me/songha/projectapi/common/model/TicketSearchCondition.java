package me.songha.projectapi.common.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketSearchCondition {
    private String userId;
    private List<Long> couponIds = new ArrayList<>();
}
