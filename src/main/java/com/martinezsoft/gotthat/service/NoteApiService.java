package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RestController
@RequestMapping(value = "/services/user{id}/note")
public class NoteApiService{

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        noteRepository.save(note);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(note);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Note>> searchNotes(){
        List<Note> noteList = noteRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(noteList);
    }
    @GetMapping(value = "/get")
    public ResponseEntity<String> lookup(@PathVariable String noteId){
        noteRepository.findByid(noteId);
        return ResponseEntity.status(HttpStatus.OK).body(noteId);
    }
    @PutMapping(value = "/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> updateNote(@PathVariable String noteId,@RequestBody Note note){
        Note newNote = noteRepository.findByid(note.noteId);
        newNote.setText(note.getText());
        newNote.setTitle(note.getTitle());
        return ResponseEntity.status(HttpStatus.OK).body(newNote);
    }
     //after make deleted by date created dd/hh/ss
    @DeleteMapping(value = "/delete{id}",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteNote(@PathVariable String noteId){
        Note newNote = noteRepository.findByid(noteId);
        noteRepository.delete(newNote);
        return  ResponseEntity.status(HttpStatus.OK).body("Note deleted");
    }
}
