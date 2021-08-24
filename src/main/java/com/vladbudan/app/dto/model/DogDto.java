package com.vladbudan.app.dto.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class DogDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String color;

    private Long userId;

}
