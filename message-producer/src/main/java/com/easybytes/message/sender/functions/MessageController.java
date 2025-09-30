package com.easybytes.message.sender.functions;

import com.easybytes.message.sender.dto.AccountsMsgSentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<String> sendAccountMessage(@RequestBody AccountsMsgSentDto dto) {
        // publish to exchange with routing key
        rabbitTemplate.convertAndSend("send-communicating", "comms.account", dto);
        log.info("messeange sent : {}", dto);
        return ResponseEntity.ok("Message sent: " + dto);
    }
}

