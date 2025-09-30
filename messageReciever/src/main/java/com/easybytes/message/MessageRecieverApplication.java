package com.easybytes.message;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MessageRecieverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageRecieverApplication.class, args);
    }

}
