package com.vladbudan.app.controller;

import com.vladbudan.app.dto.modelDto.UserDto;
import com.vladbudan.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<UserDto> getUserById(@PathVariable Long id) {

        log.info("In UserController getUserById {}", id);

        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) {

        log.info("In UserController addUser {}", userDto);

        return userService.addUser(userDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {

        log.info("In UserController updateUser {}, {}", id, userDto);

        userDto.setId(id);

        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        log.info("In UserController deleteUser {}", id);

        userService.delete(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {

        log.info("In UserController getAllUsers");

        return userService.getAll();
    }

}


