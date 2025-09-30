package com.easybytes.message.reciever.functions;

import com.easybytes.message.reciever.dto.AccountsMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

   /* @Bean
    public Consumer<AccountsMsgDto> email() {
        return accountsMsgDto -> {
            log.info("recieveing email with details: " + accountsMsgDto.toString());
        };
    }

    @Bean
    public Consumer<AccountsMsgDto> sms() {
        return accountsMsgDto -> {
            log.info("recieving sms with details: " + accountsMsgDto.accountNumber().toString());
        };
    }*/

    @RabbitListener(queues = ConsumerConfig.EMAIL_Q)
    public void email(AccountsMsgDto accountsMsgDto) {
        log.info("recieveing email with details: " + accountsMsgDto.toString());
    }

    @RabbitListener(queues = ConsumerConfig.SMS_Q)
    public void sms(AccountsMsgDto accountsMsgDto) {
        log.info("recieving sms with details: " + accountsMsgDto.mobileNumber());
    }
}
