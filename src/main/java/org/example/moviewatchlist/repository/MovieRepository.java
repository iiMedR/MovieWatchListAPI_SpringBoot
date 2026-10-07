package org.example.moviewatchlist.repository;

import org.example.moviewatchlist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public List<Movie> findByWatchedIsTrue();

}
