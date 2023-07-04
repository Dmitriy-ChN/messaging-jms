package org.example.jms.messaging.publisher.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jms.messaging.publisher.service.sender.MessageSender;
import org.example.jms.messaging.publisher.service.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MessageAcceptor {
    private final PersonRepository personRepository;
    private final MessageSender sender;

    @GetMapping("/{code}")
    public void sendPersonMessage(@PathVariable String code) {
        personRepository.getRecord(code)
                .ifPresentOrElse(
                        sender::sendMessage,
                        () -> log.info("person %s not found".formatted(code))
                );

    }
}
