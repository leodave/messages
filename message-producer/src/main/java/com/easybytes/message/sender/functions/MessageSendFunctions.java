package com.easybytes.message.sender.functions;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MessageSendFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageSendFunctions.class);

    private final StreamBridge streamBridge;

   /* @Bean
    public Function<AccountsMsgSentDto, AccountsMsgSentDto> sendMessage() {
        return accountsMsgSentDto -> {
            log.info("Sending to rabbit message: {}", accountsMsgSentDto);
            var result = streamBridge.send("sendCommunication-out-0", accountsMsgSentDto);
            log.info("Is the communication request sent successfully? : {}", result);
            return accountsMsgSentDto;
        };
    }*/

    /*@Bean
    public Supplier<AccountsMsgSentDto> sendAccountDto() {
        return () -> {
            AccountsMsgSentDto accountsMsgSentDto = new AccountsMsgSentDto(123L, "John Doe", "john.doe@example.com", "123456789");
            log.info("Sending email with details: {}", accountsMsgSentDto);
            var result = streamBridge.send("sendCommunication-out-0", accountsMsgSentDto);
            log.info("Is the communication request sent successfully? : {}", result);
            return accountsMsgSentDto;
        };
    }*/
}
