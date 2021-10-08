package com.martinezsoft.gotthat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document(collection = "Notes")
public class Notes {


    @JsonProperty("id")
    @Id
    private String id;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("text")
    private String text;

    @JsonProperty("favorite")
    private boolean favorite;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    public boolean isFavorite() {
        return favorite;
    }

    public Notes(){}

    public Notes(String id, String userId, String title, String text, boolean favorite) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.favorite=favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notes notes = (Notes) o;
        return id.equals(notes.id) && userId.equals(notes.userId) && title.equals(notes.title) && text.equals(notes.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, text, favorite);
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }




}
