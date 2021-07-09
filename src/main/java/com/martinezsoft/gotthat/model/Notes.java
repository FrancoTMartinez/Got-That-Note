package com.martinezsoft.gotthat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document(collection = "Notes")
public class Notes {

    @JsonProperty("id")
    @Id
    public Integer id= null;

    @JsonProperty("userId")
    public Integer userId= null;

    @JsonProperty("title")
    private String title;

    @JsonProperty("text")
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
