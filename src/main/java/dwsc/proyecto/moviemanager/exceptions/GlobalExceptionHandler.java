package dwsc.proyecto.moviemanager.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidMovieException.class)
	public ResponseEntity<CustomResponse> invalidMovie(RuntimeException ex) {
		CustomResponse resp = new CustomResponse();
		resp.setTimestamp(LocalDateTime.now());
		resp.setError(ex.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}

}
