package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Note;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



/*public interface NoteApiService{

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Note> addNote(@RequestBody Note note);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Note>> searchNotes();

    @GetMapping(value = "/get", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> lookup(@PathVariable String noteId);

    @PutMapping(value = "/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Note> updateNote(@PathVariable String noteId,@RequestBody Note note);

    //after make deleted by date created dd/hh/ss
    @DeleteMapping(value = "/delete{id}",produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteNote(@PathVariable String noteId);
}*/
