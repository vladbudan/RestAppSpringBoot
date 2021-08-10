package com.vladbudan.app.dto.converter;

import com.vladbudan.app.dto.modelDto.CatDto;
import com.vladbudan.app.model.Cat;
import com.vladbudan.app.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CatDtoConverter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CatDto convertToDto(Cat cat) {

        return modelMapper.map(cat, CatDto.class);
    }

    public Cat convertToEntity(CatDto catDto) {

        Cat cat = modelMapper.map(catDto, Cat.class);

        if (Objects.nonNull(catDto.getUserId())) {
            cat.setUser(userRepository.findOne(catDto.getUserId()));

        }

        return cat;
    }

}