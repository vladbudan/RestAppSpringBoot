package com.vladbudan.app.dto.converter;

import com.vladbudan.app.dto.model.CatDto;
import com.vladbudan.app.model.Cat;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class CatConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static CatDto convertToDto(Cat cat) {

        return modelMapper.map(cat, CatDto.class);
    }

    public static Cat convertToEntity(CatDto catDto) {

        return modelMapper.map(catDto, Cat.class);
    }

    public static List<CatDto> convertListToDto(List<Cat> cats) {

        return cats
                .stream()
                .map(cat -> modelMapper.map(cat, CatDto.class))
                .collect(Collectors.toList());
    }

}