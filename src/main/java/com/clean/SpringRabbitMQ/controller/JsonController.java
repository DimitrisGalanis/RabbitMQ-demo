package com.clean.SpringRabbitMQ.controller;

import com.clean.SpringRabbitMQ.dto.Author;
import com.clean.SpringRabbitMQ.publisher.JsonProducer;
import com.clean.SpringRabbitMQ.publisher.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class JsonController {

        private JsonProducer jsonProducer;

        public JsonController(JsonProducer jsonProducer) {
            this.jsonProducer = jsonProducer;
        }

        @PostMapping("/publish_json")
        public ResponseEntity<Author> sendMessage(@RequestBody Author author) {
            jsonProducer.sendJsonMessage(author);
            return ResponseEntity.status(HttpStatus.OK).body(author);
        }


}
