package com.junior.airplane_panel.dto;

import com.junior.airplane_panel.enums.FlightStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FlightRequest(
        @NotBlank(message = "Flight Number is null!")
        String flightNumber,
        @NotBlank(message = "Flight Company is null!")
        String company,
        @NotBlank(message = "Flight Destination is null!")
        String destination,
        @NotBlank(message = "Flight gate is null!")
        String gate,
        @NotBlank(message = "Flight hour is null!")
        LocalDate hour,
        @NotBlank(message = "Flight status is null!")
        FlightStatus status
) {
}
