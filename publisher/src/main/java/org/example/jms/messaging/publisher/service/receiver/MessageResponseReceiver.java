package org.example.jms.messaging.publisher.service.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageResponseReceiver {

    @JmsListener(destination = "DEV.QUEUE.PERSON.RESPONSE", containerFactory = "personFactory")
    public void receiveMessage(String message) {
        log.info("received message: " + message);
    }
}
