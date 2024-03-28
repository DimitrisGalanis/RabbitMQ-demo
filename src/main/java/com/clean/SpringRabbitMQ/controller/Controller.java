package com.clean.SpringRabbitMQ.controller;

import com.clean.SpringRabbitMQ.dto.Author;
import com.clean.SpringRabbitMQ.publisher.JsonProducer;
import com.clean.SpringRabbitMQ.publisher.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
public class Controller {

    private Producer producer;

    public Controller(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok(message);
    }



}
