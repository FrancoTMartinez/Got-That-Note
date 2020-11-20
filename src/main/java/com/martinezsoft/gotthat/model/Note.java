package com.martinezsoft.gotthat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "Note")
public class Note {
    @JsonProperty("noteId")
    @Id
    @Column(name = "NOTE_ID")
    public String noteId= null;

    @JsonProperty("title")
    @Column(name = "TITTLE")
    private String title;

    @JsonProperty("text")
    @Column(name = "TEXT")
    private String text;

    private String creationDate = new String();

    public Note(Note note) {

    }

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

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }


    public Note(String noteId, String title, String text, String creationDate) {
        this.noteId = noteId;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId='" + noteId + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return getNoteId().equals(note.getNoteId()) &&
                getTitle().equals(note.getTitle()) &&
                getText().equals(note.getText()) &&
                getCreationDate().equals(note.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNoteId(), getTitle(), getText(), getCreationDate());
    }






}
