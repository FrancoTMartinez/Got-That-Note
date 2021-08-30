package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteApiService extends MongoRepository<Notes, String> {
}
