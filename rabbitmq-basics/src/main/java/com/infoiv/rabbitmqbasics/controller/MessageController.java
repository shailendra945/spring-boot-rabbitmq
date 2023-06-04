package com.infoiv.rabbitmqbasics.controller;

import com.infoiv.rabbitmqbasics.config.RabbitMqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final AmqpTemplate template;

    @GetMapping("/{message}")
    public ResponseEntity<String> queueMessage(@PathVariable String message){
        this.template.convertAndSend(RabbitMqConfig.exchange,RabbitMqConfig.routingkey,message);
        return new ResponseEntity<String>("Message queued!",HttpStatus.OK);
    }


    public MessageController(RabbitTemplate template) {
        this.template = template;
    }



}
