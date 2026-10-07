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

    public MovieResponse createMovie(CreateMovieRequest request){
        Movie movie = new Movie();
        movie.setTitle(request.title());
        movie.setDirector(request.director());
        movie.setReleaseYear(request.releaseYear());
        movie.setGenre(request.genre());
        movie.setWatched(false);
        movie.setRating(0);

        movieRepository.save(movie);
        return toResponse(movie);
    }

    private Movie getMovieEntityById(Long id){
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    public List<MovieResponse> getAllMovies(){
        return movieRepository.findAll().stream().map(this::toResponse).toList();
    }

    public MovieResponse getMovieById(Long id){
        Movie movie = getMovieEntityById(id);
        return toResponse(movie);
    }





}
