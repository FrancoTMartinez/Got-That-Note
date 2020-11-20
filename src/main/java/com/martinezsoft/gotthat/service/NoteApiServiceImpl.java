package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.database.HibernateSessionFactory;
import com.martinezsoft.gotthat.model.Notes;
import com.martinezsoft.gotthat.model.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public class NoteApiServiceImpl implements NoteApiService{

    private HibernateSessionFactory hibernateSessionFactory;
    private Session noteSession;

    public NoteApiServiceImpl(HibernateSessionFactory hibernateSessionFactory) throws Exception{
        this.hibernateSessionFactory = hibernateSessionFactory;
        noteSession = hibernateSessionFactory.buildSession();
    }

    private Notes noteReturnedFromDataBase (String id){
        Notes notesReturned;
        try{
            noteSession.beginTransaction();
            Query selectQuery = noteSession.createQuery("from Notes WHERE USER_ID=:paramId");
            selectQuery.setParameter("paramId", id);
            notesReturned = (Notes) selectQuery.uniqueResult();
            return notesReturned;
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Notes> addNote(Notes notes, String userId) {
        noteSession.beginTransaction();
        notes.setUserID(userId);
        noteSession.save(notes);
        noteSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(notes);
    }

    @Override
    public ResponseEntity<List<Notes>> searchNotes() {
        noteSession.beginTransaction();
        List<Notes> notesList = noteSession.createQuery("from Notes", Notes.class).list();
        noteSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body(notesList);
    }

    @Override
    public ResponseEntity<Notes> lookup(String noteId) {
        return ResponseEntity.status(HttpStatus.OK).body(noteReturnedFromDataBase(noteId));
    }

    @Override
    public ResponseEntity<Notes> updateNote(String noteId, Notes notes) {
        Notes notesReturned = noteReturnedFromDataBase(noteId);
        notesReturned.setTitle(notes.getTitle());
        notesReturned.setText(notes.getText());
        noteSession.update(notes);
        noteSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body(notesReturned);
    }

    @Override
    public ResponseEntity<String> deleteNote(String noteId) {
        noteSession.delete(noteReturnedFromDataBase(noteId));
        noteSession.getTransaction().commit();
        return ResponseEntity.status(HttpStatus.OK).body("Note deleted");
    }
}
