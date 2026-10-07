package org.example.moviewatchlist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateMovieRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 50, message = "title should not exceed 50 characters")
        String title,
        @NotBlank(message = "Director is required")
        @Size(max = 50, message = "Director name should not exceed 50 characters")
        String director,
        @NotBlank(message = "Release year is required")
        @Size(min = 4, max = 4, message = "Release year should not exceed 4 numbers")
        Integer releaseYear,
        @NotBlank(message = "Genre is required")
        @Size(max = 20, message = "Genre should not exceed 20 characters")
        String genre
) {
}
