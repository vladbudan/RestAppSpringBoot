package com.vladbudan.app.repository;

import com.vladbudan.app.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
