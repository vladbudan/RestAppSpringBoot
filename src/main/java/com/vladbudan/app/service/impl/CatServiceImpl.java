package com.vladbudan.app.service.impl;

import com.vladbudan.app.dto.converter.CatDtoConverter;
import com.vladbudan.app.dto.modelDto.CatDto;
import com.vladbudan.app.model.Cat;
import com.vladbudan.app.repository.CatRepository;
import com.vladbudan.app.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private CatDtoConverter catDtoConverter;

    @Override
    public Optional<CatDto> getCatById(Long id) {

        log.info("In CatServiceImpl getById {}", id);

        Optional<Cat> optionalCat = Optional.ofNullable(catRepository.findOne(id));

        if (!optionalCat.isPresent()) {
            throw new EntityNotFoundException("Cat with such id not found!");
        }

        return Optional.of(catDtoConverter.convertToDto(optionalCat.get()));
    }

    @Override
    public CatDto addCat(CatDto catDto) {

        log.info("In CatServiceImpl save {}", catDto);

        Cat cat = catDtoConverter.convertToEntity(catDto);

        Cat catCreated = catRepository.save(cat);

        return catDtoConverter.convertToDto(catCreated);
    }

    @Override
    public CatDto update(CatDto catDto) {

        log.info("In CatServiceImpl update {}", catDto);

        Cat cat = catDtoConverter.convertToEntity(catDto);

        Cat catUpdated = catRepository.save(cat);

        return catDtoConverter.convertToDto(catUpdated);
    }

    @Override
    public void deleteCat(Long id) {

        log.info("In CatServiceImpl delete {}", id);

        catRepository.delete(id);
    }

    @Override
    public List<CatDto> getAllCats() {

        log.info("In CatServiceImpl getAll");

        List<Cat> cats = catRepository.findAll();

        return cats.stream()
                .map(cat -> catDtoConverter.convertToDto(cat))
                .collect((Collectors.toList()));
    }

}
