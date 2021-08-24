package com.vladbudan.app.service;

import com.vladbudan.app.dto.model.CatDto;
import com.vladbudan.app.dto.model.DogDto;

import java.util.List;

public interface DogService {

    DogDto getById(Long id);

    DogDto add(DogDto dogDto);

    DogDto update(DogDto dogDto);

    void delete(Long id);

    List<DogDto> getAll();

    DogDto assignByUserId(Long userId, Long dogId);
}
