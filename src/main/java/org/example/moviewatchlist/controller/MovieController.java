package org.example.moviewatchlist.controller;

import jakarta.validation.Valid;
import org.example.moviewatchlist.dto.CreateMovieRequest;
import org.example.moviewatchlist.dto.MovieResponse;
import org.example.moviewatchlist.dto.UpdateMovieRequest;
import org.example.moviewatchlist.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public MovieResponse createMovie(@Valid @RequestBody CreateMovieRequest request){
        return movieService.createMovie(request);
    }

    @GetMapping
    public List<MovieResponse> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@Valid  @PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @Valid @RequestBody UpdateMovieRequest request){
        return ResponseEntity.ok(movieService.updateMovie(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/watched")
    public ResponseEntity<List<MovieResponse>> getWatchedMovies(){
        return ResponseEntity.ok(movieService.getWatchedMovies());
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieResponse>> getGenreMovies(@PathVariable String genre){
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

}
