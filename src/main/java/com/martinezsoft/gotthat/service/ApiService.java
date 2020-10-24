package com.martinezsoft.gotthat.service;import org.springframework.http.MediaType;

import com.martinezsoft.gotthat.model.Note;
import com.martinezsoft.gotthat.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface ApiService {
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<User> lookUp(@PathVariable String id); //all users

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<User>> search();

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity <User> add(@RequestBody User user);

    @PutMapping(value = "/update/{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<User> update(@PathVariable String id, @RequestBody User user);

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> delete(@PathVariable String id);

}
