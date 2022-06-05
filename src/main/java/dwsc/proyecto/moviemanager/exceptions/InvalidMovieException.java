package dwsc.proyecto.moviemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidMovieException extends ResponseStatusException{
	private static final long serialVersionUID = 1L;

	public InvalidMovieException(HttpStatus code, String message) {
		super(code, message);
	}
}
