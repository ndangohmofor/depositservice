package com.meufty.depositservice.ws.handler;

import com.meufty.ws.core.events.DepositRequestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "deposit-money-topic", containerFactory = "kafkaListenerContainerFactory")
public class DepositRequestEventHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaHandler
    public void handle(@Payload DepositRequestEvent depositRequestEvent) {
        LOGGER.info("Received a new deposit event: {} ", depositRequestEvent.getAmount());
    }

}
