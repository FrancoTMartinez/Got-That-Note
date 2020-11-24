package com.martinezsoft.gotthat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "Notes")
public class Notes {

    @JsonProperty("id")
    @Id
    public Integer id= null;

    @JsonProperty("userId")
    @Column(name = "USER_ID")
    public Integer userId= null;

    @JsonProperty("title")
    @Column(name = "TITLE")
    private String title;

    @JsonProperty("text")
    @Column(name = "TEXT")
    private String text;


    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Notes(){}

    public Notes(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getid(), getTitle(), getText());
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notes notes = (Notes) o;
        return id.equals(notes.id) &&
                userId.equals(notes.userId) &&
                title.equals(notes.title) &&
                text.equals(notes.text);
    }



}
