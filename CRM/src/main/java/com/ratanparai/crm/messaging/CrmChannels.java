package com.ratanparai.crm.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CrmChannels {

    @Output
    MessageChannel olcmCreatedOut();
}