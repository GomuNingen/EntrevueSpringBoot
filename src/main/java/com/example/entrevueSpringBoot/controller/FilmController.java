package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.dao.ActeurDAO;
import com.example.entrevueSpringBoot.dao.FilmDAO;
import com.example.entrevueSpringBoot.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FilmController {

    @Autowired
    FilmDAO filmDAO;

    @Autowired
    ActeurDAO acteurDAO;

    @GetMapping("/film/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") long id){
        Optional<Film> filmData = filmDAO.findById(id);

        if (filmData.isPresent()){
            return new ResponseEntity<>(filmData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/film")
    public ResponseEntity<Film> createFilm(@RequestBody Film film){
        try{
            Film _film = filmDAO.save(new Film(film.getTitre(), film.getDescription(), film.getActeurs()));
            return new ResponseEntity<>(_film, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
