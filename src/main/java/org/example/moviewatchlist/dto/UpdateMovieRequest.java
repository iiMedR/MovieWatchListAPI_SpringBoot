package org.example.moviewatchlist.dto;

import jakarta.validation.constraints.*;

public record UpdateMovieRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 50, message = "title should not exceed 50 characters")
        String title,
        @NotBlank(message = "Director is required")
        @Size(max = 50, message = "Director name should not exceed 50 characters")
        String director,
        @NotBlank(message = "Release year is required")
        @Min(1900)
        @Max(2026)
        Integer releaseYear,
        @NotBlank(message = "Genre is required")
        @Size(max = 20, message = "Genre should not exceed 20 characters")
        String genre,
        @NotNull
        Boolean watched,
        @Max(10)
        Integer rating
) {
}
