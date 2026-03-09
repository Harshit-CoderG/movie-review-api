package com.campusclassroom.movies.controllers;

import com.campusclassroom.movies.entity.Movie;
import com.campusclassroom.movies.repository.MovieRepository;
import com.campusclassroom.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private MovieService movieService;
    MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getallMovies(){
       return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingMovie(@PathVariable String imdbId){
return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId),HttpStatus.OK);
    }
}
