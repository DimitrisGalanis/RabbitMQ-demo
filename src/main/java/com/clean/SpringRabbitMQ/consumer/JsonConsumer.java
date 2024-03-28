package com.clean.SpringRabbitMQ.consumer;

import com.clean.SpringRabbitMQ.dto.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {

        private final Logger logger = LoggerFactory.getLogger(JsonConsumer.class);

        @RabbitListener(queues = "${rabbitmq.jsonQueue.name}")
        public void consumeJson(Author author) {
            logger.info(String.format("Received author -> %s",author.toString()));
        }
    }

