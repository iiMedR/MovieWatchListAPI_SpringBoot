package org.example.moviewatchlist.service;

import org.example.moviewatchlist.dto.CreateMovieRequest;
import org.example.moviewatchlist.dto.MovieResponse;
import org.example.moviewatchlist.dto.UpdateMovieRequest;
import org.example.moviewatchlist.exception.MovieNotFoundException;
import org.example.moviewatchlist.model.Movie;
import org.example.moviewatchlist.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private MovieResponse toResponse(Movie movie) {
        return new MovieResponse(movie.getTitle(), movie.getDirector(), movie.getReleaseYear(), movie.getGenre(), movie.isWatched(), movie.getRating());
    }


    private Movie getMovieEntityById(Long id){
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }







}
