package com.clean.SpringRabbitMQ.consumer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(String message) {
        logger.info(String.format("Received message -> %s",message));

    }

}
