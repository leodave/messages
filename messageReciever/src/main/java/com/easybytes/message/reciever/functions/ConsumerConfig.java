package com.easybytes.message.reciever.functions;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

    public static final String EXCHANGE = "send-communicating";

    public static final String EMAIL_Q = "email.q";

    public static final String SMS_Q = "sms.q";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE, true, false);
    }

    @Bean
    Queue emailQueue() {
        return QueueBuilder.durable(EMAIL_Q).build();
    }

    @Bean
    Queue smsQueue() {
        return QueueBuilder.durable(SMS_Q).build();
    }

    @Bean
    Binding emailBinding(Queue emailQueue) {
        return BindingBuilder.bind(emailQueue).to(new TopicExchange(EXCHANGE)).with("comms.account");
    }

    @Bean
    Binding smsBinding(Queue smsQueue) {
        return BindingBuilder.bind(smsQueue).to(new TopicExchange(EXCHANGE)).with("comms.account");
    }
}
