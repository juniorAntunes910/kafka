package com.junior.airplane_panel.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.junior.airplane_panel.dto.FlightRequest;
import com.junior.airplane_panel.dto.FlightResponse;
import com.junior.airplane_panel.enums.FlightEventType;
import com.junior.airplane_panel.kafka.FlightEvent;
import com.junior.airplane_panel.kafka.FlightProducer;
import com.junior.airplane_panel.mapper.FlightMapper;
import com.junior.airplane_panel.model.Flight;
import com.junior.airplane_panel.repository.FlightRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final FlightProducer flightProducer;

    @Transactional
    public FlightResponse create(FlightRequest flightRequest) {
        Flight flight = flightMapper.toEntity(flightRequest);
        Flight savedFlight = flightRepository.save(flight);
        publishEvent(FlightEventType.CREATED, savedFlight);
        return flightMapper.toResponse(savedFlight);
    }

    private void publishEvent(FlightEventType eventType, Flight savedFlight) {
        FlightEvent event = new FlightEvent(
                eventType,
                savedFlight.getId(),
                savedFlight.getFlightNumber(),
                savedFlight.getCompany(),
                savedFlight.getDestination(),
                savedFlight.getGate(),
                savedFlight.getHour(),
                savedFlight.getFlightStatus(),
                LocalDateTime.now());
        flightProducer.publish(event);
    }

}
