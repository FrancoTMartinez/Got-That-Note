package com.martinezsoft.gotthat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Users")
public
class Users {
    @JsonProperty("userId")
    @Id
    private String UserId = null;

    @JsonProperty("email")
    @Column(name = "EMAIL")
    private String email = null;

    @JsonProperty("password")
    @Column(name = "USER_PASSWORD")
    private String userPassword = null;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
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

    public Users(String UserId, String email, String userPassword) {
        this.UserId = UserId;
        this.email = email;
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return UserId.equals(users.UserId) &&
                email.equals(users.email) &&
                userPassword.equals(users.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, email, userPassword);
    }

    @Override
    public String toString() {
        return "Users{" +
                "UserId='" + UserId + '\'' +
                ", email='" + email + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
