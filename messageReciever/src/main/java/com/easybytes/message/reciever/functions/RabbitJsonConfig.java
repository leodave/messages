package com.easybytes.message.reciever.functions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitJsonConfig {

    @Bean
    Jackson2JsonMessageConverter jacksonConverter(ObjectMapper mapper) {
        var conv = new Jackson2JsonMessageConverter(mapper);
        conv.setAlwaysConvertToInferredType(true); // or keep your explicit type mapper
        return conv;
    }

    @Bean  // name it exactly like this to make it the default for @RabbitListener
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            org.springframework.amqp.rabbit.connection.ConnectionFactory cf,
            Jackson2JsonMessageConverter conv) {
        var f = new SimpleRabbitListenerContainerFactory();
        f.setConnectionFactory(cf);
        f.setMessageConverter(conv);
        return f;
    }
}

