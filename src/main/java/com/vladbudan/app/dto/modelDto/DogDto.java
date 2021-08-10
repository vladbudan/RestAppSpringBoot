package com.vladbudan.app.dto.modelDto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DogDto {

    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Name cannot be null")
    private String color;

    private Long userId;

}
