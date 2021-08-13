package com.vladbudan.app.dto.model;

import com.vladbudan.app.model.Pet;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
public class UserDto {

    private Long id;

    @NotNull(message = "field can not be null!")
    private String firstName;

    @NotNull(message = "field can not be null!")
    private String lastName;

    private List<Pet> pets;
}


