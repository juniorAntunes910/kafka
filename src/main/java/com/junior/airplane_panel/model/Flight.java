package com.junior.airplane_panel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "company")
    private String company;

    @Column(name = "destination")
    private String destination;

    @Column(name = "gate")
    private String gate;

    @Column(name = "hour")
    private LocalDate hour;

    @Column(name = "flight_status")
    private FlightStatus flightStatus;





}
