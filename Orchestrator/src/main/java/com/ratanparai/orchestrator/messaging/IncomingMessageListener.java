package com.ratanparai.orchestrator.messaging;

import com.ratanparai.orchestrator.events.incoming.Olcm;
import com.ratanparai.orchestrator.events.incoming.OlcmCreatedEvent;
import com.ratanparai.orchestrator.infrastructure.OlcmRepository;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class IncomingMessageListener {

    private OlcmRepository olcmRepository;

    public IncomingMessageListener(OlcmRepository olcmRepository) {
        this.olcmRepository = olcmRepository;
    }

    @StreamListener(OrchestratorChannels.OLCM_CREATED)
    public void receiveOlcmCreatedEvent(@Payload OlcmCreatedEvent event) {
        Olcm olcm = event.getOlcm();
        olcmRepository.save(olcm);
    }
}