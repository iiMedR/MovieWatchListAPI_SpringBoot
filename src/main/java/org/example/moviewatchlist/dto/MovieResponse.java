package org.example.moviewatchlist.dto;

public record MovieResponse(
        String title,
        String director,
        Integer releaseYear,
        String genre,
        Boolean watched,
        Integer rating
) {
}
