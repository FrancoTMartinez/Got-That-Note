/*package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(value = "/services/user{id}/note")

public class NoteApiServiceImpl implements NoteApiService{

    @Autowired
    public SimpleMongoRepository simpleMongoRepository;

    public NoteApiServiceImpl(SimpleMongoRepository simpleMongoRepository) {

    }


    @Override
    public ResponseEntity<Note> addNote(Note note) {
        simpleMongoRepository.save(note);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(note);
    }

    @Override
    public ResponseEntity<List<Note>> searchNotes() {
        List<Note> noteList = simpleMongoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(noteList);
    }

    @Override
    public ResponseEntity<String> lookup(String noteId) {
        simpleMongoRepository.findAllById(Collections.singleton(noteId));
        return ResponseEntity.status(HttpStatus.OK).body(noteId);
    }

    @Override
    public ResponseEntity<Note> updateNote(String noteId, Note note) {
        Optional newNote = simpleMongoRepository.findById(noteId);
        Note note1 = (Note) simpleMongoRepository.save(newNote);
        return ResponseEntity.status(HttpStatus.OK).body(note1);
    }

    @Override
    public ResponseEntity<String> deleteNote(String noteId) {
        simpleMongoRepository.delete(noteId);
        return ResponseEntity.status(HttpStatus.OK).body("Note deleted");
    }
}
*/