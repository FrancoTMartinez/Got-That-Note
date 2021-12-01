package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Notes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/services/notes")
public class NoteApiServiceImpl{

    @Autowired
    NoteApiService noteApiService;

    @Operation(summary = "Add Notes to the database")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Note successfully added",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid body applied",
                    content= @Content)
    })
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Notes> addNote(@RequestBody Notes notes){
       try{
           if(notes.getUserId() != null){
               notes.setDate(LocalDate.now());
               noteApiService.save(notes);
               return ResponseEntity.status(HttpStatus.CREATED).body(notes);
           }else{
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
           }
       }catch (EntityNotFoundException e){
           throw new EntityNotFoundException(e.getMessage());
       }
    }

    @Operation(summary = "Search for all notes on the database")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Notes found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notes>> searchNotes() {
        try{
            List<Notes> notesList;
            notesList= noteApiService.findAll();

            return ResponseEntity.status(HttpStatus.OK).body(notesList);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Operation(summary = "Search for all notes of one UserId on the database")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Notes found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
    })
    @GetMapping(value="/user/{id}",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notes>> searchNotesByUserId(@PathVariable String id) {
        try{
            List<Notes> notesList=noteApiService.GetAllNotesByUserId(id);

            if(notesList.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(notesList);
            }

        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Operation(summary = "Search a Notes by object id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Notes found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
    })
    @GetMapping(value = "/get/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Notes> lookup(@PathVariable String id) {
        Optional<Notes> notesId= noteApiService.findById(id);
        if(notesId.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(notesId.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Updates Note data finding it by Object id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Note updated",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
    })
    @PutMapping(value = "/update/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Notes> updateNote(@PathVariable String id, @RequestBody Notes notes) {
        Optional<Notes> notesId= noteApiService.findById(id);

        if(notesId.isPresent()){
            Notes noteToUpdate = notesId.get();
            noteToUpdate.setText(notes.getText());
            noteToUpdate.setTitle(notes.getTitle());
            noteToUpdate.setFavorite(notes.isFavorite());

            noteApiService.save(noteToUpdate);
            return ResponseEntity.status(HttpStatus.CREATED).body(noteToUpdate);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Delete note data finding it by object id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Note found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
    })
    @DeleteMapping(value = "/delete/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteNote(@PathVariable String id) {

        Optional<Notes> notesId= noteApiService.findById(id);

        if(notesId.isPresent()){

            noteApiService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Set or disable favorite from an specific note")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Note found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
    })
    @GetMapping(value = "/favorite/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> favoriteNote(@PathVariable String id) {
        try{

            Optional<Notes> noteToUpdate= noteApiService.findById(id);

            if(noteToUpdate.isPresent()){
                Notes note = noteToUpdate.get();
                if(note.isFavorite()){
                    note.setFavorite(false);
                }else{
                    note.setFavorite(true);
                }

                noteApiService.save(note);
                return ResponseEntity.status(HttpStatus.OK).body(null);

            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    @Operation(summary = "Return all notes of the user that are marked like favorite")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Note found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
    })
    @GetMapping(value = "/user/{id}/favorites", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notes>> FindAllFavoritesNotes(@PathVariable String id) {
        try{
            List<Notes> notesList= noteApiService.GetAllFavoritesNotesByUserId(id);

            if(notesList.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(notesList);
            }

        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }
    @Operation(summary = "Return all notes of the user that were created on specific date")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Notes found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notes.class))}),
    })
    @GetMapping(value = "/user/{id}/{date}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notes>> FindAllCreatedNotes(@PathVariable String id, @PathVariable String date) {
        try{
            LocalDate localDate= LocalDate.parse(date);
            List<Notes> notesList = noteApiService.GetAllNotesByDateTime(id,localDate);

            if(notesList.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(notesList);
            }

        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

}
