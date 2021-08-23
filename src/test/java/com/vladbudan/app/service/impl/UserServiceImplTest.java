package com.vladbudan.app.service.impl;

import com.vladbudan.app.dto.converter.UserConverter;
import com.vladbudan.app.dto.model.UserDto;
import com.vladbudan.app.model.User;
import com.vladbudan.app.repository.UserRepository;
import com.vladbudan.app.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class UserServiceImplTest {

    private UserService userService;

    @Mock
    private UserConverter userConverter;

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        initMocks(this);
        userService = new UserServiceImpl(userRepository, userConverter);
    }

    @Test
    public void getUsersTest() {

        List<User> list = new ArrayList<>();
        User user1 = new User(1L, "Kevin", "Jones");
        User user2 = new User(2L, "Steven", "Palmero");

        list.add(user1);
        list.add(user2);

        when(userRepository.findAll()).thenReturn(list);

        List<UserDto> usersDto = new ArrayList<>();
        UserDto userDto1 = entityToDto(user1);
        UserDto userDto2 = entityToDto(user2);

        usersDto.add(userDto1);
        usersDto.add(userDto2);

        when(userConverter.convertListToDto(list)).thenReturn(usersDto);

        usersDto = userService.getAll();

        assertEquals(2, usersDto.size());

    }

    @Test
    public void getUserById() {

        User user = new User(3L, "Chris", "Joslin");

        when(userRepository.findById(3L)).thenReturn(java.util.Optional.of(user));

        UserDto userDto = entityToDto(user);

        when(userConverter.convertToDto(user)).thenReturn(userDto);

        userDto = userService.getById(3L);

        assertEquals("Chris", userDto.getFirstName());
        assertEquals("Joslin", userDto.getLastName());
    }

    @Test
    public void addUser() {

        User user = new User(4L, "Barry", "Care");

        when(userRepository.save(user)).thenReturn(user);

        UserDto userDto = entityToDto(user);

        when(userConverter.convertToEntity(userDto)).thenReturn(user);

        userService.add(userDto);

        verify(userRepository).save(user);
    }

    @Test
    public void updateUser() {

        User user = new User(5L, "Roberto", "Ramirez");

        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));

        UserDto userDto = entityToDto(user);

        when(userConverter.convertToEntity(userDto)).thenReturn(user);

        userService.update(userDto);

        verify(userRepository).save(user);

        verify(userRepository).findById(user.getId());
    }

    @Test
    public void deleteUser() {

        User user = new User(6L, "David", "Wayne");

        when(userRepository.findById(6L)).thenReturn(java.util.Optional.of(user));

        userService.delete(user.getId());

        verify(userRepository).deleteById(user.getId());
    }

    @Test
    public void throwException() {
        User user = new User(7L, "Roy", "Jones");

        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        userService.delete(user.getId());
    }

    private UserDto entityToDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

}
