package com.vladbudan.app.controller;

import com.vladbudan.app.dto.model.CatDto;
import com.vladbudan.app.service.CatService;
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
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("/{id}")
    public CatDto getCatById(@PathVariable Long id) {

        log.info("In CatController getCatById {}", id);

        return catService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatDto addCat(@Valid @RequestBody CatDto catDto) {

        log.info("In CatController addCat {}", catDto);

        return catService.add(catDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CatDto updateCat(@PathVariable Long id, @Valid @RequestBody CatDto catDto) {

        log.info("In CatController updateCat {}, {}", id, catDto);

        catDto.setId(id);

        return catService.update(catDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCat(@PathVariable Long id) {

        log.info("In CatController deleteCat {}", id);

        catService.delete(id);
    }

    @GetMapping
    public List<CatDto> getAllCats() {

        log.info("In CatController getAllCats");

        return catService.getAll();
    }

}
