package com.vladbudan.app.service;

import com.vladbudan.app.dto.modelDto.CatDto;

import java.util.List;
import java.util.Optional;

public interface CatService {

    Optional<CatDto> getCatById(Long id);

    CatDto addCat(CatDto catDto);

    CatDto update(CatDto catDto);

    void deleteCat(Long id);

    List<CatDto> getAllCats();

}
