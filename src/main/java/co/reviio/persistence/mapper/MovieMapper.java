package co.reviio.persistence.mapper;

import co.reviio.domain.dto.MovieDto;
import co.reviio.domain.dto.UpdateMovieDto;
import co.reviio.persistence.entity.MovieEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, StateMapper.class})
public interface MovieMapper {

    @Mappings({
            @Mapping(source = "titulo", target = "title"),
            @Mapping(source = "duracion", target = "duration"),
            @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre"),
            @Mapping(source = "fechaEstreno", target = "releaseDate"),
            @Mapping(source = "clasificacion", target = "rating"),
            @Mapping(source = "estado", target = "state", qualifiedByName = "stateStringToBoolean")
    })
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "genre", target = "genero", qualifiedByName = "genreToString"),
            @Mapping(target = "estado", ignore = true)
    })
    MovieEntity toEntity(MovieDto dto);

    @Mapping(target = "titulo", source = "title")
    @Mapping(target = "fechaEstreno", source = "releaseDate")
    @Mapping(target = "clasificacion", source = "rating")
    void updateEntityFromDto(UpdateMovieDto updateMovieDto, @MappingTarget MovieEntity movieEntity);

}
