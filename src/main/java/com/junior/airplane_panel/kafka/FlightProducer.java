package com.junior.airplane_panel.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.junior.airplane_panel.model.Flight;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FlightProducer {

    private static final String TOPIC = "flight-eventes";

    private final KafkaTemplate<String, FlightEvent> kafkaTemplate;


    //Kafka producer 
    public void publish(FlightEvent event){
        kafkaTemplate.send(
            TOPIC,
            event.flightId().toString(),
            event
        );
    }
}
