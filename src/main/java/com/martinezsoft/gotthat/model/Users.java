package com.martinezsoft.gotthat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class Users {
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",nullable = false ,unique = true)
    private Integer id;

    @JsonProperty("email")
    @Column(name = "EMAIL",nullable = false, unique = true)
    private String email;

    @JsonProperty("password")
    @Column(name = "USER_PASSWORD",nullable = false, unique = true)
    private String userPassword;

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Users(){}

    public Users(Integer id, String email, String userPassword) {
        this.id = id;
        this.email = email;
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return id.equals(users.id) &&
                email.equals(users.email) &&
                userPassword.equals(users.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, userPassword);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
