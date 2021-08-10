package com.vladbudan.app.service.impl;

import com.vladbudan.app.dto.converter.DogDtoConverter;
import com.vladbudan.app.dto.modelDto.DogDto;
import com.vladbudan.app.model.Dog;
import com.vladbudan.app.repository.DogRepository;
import com.vladbudan.app.service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogDtoConverter dogDtoConverter;

    @Override
    public Optional<DogDto> getDogById(Long id) {
        log.info("In DogServiceImpl getById {}", id);

        Optional<Dog> optionalDog = Optional.ofNullable(dogRepository.findOne(id));

        if (!optionalDog.isPresent()) {
            throw new EntityNotFoundException("User with such id not found!");
        }

        return Optional.of(dogDtoConverter.convertToDto(optionalDog.get()));
    }

    @Override
    public DogDto addDog(DogDto dogDto) {

        log.info("In DogServiceImpl save {}", dogDto);

        Dog dog = dogDtoConverter.convertToEntity(dogDto);

        Dog dogCreated = dogRepository.save(dog);

        return dogDtoConverter.convertToDto(dogCreated);
    }

    @Override
    public DogDto update(DogDto dogDto) {

        log.info("In DogServiceImpl update {}", dogDto);

        Dog dog = dogDtoConverter.convertToEntity(dogDto);

        Dog dogUpdated = dogRepository.save(dog);

        return dogDtoConverter.convertToDto(dogUpdated);
    }

    @Override
    public void deleteDog(Long id) {

        log.info("In DogServiceImpl delete {}", id);

        dogRepository.delete(id);
    }

    @Override
    public List<DogDto> getAllDogs() {

        log.info("In CarServiceImpl getAll");

        List<Dog> dogs = dogRepository.findAll();

        return dogs.stream()
                .map(dog -> dogDtoConverter.convertToDto(dog))
                .collect((Collectors.toList()));
    }

}
