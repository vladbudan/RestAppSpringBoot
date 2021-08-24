package com.vladbudan.app.dto.converter;

import com.vladbudan.app.dto.model.UserDto;
import com.vladbudan.app.model.User;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class UserConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserDto convertToDto(User user) {

        return modelMapper.map(user, UserDto.class);
    }

    public static User convertToEntity(UserDto userDto) {

        return modelMapper.map(userDto, User.class);
    }

    public static List<UserDto> convertListToDto(List<User> users) {

        return users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

}
