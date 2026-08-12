package com.junior.airplane_panel.mapper;

import com.junior.airplane_panel.dto.FlightRequest;
import com.junior.airplane_panel.dto.FlightResponse;
import com.junior.airplane_panel.model.Flight;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlightMapper {

    public Flight toEntity(FlightRequest flightRequest){
        return new Flight(
                flightRequest.flightNumber(),
                flightRequest.company(),
                flightRequest.destination(),
                flightRequest.gate(),
                flightRequest.hour(),
                flightRequest.status()
        );
    }

    public FlightResponse toResponse(Flight flight){
        return new FlightResponse(
                flight.getId(),
                flight.getFlightNumber(),
                flight.getCompany(),
                flight.getDestination(),
                flight.getGate(),
                flight.getHour(),
                flight.getFlightStatus()
        );
    }


}
