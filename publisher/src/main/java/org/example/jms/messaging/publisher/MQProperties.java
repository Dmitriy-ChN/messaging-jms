package org.example.jms.messaging.publisher;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mq-props")
public record MQProperties(String queue) {
}
