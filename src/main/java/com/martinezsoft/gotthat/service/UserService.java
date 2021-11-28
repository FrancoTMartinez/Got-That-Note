package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Users;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/services/user")
public interface UserService {

    @Operation(summary = "Search an User by id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "User found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))}),
    })
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Users> lookUp(@PathVariable Integer id);

    @Operation(summary = "Search for all users on the database")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Users found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))}),
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<Users>> search();

    @Operation(summary = "Adds a User to the database")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "User successfully created",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid body applied",
                    content= @Content)
                    })
    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity <Users> add(@RequestBody Users users);

    @Operation(summary = "Updates User data finding it by id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "User updated",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))}),
    })
    @PutMapping(value = "/update/{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Users> update(@PathVariable Integer id, @RequestBody Users users);

    @Operation(summary = "Delete User data finding it by id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "User found",
                    content ={@Content(mediaType = "application/json")}),
    })
    @GetMapping(value = "/delete/{id}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> delete(@PathVariable Integer id);

    @Operation(summary = "Consult into dataBase if the user exist")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "User successfully found",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Users.class))}),
            @ApiResponse(responseCode = "400", description = "User not found",
                    content= @Content)
    })
    @GetMapping(value = "/logIn/{email}/{password}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity <Boolean> logIn(@PathVariable("email") String email,@PathVariable("password") String password );

}
