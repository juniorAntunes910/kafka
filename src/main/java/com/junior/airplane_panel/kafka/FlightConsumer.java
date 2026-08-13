package com.junior.airplane_panel.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FlightConsumer {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(
        topics = "flight-events",
        groupId = "flight-consumer"
    )
    public void consume(FlightEvent flightEvent){
        System.out.println("Painel Recebeu atualização: " + flightEvent.flightNumber() + " agora está " + flightEvent.status());
    
        messagingTemplate.convertAndSend(
            "/topic/flights", flightEvent
        );
    
    }

}
