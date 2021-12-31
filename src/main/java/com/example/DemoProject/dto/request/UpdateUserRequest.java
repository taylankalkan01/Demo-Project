package com.example.DemoProject.dto.request;


public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private String middleName;

    public UpdateUserRequest(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public UpdateUserRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UpdateUserRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateUserRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public UpdateUserRequest setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }
}
