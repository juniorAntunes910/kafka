package com.junior.airplane_panel.kafka;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.junior.airplane_panel.enums.FlightEventType;
import com.junior.airplane_panel.enums.FlightStatus;


//Kafka event 
public record FlightEvent(

        FlightEventType event,
        Long flightId,
        String flightNumber,
        String company,
        String destination,
        String gate,
        LocalDate hour,
        FlightStatus status,
        LocalDateTime ocurredAt

) {

}
