package com.martinezsoft.gotthat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class Users {
    @JsonProperty("id")
    @Id
    private Integer id = null;

    @JsonProperty("email")
    @Column(name = "EMAIL")
    private String email = null;

    @JsonProperty("password")
    @Column(name = "USER_PASSWORD")
    private String userPassword = null;

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
