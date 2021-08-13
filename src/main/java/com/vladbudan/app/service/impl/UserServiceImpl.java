package com.vladbudan.app.service.impl;

import com.vladbudan.app.dto.model.UserDto;
import com.vladbudan.app.model.User;
import com.vladbudan.app.repository.UserRepository;
import com.vladbudan.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.vladbudan.app.dto.converter.UserConverter.convertListToDto;
import static com.vladbudan.app.dto.converter.UserConverter.convertToDto;
import static com.vladbudan.app.dto.converter.UserConverter.convertToEntity;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getById(Long id) {

        log.info("In UserServiceImpl getById {}", id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with such id not found!"));

        return convertToDto(user);
    }

    @Override
    public UserDto add(UserDto userDto) {

        log.info("In UserServiceImpl save {}", userDto);

        User user = convertToEntity(userDto);

        User userCreated = userRepository.save(user);

        return convertToDto(userCreated);
    }

    @Override
    public UserDto update(UserDto userDto) {

        log.info("In UserServiceImpl update {}", userDto);

        User user = convertToEntity(userDto);

        User userUpdated = userRepository.save(user);

        return convertToDto(userUpdated);
    }

    @Override
    public void delete(Long id) {

        log.info("In UserServiceImpl delete {}", id);

        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {

        log.info("In UserServiceImpl getAll");

        List<User> users = userRepository.findAll();

        return convertListToDto(users);
    }

}
