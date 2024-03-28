package com.clean.SpringRabbitMQ.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routingKey.name}")
    private String routingKey;

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private RabbitTemplate rabbitTemplate;


    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        logger.info(String.format("Message send --->  %s", message));
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }

}
