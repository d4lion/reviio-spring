package co.reviio.domain.service;

import co.reviio.domain.dto.MovieDto;
import co.reviio.domain.dto.UpdateMovieDto;
import co.reviio.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las peliculas que existan dentro de la plataforma")
    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto dto) {
        return this.movieRepository.save(dto);
    }

    public MovieDto update(long id, UpdateMovieDto dto) {
        return this.movieRepository.update(id, dto);
    }

    public void delete(long id) {
        this.movieRepository.delete(id);
    }
}
