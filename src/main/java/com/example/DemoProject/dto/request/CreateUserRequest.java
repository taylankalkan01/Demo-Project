package com.example.DemoProject.dto.request;

public class CreateUserRequest {
    private String mail;
    private String firstName;
    private String lastName;
    private String middleName;

    public CreateUserRequest(String mail, String firstName, String lastName, String middleName) {
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public CreateUserRequest() {
    }

    @Override
    public String toString() {
        return "User{" +
                       ", mail='" + mail + '\'' +
                       ", firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", middleName='" + middleName + '\'' +
                       '}';
    }


    public String getMail() {
        return mail;
    }

    public CreateUserRequest setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateUserRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateUserRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public CreateUserRequest setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }
}
