package com.vladbudan.app.dto.converter;

import com.vladbudan.app.dto.model.DogDto;
import com.vladbudan.app.dto.model.DogDto;
import com.vladbudan.app.model.Dog;
import com.vladbudan.app.model.Dog;
import com.vladbudan.app.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class DogConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static DogDto convertToDto(Dog dog) {

        return modelMapper.map(dog, DogDto.class);
    }

    public static Dog convertToEntity(DogDto dogDto) {

        return modelMapper.map(dogDto, Dog.class);
    }

    public static List<DogDto> convertListToDto(List<Dog> dogs) {

        return dogs
                .stream()
                .map(dog -> modelMapper.map(dog, DogDto.class))
                .collect(Collectors.toList());
    }

}