package com.example.DemoProject.model;


import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(unique = true)
    private String mail;
    private String firstName;
    private String lastName;
    private String middleName;

    public User(Long id, String mail, String firstName, String lastName, String middleName) {
        this.id = id;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                       "id=" + id +
                       ", mail='" + mail + '\'' +
                       ", firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", middleName='" + middleName + '\'' +
                       '}';
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public User setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public User setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }
}

