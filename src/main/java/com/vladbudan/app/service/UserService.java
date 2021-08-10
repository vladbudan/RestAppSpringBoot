package com.vladbudan.app.service;

import com.vladbudan.app.dto.modelDto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserDto> getById(Long id);

    UserDto addUser(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);

    List<UserDto> getAll();
}
