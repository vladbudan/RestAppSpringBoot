package com.vladbudan.app.dto.converter;

import com.vladbudan.app.dto.modelDto.UserDto;
import com.vladbudan.app.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDto convertToDto(User user) {

        return modelMapper.map(user, UserDto.class);
    }

    public User convertToEntity(UserDto userDto) {

        return modelMapper.map(userDto, User.class);
    }

}
