package com.example.DemoProject.dto;


public class UserDto {
    private Long id;
    private String mail;
    private String firstName;
    private String lastName;
    private String middleName;

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public UserDto(Long id, String mail, String firstName, String lastName, String middleName) {
        this.id = id;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public UserDto() {
    }

    public String getMail() {
        return mail;
    }

    public UserDto setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public UserDto setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }
}

