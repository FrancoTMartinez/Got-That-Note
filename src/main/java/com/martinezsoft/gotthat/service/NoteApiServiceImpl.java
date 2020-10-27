package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RestController
@RequestMapping(value = "/services/user{id}/note")

public class NoteApiServiceImpl implements NoteApiService{

    @Autowired
    private NoteRepository noteRepository;


    @Override
    public ResponseEntity<Note> addNote(Note note) {
        noteRepository.save(note);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(note);
    }

    @Override
    public ResponseEntity<List<Note>> searchNotes() {
        List<Note> noteList = noteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(noteList);
    }

    @Override
    public ResponseEntity<String> lookup(String noteId) {
        noteRepository.findById(noteId);
        return ResponseEntity.status(HttpStatus.OK).body(noteId);
    }

    @Override
    public ResponseEntity<Note> updateNote(String noteId, Note note) {
        Note newNote = (Note) noteRepository.existsById(note.noteId);
        return null;
    }

    @Override
    public ResponseEntity<String> deleteNote(String noteId) {
        return null;
    }
}
