package com.vladbudan.app.dto.modelDto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CatDto {

    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Gender cannot be null")
    private String gender;

    private Long userId;
}
