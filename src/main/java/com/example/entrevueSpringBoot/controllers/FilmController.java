/**
 * @author Dominic Tardif
 */
package com.example.entrevueSpringBoot.controllers;

import com.example.entrevueSpringBoot.dao.FilmDAO;
import com.example.entrevueSpringBoot.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// Controller related to the Film class. Set up so that each request with the '/api' route.
@RestController
@RequestMapping("/api")
public class FilmController {

    // Dependency injection with the filmDAO bean (acteurDAO not needed in this exercise)
    @Autowired
    FilmDAO filmDAO;

    /**
     * Gets a film by id from the database. The id is a path variable in the endpoint
     * @param id the id of the movie
     * @return a Film object wrapped in a ResponseEntity object, which permits the return of the request status
     */
    @GetMapping("/film/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") long id){
        Optional<Film> filmData = filmDAO.findById(id);

        // checks if the movie was found and returns the appropriate response
        if (filmData.isPresent()){
            return new ResponseEntity<>(filmData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Adds a movie to the database. A Film object is part of the request body.
     * @param film a Film object with all attributes having a value
     * @return a Film object wrapped in a ResponseEntity object, which permits the return of the request status
     */
    @PostMapping("/film")
    public ResponseEntity<Film> createFilm(@RequestBody Film film){

        // attempt to add a movie to the database. In the case it fails, it will throw an exception.
        // in both cases, it returns the appropriate response
        try{
            Film _film = filmDAO.save(film);
            return new ResponseEntity<>(_film, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
