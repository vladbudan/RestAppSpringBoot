package com.vladbudan.app.service;

import com.vladbudan.app.dto.model.UserDto;
import com.vladbudan.app.model.User;

import java.util.List;

public interface UserService {

    UserDto getById(Long id);

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Long id);

    List<UserDto> getAll();

}
