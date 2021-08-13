package com.vladbudan.app.service.impl;

import com.vladbudan.app.model.Pet;
import com.vladbudan.app.repository.PetRepository;
import com.vladbudan.app.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

}
