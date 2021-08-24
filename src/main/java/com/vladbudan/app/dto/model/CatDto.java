package com.vladbudan.app.dto.model;

import lombok.Data;

@Data
public class CatDto {

    private Long id;

    private String name;

    private String gender;

    private Long userId;
}
