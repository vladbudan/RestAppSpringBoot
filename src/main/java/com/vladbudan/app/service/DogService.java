package com.vladbudan.app.service;

import com.vladbudan.app.dto.modelDto.DogDto;

import java.util.List;
import java.util.Optional;

public interface DogService {

    Optional<DogDto> getDogById(Long id);

    DogDto addDog(DogDto dogDto);

    DogDto update(DogDto dogDto);

    void deleteDog(Long id);

    List<DogDto> getAllDogs();
}
