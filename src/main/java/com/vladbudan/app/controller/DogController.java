package com.vladbudan.app.controller;

import com.vladbudan.app.dto.model.DogDto;
import com.vladbudan.app.service.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;

    @GetMapping("/{id}")
    public DogDto getDogById(@PathVariable Long id) {

        log.info("In DogController getDogById {}", id);

        return dogService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DogDto addDog(@Valid @RequestBody DogDto dogDto) {

        log.info("In DogController addDog {}", dogDto);

        return dogService.add(dogDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DogDto updateDog(@PathVariable Long id, @Valid @RequestBody DogDto dogDto) {

        log.info("In DogController updateDog {}, {}", id, dogDto);

        dogDto.setId(id);

        return dogService.update(dogDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDog(@PathVariable Long id) {

        log.info("In DogController deleteDog {}", id);

        dogService.delete(id);
    }

    @GetMapping
    public List<DogDto> getAllDogs() {

        log.info("In DogController getAllDogs");

        return dogService.getAll();
    }

}
