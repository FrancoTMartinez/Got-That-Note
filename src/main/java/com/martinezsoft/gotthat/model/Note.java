package com.martinezsoft.gotthat.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Objects;

@Document(collation = "notes")
public class Note {
    @Id
    public String noteId;
    private String title;
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
