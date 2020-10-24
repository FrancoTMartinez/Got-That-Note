package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Note;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {


    public Note findByid(String noteIdMongodbApplication);
}
