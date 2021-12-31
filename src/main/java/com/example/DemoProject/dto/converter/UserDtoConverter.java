package com.example.DemoProject.dto.converter;

import com.example.DemoProject.dto.UserDto;
import com.example.DemoProject.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User from) {
        return new UserDto(
                from.getId(),
                from.getMail(),
                from.getFirstName(),
                from.getLastName(),
                from.getMiddleName()
        );

    }
}
