package com.example.DemoProject.dto.converter;

import com.example.DemoProject.dto.UserDto;
import com.example.DemoProject.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<UserDto> convert(List<User> fromList) {
        return fromList.stream().map(from -> new UserDto(
                from.getId(),
                from.getMail(),
                from.getFirstName(),
                from.getLastName(),
                from.getMiddleName())).
                collect(Collectors.toList());
    }
}
