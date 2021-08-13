package com.vladbudan.app.repository;

import com.vladbudan.app.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
