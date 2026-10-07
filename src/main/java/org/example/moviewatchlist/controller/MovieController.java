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








}
