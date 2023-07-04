package org.example.jms.messaging.consumer.service.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jms.messaging.consumer.MQProperties;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageSender {
    private final JmsTemplate jmsTemplate;
    private final MQProperties properties;

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(properties.queue(), message);
        log.info("sent message: " + message);
    }
}
