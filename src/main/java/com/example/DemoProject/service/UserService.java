package com.example.DemoProject.service;


import com.example.DemoProject.dto.UserDto;
import com.example.DemoProject.dto.converter.UserDtoConverter;
import com.example.DemoProject.dto.request.CreateUserRequest;
import com.example.DemoProject.dto.request.UpdateUserRequest;
import com.example.DemoProject.exception.UserIsNotActiveException;
import com.example.DemoProject.exception.UserNotFoundException;
import com.example.DemoProject.model.User;
import com.example.DemoProject.repos.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service

public class UserService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    //find user by id exception
    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User id could not be found!"));
    }

    //find user by mail exception
    private UserRepository findUserByMail(String mail) {
        return userRepository.findByMail(mail)
                .orElseThrow(() -> new UserNotFoundException("User id could not be found!"));
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest userRequest) {
        User user = new User(null,
                userRequest.getMail(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getMiddleName(),
                true);
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = findUserById(id);
        if (!user.getActive()){
            logger.warning("This user is not active!");
            throw new UserIsNotActiveException("This user is not active!");
        }
        User updatedUser = new User(user.getId(),
                user.getMail(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName());
        return userDtoConverter.convert(userRepository.save(updatedUser));


    }

    public void deactivateUser(Long id) {
        User user = findUserById(id);

        User updatedUser = new User(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getMail(),
                false);

        userRepository.save(updatedUser);

    }
    public void activeUser(Long id) {
        User user = findUserById(id);

        User updatedUser = new User(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getMail(),
                true);

        userRepository.save(updatedUser);
    }

    //checking
    private boolean doesUserExist(Long id){
        return userRepository.existsById(id);

    }


    public void deleteUser(Long id) {
        if (doesUserExist(id)){
            userRepository.deleteById(id);
        } else{
            throw new UserNotFoundException("User id: " + id + " could not be found!");
        }



    }

}

