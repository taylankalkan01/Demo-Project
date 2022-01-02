package com.example.DemoProject.service;

import com.example.DemoProject.dto.UserDto;
import com.example.DemoProject.model.User;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestSupport {

    private final static Long userId = 100L;

    public static List<User> generateUsers() {
        return IntStream.range(0, 5).mapToObj(i ->
                                                      new User((long) i,
                                                              i + "@deneme.com",
                                                              "firstName" + i,
                                                              "lastName" + i,
                                                              "",
                                                              new Random(2).nextBoolean())
        ).collect(Collectors.toList());
    }

    public static List<UserDto> generateUserDtoList(List<User> userList) {
        return userList.stream()
                .map(from -> new UserDto(
                from.getId(),
                from.getMail(),
                from.getFirstName(),
                from.getLastName(),
                from.getMiddleName())).
                collect(Collectors.toList());
    }

    public static User generateUser(Long userId){
        return new User(userId,
                userId + "@deneme.com",
                "firstName" + userId,
                "lastName" + userId,
                "",
                true);
    }

    public static UserDto generateUserDto(Long userId){
        return new UserDto(userId,
                userId + "@deneme.com",
                "firstName" + userId,
                "lastName" + userId,
                "");
    }

}
