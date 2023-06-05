package com.infoiv.rabbitmqbasicslistener.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GenericConsumer implements MessageListener {
   Logger logger = LoggerFactory.getLogger(getClass());


    @RabbitListener(queues = {"testqueue"})
    public void consume(Message message){

   logger.info("Message recieved : "+ message.getBody().toString());

    }

    @Override
    public void onMessage(Message message) {
        logger.info("Message recieved - onMessage()  : "+ message.toString());
    }
}
