package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import com.martinezsoft.gotthat.model.Note;
import com.martinezsoft.gotthat.model.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public class NoteApiServiceImpl implements NoteApiService{

    private HibernateSessionFactory hibernateSessionFactory;
    private Session userSession;

    public NoteApiServiceImpl(HibernateSessionFactory hibernateSessionFactory) throws Exception{
        this.hibernateSessionFactory = hibernateSessionFactory;
        userSession = hibernateSessionFactory.buildSession();
    }

    private Note noteReturnedFromDataBase (String id){
        Note notesReturned;
        try{
            userSession.beginTransaction();
            Query selectQuery = userSession.createQuery("from Notes WHERE USER_ID=:paramId");
            selectQuery.setParameter("paramId", id);
            notesReturned = (Note) selectQuery.uniqueResult();
            return notesReturned;
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Note> addNote(Note note, Users user) {
        userSession.beginTransaction();
        //note.setNoteId(user.getUserId());
        userSession.save(note);
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(note);
    }

    @Override
    public ResponseEntity<List<Note>> searchNotes() {
        userSession.beginTransaction();
        List<Note> noteList = userSession.createQuery("from Notes", Note.class).list();
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body(noteList);
    }

    @Override
    public ResponseEntity<Note> lookup(String noteId) {
        return ResponseEntity.status(HttpStatus.OK).body(noteReturnedFromDataBase(noteId));
    }

    @Override
    public ResponseEntity<Note> updateNote(String noteId, Note note) {
        Note notesReturned = noteReturnedFromDataBase(noteId);
        notesReturned.setTitle(note.getTitle());
        notesReturned.setText(note.getText());
        userSession.update(note);
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body(notesReturned);
    }

    @Override
    public ResponseEntity<String> deleteNote(String noteId) {
        userSession.delete(noteReturnedFromDataBase(noteId));
        userSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body("Note deleted");
    }
}
