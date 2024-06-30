    package com.booking_ticket.backend.dto;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.sql.Time;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class MovieMapSubDto {
        private String getCategory;

        public String getUrlImg;
        public Time getStart_at;
    }
