package com.infoiv.rabbitmqbasics;

import com.infoiv.rabbitmqbasics.config.RabbitMqConfig;
import com.infoiv.rabbitmqbasics.publiser.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqBasicsApplication implements CommandLineRunner {

    @Autowired
    private MessagePublisher publisher;
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqBasicsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       publisher.sendMessage("this is a big test message", RabbitMqConfig.exchange,RabbitMqConfig.routingkey);
    }
}
