package com.vladbudan.app.repository;

import com.vladbudan.app.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
