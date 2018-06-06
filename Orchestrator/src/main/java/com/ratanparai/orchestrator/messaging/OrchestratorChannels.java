package com.ratanparai.orchestrator.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrchestratorChannels {

    String OLCM_CREATED = "olcmCreatedIn";

    @Input
    SubscribableChannel olcmCreatedIn();
}