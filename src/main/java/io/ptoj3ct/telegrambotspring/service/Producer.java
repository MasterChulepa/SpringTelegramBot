package io.ptoj3ct.telegrambotspring.service;

import io.ptoj3ct.telegrambotspring.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {
    private static final String TOPIC = "users";
    private final KafkaTemplate<String, UserDto> kafkaTemplate;

    public Producer(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(UserDto userdto){
        kafkaTemplate.send(TOPIC,  userdto);
    }
}
