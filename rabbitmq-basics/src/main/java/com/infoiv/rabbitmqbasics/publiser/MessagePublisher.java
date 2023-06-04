package com.infoiv.rabbitmqbasics.publiser;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class MessagePublisher {


 private final AmqpTemplate amqpTemplate;

 public MessagePublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
 }


    public void sendMessage(String message,String exchange,String routingKey){
     System.out.println("******* message *** "+message+"-"+"queueName "+exchange+" routingkey "+routingKey);
     //amqpAdmin.declareQueue(new Queue(queueName,true));
     amqpTemplate.convertAndSend(exchange,routingKey,message);
     System.out.println("****** message sent *****");
 }




}
