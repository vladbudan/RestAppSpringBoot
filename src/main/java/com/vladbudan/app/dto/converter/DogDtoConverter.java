package com.vladbudan.app.dto.converter;

import com.vladbudan.app.dto.modelDto.DogDto;
import com.vladbudan.app.model.Dog;
import com.vladbudan.app.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DogDtoConverter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DogDto convertToDto(Dog dog) {

        return modelMapper.map(dog, DogDto.class);
    }

    public Dog convertToEntity(DogDto dogDto) {

        Dog dog = modelMapper.map(dogDto, Dog.class);

        if (Objects.nonNull(dogDto.getUserId())) {
            dog.setUser(userRepository.findOne(dogDto.getUserId()));

        }

        return dog;
    }

}