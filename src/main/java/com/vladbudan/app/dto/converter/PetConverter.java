package com.vladbudan.app.dto.converter;

import com.vladbudan.app.dto.model.PetDto;
import com.vladbudan.app.model.Pet;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PetConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static PetDto convertToDto(Pet pet) {

        return modelMapper.map(pet, PetDto.class);
    }

    public static Pet convertToEntity(PetDto petDto) {

        return modelMapper.map(petDto, Pet.class);
    }

    public static List<PetDto> convertListToDto(List<Pet> pets) {

        return pets
                .stream()
                .map(pet -> modelMapper.map(pet, PetDto.class))
                .collect(Collectors.toList());
    }

}
