package dwsc.proyecto.moviemanager.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dwsc.proyecto.moviemanager.domain.Movie;

@Service
@FeignClient("INSERT-MOVIE")
public interface CreateMovieClient {

	@PostMapping("/movie")
	public ResponseEntity<Movie> insertMovie(@RequestBody Movie movie);
}
