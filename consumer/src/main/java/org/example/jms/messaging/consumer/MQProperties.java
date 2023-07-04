package org.example.jms.messaging.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mq-props")
public record MQProperties(String queue) {
}
