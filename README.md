# Movie Watchlist API

A simple Spring Boot REST API for managing a personal movie watchlist. Built as a one-day practice project to get comfortable with Spring Boot.

The project uses one Movie entity, DTOs, request validation, exception handling, and filtering by genre and watched status.

## Technologies

- Java 17 or newer
- Spring Boot
- Spring Data JPA
- Jakarta Validation
- PostgreSQL
- Maven
- Springdoc OpenAPI / Swagger UI

## Run locally

1. Copy `.env.example` to `.env`. The example values match the PostgreSQL service in `compose.yaml`.
2. Start PostgreSQL: `docker compose up -d`.
3. Run the application: `./mvnw spring-boot:run` (Windows: `.\mvnw.cmd spring-boot:run`).
4. The API is available at `http://localhost:8080/api/movies`.

The application connects to PostgreSQL on port `5433`. `POSTGRES_URL` is the database name. The local `.env` file is ignored by Git.

## Endpoints

| Method | Path | Purpose |
| --- | --- | --- |
| POST | `/api/movies` | Create an unwatched movie |
| GET | `/api/movies` | Get all movies |
| GET | `/api/movies/{id}` | Get a movie by ID |
| PUT | `/api/movies/{id}` | Update a movie |
| DELETE | `/api/movies/{id}` | Delete a movie |
| GET | `/api/movies/watched` | Get watched movies |
| GET | `/api/movies/genre/{genre}` | Filter movies by genre, ignoring case |

## Example creation request

```json
{
  "title": "Interstellar",
  "director": "Christopher Nolan",
  "releaseYear": 2014,
  "genre": "Sci-Fi"
}
```

Movies are created as unwatched, with an initial rating of `0`. Watched status and rating are supplied through the update endpoint. Updates reject a non-null rating when `watched` is false. Movie IDs are omitted from response bodies, but the ID-based endpoints still accept IDs in the URL. Missing movies return `404 Not Found`.

## Project structure

Application code lives in `src/main/java/org/example/moviewatchlist`, with separate `controller`, `service`, `repository`, `model`, `dto`, and `exception` packages.

## Commit history

The existing project was organized into a setup commit and separate endpoint commits before its first push. These commits group completed work rather than recreate its original development timeline.
