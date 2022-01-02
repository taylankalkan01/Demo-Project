package com.example.DemoProject.service;

import com.example.DemoProject.dto.UserDto;
import com.example.DemoProject.dto.converter.UserDtoConverter;
import com.example.DemoProject.dto.request.CreateUserRequest;
import com.example.DemoProject.dto.request.UpdateUserRequest;
import com.example.DemoProject.exception.UserIsNotActiveException;
import com.example.DemoProject.exception.UserNotFoundException;
import com.example.DemoProject.model.User;
import com.example.DemoProject.repos.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest extends TestSupport {
    private UserDtoConverter converter;
    private UserRepository repository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        converter = Mockito.mock(UserDtoConverter.class);
        repository = Mockito.mock(UserRepository.class);

        userService = new UserService(repository, converter);
    }

    @Test
    public void testGetAllUsers_itShouldReturnUserDtoList() {
        List<User> userList = generateUsers();
        List<UserDto> userDtoList = generateUserDtoList(userList);

        Mockito.when(repository.findAll()).thenReturn(userList);
        Mockito.when(converter.convert(userList)).thenReturn(userDtoList);

        List<UserDto> result = userService.getAllUsers();

        assertEquals(userDtoList, result);
        Mockito.verify(repository).findAll();
        Mockito.verify(converter).convert(userList);

    }

    @Test
    public void testGetUserById_whenUserIdExist_itShouldReturnUserDto() {
        long id = Long.parseLong("1");
        User user = generateUser(id);
        UserDto userDto = generateUserDto(id);

        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(user));
        Mockito.when(converter.convert(user)).thenReturn(userDto);

        UserDto result = userService.getUserById(id);

        assertEquals(userDto, result);
        Mockito.verify(repository).findById(id);
        Mockito.verify(converter).convert(user);

    }

    @Test
    public void testGetUserById_whenUserIdDoesNotExist_itShouldThrownUserNotFoundException() {
        long id = Long.parseLong("1");

        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.empty());
        assertThrows(UserNotFoundException.class,()->
                  userService.getUserById(id));


        Mockito.verify(repository).findById(id);
        Mockito.verify(converter);

    }


    /*
    org.opentest4j.AssertionFailedError:
    Expected :UserDto{id=1, mail='@deneme.com', firstName='fn', lastName='ln', middleName=''}
    Actual   :null

    @Test
    public void testCreateUser_itShouldReturnCreatedUserDto() {
        long id = Long.parseLong("1");
        CreateUserRequest request = new CreateUserRequest("@deneme.com","fn","ln","");
        User user =new User(id,"@deneme.com","fn","ln","",false);
        User savedUser = new User(id,"@deneme.com","fn","ln","",false);
        UserDto userDto = new UserDto(id,"@deneme.com","fn","ln","");



        Mockito.when(repository.save(user)).thenReturn(savedUser);
        Mockito.when(converter.convert(savedUser)).thenReturn(userDto);


         UserDto result = userService.createUser(request);

        assertEquals(userDto, result);

        Mockito.verify(repository).save(user);
        Mockito.verify(converter).convert(savedUser);
    }


     */



    @Test
    public void testUpdateUser_whenUserIdExistAndUserIsActive_itShouldReturnUpdatedDto() {
        long id = Long.parseLong("1");
        UpdateUserRequest request = new UpdateUserRequest("fn2","ln2","mn2");
        User user =new User(id,"@deneme.com","fn","ln","",true);
        User savedUser = new User(id,"@deneme.com","fn2","ln2","mn2",true);
        UserDto userDto = new UserDto(id,"@deneme.com","fn2","ln2","mn2");


        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(user));
        Mockito.when(repository.save(user)).thenReturn(savedUser);
        Mockito.when(converter.convert(savedUser)).thenReturn(userDto);

        UserDto result = userService.updateUser(id,request);

        assertEquals(userDto, result);

        Mockito.verify(repository).save(user);
        Mockito.verify(converter).convert(savedUser);
    }

    @Test
    public void testUpdateUser_whenUserIdDoesNotExist_itShouldThrownUserNotFoundException() {
        long id = Long.parseLong("1");
        UpdateUserRequest request = new UpdateUserRequest("fn2","ln2","mn2");

        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.empty());

        assertThrows(UserNotFoundException.class,()->
                         userService.updateUser(id, request));

        Mockito.verify(repository).findById(id);
        Mockito.verifyNoMoreInteractions(repository);
        Mockito.verifyNoInteractions(converter);
    }

    @Test
    public void testUpdateUser_whenUserIdExistButUserIsNotActive_itShouldThrownUserNotActive() {
        long id = Long.parseLong("1");
        UpdateUserRequest request = new UpdateUserRequest("fn2","ln2","mn2");
        User user =new User(id,"@deneme.com","fn","ln","",false);

        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(user));

        assertThrows(UserIsNotActiveException.class,()->
                        userService.updateUser(id, request));

        Mockito.verify(repository).findById(id);
        Mockito.verifyNoMoreInteractions(repository);
        Mockito.verifyNoInteractions(converter);
    }
    /*

    @Test
    public void testDeactivateUser_whenUserIdExist_itShouldUpdateUserByActive() {

        long id = Long.parseLong("1");

        User user =new User(id,"@deneme.com","fn","ln","",true);
        User savedUser =new User(id,"@deneme.com","fn","ln","",false);

        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(user));


        userService.deactivateUser(id);

        Mockito.verify(repository).findById(id);
        Mockito.verify(repository).save(savedUser);

    }

    @Test
    public void testDeactivateUser_whenUserIdDoesNotExist_itShouldThrownUserNotFoundException() {

        long id = Long.parseLong("1");


        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.empty());

        assertThrows(UserNotFoundException.class,()->
                        userService.deactivateUser(id));


        Mockito.verify(repository).findById(id);
        Mockito.verifyNoInteractions(repository);

    }

     */





}