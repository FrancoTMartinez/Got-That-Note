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

    @JsonProperty("noteId")
    @Id
    @Column(name = "NOTE_ID")
    public String noteId= null;

    @JsonProperty("userId")
    @Column(name = "USER_ID")
    public String userID= null;

    @JsonProperty("title")
    @Column(name = "TITTLE")
    private String title;

    @JsonProperty("text")
    @Column(name = "TEXT")
    private String text;

    private String creationDate = new String();

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
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

    public String getCreationDate() {
        return creationDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Notes(String userID) {
        this.userID = userID;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Notes(){}

    public Notes(String noteId, String title, String text, String creationDate) {
        this.noteId = noteId;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNoteId(), getTitle(), getText(), getCreationDate());
    }

    @Override
    public String toString() {
        return "Notes{" +
                "noteId='" + noteId + '\'' +
                ", userID='" + userID + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notes notes = (Notes) o;
        return noteId.equals(notes.noteId) &&
                userID.equals(notes.userID) &&
                title.equals(notes.title) &&
                text.equals(notes.text) &&
                creationDate.equals(notes.creationDate);
    }



}
