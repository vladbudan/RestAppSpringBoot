package com.vladbudan.app.service.impl;

import com.vladbudan.app.dto.converter.CatConverter;
import com.vladbudan.app.dto.model.CatDto;
import com.vladbudan.app.dto.model.DogDto;
import com.vladbudan.app.model.Cat;
import com.vladbudan.app.model.Dog;
import com.vladbudan.app.model.User;
import com.vladbudan.app.repository.DogRepository;
import com.vladbudan.app.repository.UserRepository;
import com.vladbudan.app.service.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.vladbudan.app.dto.converter.DogConverter.convertListToDto;
import static com.vladbudan.app.dto.converter.DogConverter.convertToDto;
import static com.vladbudan.app.dto.converter.DogConverter.convertToEntity;

@Slf4j
@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;
    private final UserRepository userRepository;

    @Override
    public DogDto getById(Long id) {

        log.info("In DogServiceImpl getById {}", id);

        Dog dog = dogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dog with such id not found!"));

        return convertToDto(dog);
    }

    @Override
    public DogDto add(DogDto dogDto) {

        log.info("In DogServiceImpl save {}", dogDto);

        Dog dog = convertToEntity(dogDto);

        Dog dogCreated = dogRepository.save(dog);

        return convertToDto(dogCreated);
    }

    @Override
    public DogDto update(DogDto dogDto) {

        log.info("In DogServiceImpl update {}", dogDto);

        Dog dog = convertToEntity(dogDto);

        Dog dogUpdated = dogRepository.save(dog);

        return convertToDto(dogUpdated);
    }

    @Override
    public void delete(Long id) {

        log.info("In DogServiceImpl delete {}", id);

        dogRepository.deleteById(id);
    }

    @Override
    public List<DogDto> getAll() {

        log.info("In CarServiceImpl getAll");

        List<Dog> dogs = dogRepository.findAll();

        return convertListToDto(dogs);
    }

    @Override
    @Transactional
    public DogDto assignByUserId(Long userId, Long dogId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with such id not found!"));

        Dog dog = dogRepository.findById(dogId)
                .orElseThrow(() -> new EntityNotFoundException("Dog with such id not found!"));

        dog.setUser(user);

        Dog dogOfUser = dogRepository.save(dog);

        return convertToDto(dogOfUser);
    }

}
