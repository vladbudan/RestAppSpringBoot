package com.vladbudan.app.controller;

import com.vladbudan.app.dto.modelDto.CatDto;
import com.vladbudan.app.service.CatService;
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
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("/{id}")
    public Optional<CatDto> getCatById(@PathVariable Long id) {

        log.info("In CatController getCatById {}", id);

        return catService.getCatById(id);
    }

    @PostMapping
    public CatDto addCat(@RequestBody CatDto catDto) {

        log.info("In CatController addCat {}", catDto);

        return catService.addCat(catDto);
    }

    @PutMapping("/{id}")
    public CatDto updateCat(@PathVariable Long id, @RequestBody CatDto catDto) {

        log.info("In CatController updateCat {}, {}", id, catDto);

        catDto.setId(id);

        return catService.update(catDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Long id) {

        log.info("In CatController deleteCat {}", id);

        catService.deleteCat(id);
    }

    @GetMapping
    public List<CatDto> getAllCats() {

        log.info("In CatController getAllCats");

        return catService.getAllCats();
    }

}
