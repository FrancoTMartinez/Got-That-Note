package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Notes;
import com.martinezsoft.gotthat.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


public interface NoteApiService extends MongoRepository<Notes, String> {

}
