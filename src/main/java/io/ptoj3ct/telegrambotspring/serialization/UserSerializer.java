package io.ptoj3ct.telegrambotspring.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.ptoj3ct.telegrambotspring.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

@Slf4j
public class UserSerializer implements Serializer<UserDto> {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, UserDto data) {
        try {
            if (data == null){
                log.info("Null received at serializing");
                return null;
            }
            log.info("Serializing: " + data);
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            log.error("Error when serializing MessageDto to byte[]");
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
