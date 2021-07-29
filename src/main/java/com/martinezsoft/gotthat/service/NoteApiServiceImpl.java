package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:28017")
@RequestMapping(value = "/services/notes")
public class NoteApiServiceImpl{

    @Autowired
    NoteApiService noteApiService;

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Notes> addNote(@RequestBody Notes notes) {
       try{
           if(notes.getUserId()!=null){ //Valido que el id del usuario que viene de jSon sea !=NULL
               noteApiService.save(notes);
               return ResponseEntity.status(HttpStatus.CREATED).body(notes);
           }else{
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
           }
       }catch (EntityNotFoundException e){
           throw new EntityNotFoundException(e.getMessage());
       }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Notes>> searchNotes() {
        try{
            List<Notes> notesList= new ArrayList<Notes>();
            noteApiService.findAll().forEach(notesList::add);
            if(notesList.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(notesList);
            }
            return ResponseEntity.status(HttpStatus.OK).body(notesList);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @GetMapping(value = "/get/{idNote}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Notes> lookup(@PathVariable Integer id) {
        String idNoteStr= String.valueOf(id);
        Optional<Notes> notesId= noteApiService.findById(idNoteStr);
        if(notesId.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(notesId.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping(value = "/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Notes> updateNote(@PathVariable Integer id, @RequestBody Notes notes) {
        String idNoteStr= String.valueOf(id);
        Optional<Notes> notesId= noteApiService.findById(idNoteStr);

        if(notesId.isPresent()){
            Notes noteToUpdate = notesId.get();
            noteToUpdate.setText(notes.getText());
            noteToUpdate.setTitle(notes.getTitle());

            noteApiService.save(noteToUpdate);
            return ResponseEntity.status(HttpStatus.CREATED).body(noteToUpdate);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //after make deleted by date created dd/hh/ss
    @DeleteMapping(value = "/delete/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteNote(@PathVariable Integer id) {

        String idNoteStr= String.valueOf(id);
        Optional<Notes> notesId= noteApiService.findById(idNoteStr);

        if(notesId.isPresent()){

            noteApiService.deleteById(idNoteStr);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
