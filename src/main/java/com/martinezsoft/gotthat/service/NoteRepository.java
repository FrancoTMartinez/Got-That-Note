package com.martinezsoft.gotthat.service;

import com.martinezsoft.gotthat.model.Note;
import com.mongodb.client.MongoClients;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class NoteRepository implements MongoRepository<Note, String> {


    @Override
    public <S extends Note> S save(S s) {
        return null;
    }

    @Override
    public <S extends Note> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Note> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Note> findAll() {
        return null;
    }

    @Override
    public Iterable<Note> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Note note) {

    }

    @Override
    public void deleteAll(Iterable<? extends Note> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Note> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Note> S insert(S s) {
        return null;
    }

    @Override
    public <S extends Note> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Note> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Note> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Note> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Note> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Note> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Note> boolean exists(Example<S> example) {
        return false;
    }
}
