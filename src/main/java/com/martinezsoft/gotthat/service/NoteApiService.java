package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface NoteApiService extends MongoRepository<Notes, String> {

    @Query("{userId:?0}")
    List<Notes> GetAllNotesByUserId(String id);

    @Query("{userId:?0, favorite:true}")
    List<Notes> GetAllFavoritesNotesByUserId(String id);

    @Query("{userId:?0,date:?1}")
    List<Notes> GetAllNotesByDateTime(String userId, LocalDate date);
}
