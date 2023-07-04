package org.example.jms.messaging.consumer.service.receiver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jms.messaging.consumer.service.sender.MessageSender;
import org.example.jms.messaging.domain.Person;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonMessageReceiver {
    private final MessageSender messageSender;

    @JmsListener(destination = "DEV.QUEUE.PERSON.REQUEST", containerFactory = "personFactory")
    public void receiveMessage(Person person) {
        log.info("received message: " + person.toString());

        messageSender.sendMessage("message about %s was accepted".formatted(person.getName()));
    }
}
