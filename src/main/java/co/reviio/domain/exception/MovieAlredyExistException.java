package co.reviio.domain.exception;

public class MovieAlredyExistException extends RuntimeException {
    public MovieAlredyExistException(String movieTitle) {
        super("Movie already exists with title: " + movieTitle);
    }
}
