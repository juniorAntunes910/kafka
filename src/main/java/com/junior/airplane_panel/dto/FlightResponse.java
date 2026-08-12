package com.junior.airplane_panel.dto;

import com.junior.airplane_panel.enums.FlightStatus;

import java.time.LocalDate;

public record FlightResponse (

        Long id,
        String flightNumber,
        String company,
        String destination,
        String gate,
        LocalDate hour,
        FlightStatus status
){
}
