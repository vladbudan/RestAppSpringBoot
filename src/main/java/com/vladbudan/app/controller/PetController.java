package com.vladbudan.app.controller;

import com.vladbudan.app.model.Pet;
import com.vladbudan.app.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAll();
    }

}
