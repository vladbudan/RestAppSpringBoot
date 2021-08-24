package com.vladbudan.app.service.impl;

import com.vladbudan.app.dto.model.CatDto;
import com.vladbudan.app.model.Cat;
import com.vladbudan.app.model.User;
import com.vladbudan.app.repository.CatRepository;
import com.vladbudan.app.repository.UserRepository;
import com.vladbudan.app.service.CatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.vladbudan.app.dto.converter.CatConverter.convertListToDto;
import static com.vladbudan.app.dto.converter.CatConverter.convertToDto;
import static com.vladbudan.app.dto.converter.CatConverter.convertToEntity;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;
    private final UserRepository userRepository;

    @Override
    public CatDto getById(Long id) {

        log.info("In CatServiceImpl getById {}", id);

        Cat cat = catRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cat with such id not found!"));

        return convertToDto(cat);
    }

    @Override
    public CatDto add(CatDto catDto) {

        log.info("In CatServiceImpl save {}", catDto);

        Cat cat = convertToEntity(catDto);

        Cat catCreated = catRepository.save(cat);

        return convertToDto(catCreated);
    }

    @Override
    public CatDto update(CatDto catDto) {

        log.info("In CatServiceImpl update {}", catDto);

        Cat cat = convertToEntity(catDto);

        Cat catUpdated = catRepository.save(cat);

        return convertToDto(catUpdated);
    }

    @Override
    public void delete(Long id) {

        log.info("In CatServiceImpl delete {}", id);

        catRepository.deleteById(id);
    }

    @Override
    public List<CatDto> getAll() {

        log.info("In CatServiceImpl getAll");

        List<Cat> cats = catRepository.findAll();

        return convertListToDto(cats);
    }

    @Override
    @Transactional
    public CatDto assignByUserId(Long userId, Long catId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with such id not found!"));

        Cat cat = catRepository.findById(catId)
                .orElseThrow(() -> new EntityNotFoundException("Cat with such id not found!"));

        cat.setUser(user);

        Cat catOfUser = catRepository.save(cat);

        return convertToDto(catOfUser);
    }

}
