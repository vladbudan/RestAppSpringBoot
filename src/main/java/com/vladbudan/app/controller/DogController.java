package com.vladbudan.app.controller;

import com.vladbudan.app.dto.modelDto.DogDto;
import com.vladbudan.app.service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/{id}")
    public Optional<DogDto> getDogById(@PathVariable Long id) {

        log.info("In DogController getDogById {}", id);

        return dogService.getDogById(id);
    }

    @PostMapping
    public DogDto addDog(@RequestBody DogDto dogDto) {

        log.info("In DogController addDog {}", dogDto);

        return dogService.addDog(dogDto);
    }

    @PutMapping("/{id}")
    public DogDto updateDog(@PathVariable Long id, @RequestBody DogDto dogDto) {

        log.info("In DogController updateDog {}, {}", id, dogDto);

        dogDto.setId(id);

        return dogService.update(dogDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable Long id) {

        log.info("In DogController deleteDog {}", id);

        dogService.deleteDog(id);
    }

    @GetMapping
    public List<DogDto> getAllDogs() {

        log.info("In DogController getAllDogs");

        return dogService.getAllDogs();
    }

}
