package io.ptoj3ct.telegrambotspring.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class UserDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;

    @NotNull
    @JsonProperty
    private String username;

    @JsonProperty
    private Timestamp registeredAt;

}
