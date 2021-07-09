package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/services/user")
public interface UserService {

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Users> lookUp(@PathVariable Integer id); //all users

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Users>> search();

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity <Users> add(@RequestBody Users users);

    @PutMapping(value = "/update/{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Users> update(@PathVariable Integer id, @RequestBody Users users);

    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> delete(@PathVariable Integer id);

}
