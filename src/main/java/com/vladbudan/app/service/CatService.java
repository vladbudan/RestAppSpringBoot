package com.vladbudan.app.service;

import com.vladbudan.app.dto.model.CatDto;

import java.util.List;

public interface CatService {

    CatDto getById(Long id);

    CatDto add(CatDto catDto);

    CatDto update(CatDto catDto);

    void delete(Long id);

    List<CatDto> getAll();

    CatDto assignByUserId(Long userId, Long catId);

}
