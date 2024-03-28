package com.clean.SpringRabbitMQ.producer;

import com.clean.SpringRabbitMQ.dto.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.jsonRoutingKey.name}")
    private String jsonRoutingKey;


    private final Logger logger = LoggerFactory.getLogger(JsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    public JsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(Author author) {
        logger.info(String.format("Json message sent ---> %s", author.toString()));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey , author);
    }
}
