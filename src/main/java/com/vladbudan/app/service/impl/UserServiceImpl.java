package com.vladbudan.app.service.impl;

import com.vladbudan.app.dto.converter.UserDtoConverter;
import com.vladbudan.app.dto.modelDto.UserDto;
import com.vladbudan.app.model.User;
import com.vladbudan.app.repository.UserRepository;
import com.vladbudan.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDtoConverter userDtoConverter;

    @Override
    public Optional<UserDto> getById(Long id) {

        log.info("In UserServiceImpl getById {}", id);

        Optional<User> optionalUser = Optional.ofNullable(userRepository.findOne(id));

        if(!optionalUser.isPresent()) {
            throw new EntityNotFoundException("User with such id not found!");
        }

        return Optional.of(userDtoConverter.convertToDto(optionalUser.get()));
    }

    @Override
    public UserDto addUser(UserDto userDto) {

        log.info("In UserServiceImpl save {}", userDto);

        User user = userDtoConverter.convertToEntity(userDto);

        User userCreated = userRepository.save(user);

        return userDtoConverter.convertToDto(userCreated);
    }

    @Override
    public UserDto update(UserDto userDto) {

        log.info("In UserServiceImpl update {}", userDto);

        User user = userDtoConverter.convertToEntity(userDto);

        User userUpdated = userRepository.save(user);

        return userDtoConverter.convertToDto(userUpdated);
    }

    @Override
    public void delete(Long id) {

        log.info("In UserServiceImpl delete {}", id);

        userRepository.delete(id);
    }

    @Override
    public List<UserDto> getAll() {

        log.info("In UserServiceImpl getAll");

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> userDtoConverter.convertToDto(user))
                .collect((Collectors.toList()));
    }

}
