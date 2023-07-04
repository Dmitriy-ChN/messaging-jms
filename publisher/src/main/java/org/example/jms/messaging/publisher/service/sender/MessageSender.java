package org.example.jms.messaging.publisher.service.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jms.messaging.domain.Person;
import org.example.jms.messaging.publisher.MQProperties;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageSender {
    private final JmsTemplate jmsTemplate;
    private final MQProperties properties;

    public void sendMessage(Person person) {
        jmsTemplate.convertAndSend(properties.queue(), person);
        log.info("sent message: "+person);
    }
}
