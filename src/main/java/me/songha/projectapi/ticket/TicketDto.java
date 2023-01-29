package me.songha.projectapi.ticket;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TicketDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long id;

        @Builder
        public Response(Ticket ticket) {
            if (ticket == null) return;

            this.id = ticket.getId();
        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class InsertRequest {
        private Long id;

        @Builder
        public InsertRequest(Ticket ticket) {
            if (ticket == null) return;

            this.id = ticket.getId();
        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdateRequest {
        private Long id;

        @Builder
        public UpdateRequest(Ticket ticket) {
            if (ticket == null) return;

            this.id = ticket.getId();
        }

    }
}
