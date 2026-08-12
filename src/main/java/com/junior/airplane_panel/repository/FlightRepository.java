package com.junior.airplane_panel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junior.airplane_panel.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
