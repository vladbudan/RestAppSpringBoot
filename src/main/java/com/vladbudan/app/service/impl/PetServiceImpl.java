package com.vladbudan.app.service.impl;

import com.vladbudan.app.model.Pet;
import com.vladbudan.app.repository.PetRepository;
import com.vladbudan.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

}
