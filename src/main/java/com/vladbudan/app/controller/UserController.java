package com.vladbudan.app.controller;

import com.vladbudan.app.dto.model.CatDto;
import com.vladbudan.app.dto.model.DogDto;
import com.vladbudan.app.dto.model.UserDto;
import com.vladbudan.app.service.CatService;
import com.vladbudan.app.service.DogService;
import com.vladbudan.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CatService catService;
    private final DogService dogService;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {

        log.info("In UserController getUserById {}", id);

        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@Valid @RequestBody UserDto userDto) {

        log.info("In UserController addUser {}", userDto);

        return userService.add(userDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {

        log.info("In UserController updateUser {}, {}", id, userDto);

        userDto.setId(id);

        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {

        log.info("In UserController deleteUser {}", id);

        userService.delete(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {

        log.info("In UserController getAllUsers");

        return userService.getAll();
    }

    @PostMapping("/{userId}/cats/{catId}")
    public CatDto assignCat(@PathVariable Long userId, @PathVariable Long catId) {

        return catService.assignByUserId(userId, catId);
    }

    @PostMapping("/{userId}/dogs/{dogId}")
    public DogDto assignDog(@PathVariable Long userId, @PathVariable Long dogId) {

        return dogService.assignByUserId(userId, dogId);
    }

}


