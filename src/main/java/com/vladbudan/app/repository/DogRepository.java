package com.vladbudan.app.repository;

import com.vladbudan.app.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
