package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Notes;
import com.martinezsoft.gotthat.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/services/notes")
public interface NoteApiService{

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Notes> addNote(@RequestBody Notes notes);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Notes>> searchNotes();

    @GetMapping(value = "/get/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Notes> lookup(@PathVariable Integer id);

    @PutMapping(value = "/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Notes> updateNote(@PathVariable Integer id, @RequestBody Notes notes);

    //after make deleted by date created dd/hh/ss
    @DeleteMapping(value = "/delete/{id}",produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteNote(@PathVariable Integer id);
}
