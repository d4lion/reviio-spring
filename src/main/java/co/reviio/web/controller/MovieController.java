package co.reviio.web.controller;

import co.reviio.domain.dto.MovieDto;
import co.reviio.domain.dto.SuggestRequestDto;
import co.reviio.domain.dto.UpdateMovieDto;
import co.reviio.domain.service.MovieService;
import co.reviio.domain.service.ReviioAiService;
import co.reviio.persistence.crud.CrudMovieEntity;
import co.reviio.persistence.entity.MovieEntity;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final ReviioAiService reviioAiService;

    public MovieController(MovieService movieService, ReviioAiService reviioAiService) {
        this.movieService = movieService;
        this.reviioAiService = reviioAiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id) {
        MovieDto movie = this.movieService.getById(id);

        if (movie == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generatedMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.reviioAiService.generateMoviesSuggestions(suggestRequestDto.userPreferences()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id,@RequestBody @Valid UpdateMovieDto UpdateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, UpdateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        this.movieService.delete(id);
        return ResponseEntity.ok("The movie was successfully deleted.");
    }

}
