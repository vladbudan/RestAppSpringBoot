package com.vladbudan.app.dto.modelDto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    private Long id;

    @NotNull(message = "Name cannot be null")
    private String firstName;

    @NotNull(message = "Name cannot be null")
    private String lastName;
}


