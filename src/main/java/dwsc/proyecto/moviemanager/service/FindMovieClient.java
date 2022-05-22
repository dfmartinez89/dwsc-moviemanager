package dwsc.proyecto.moviemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dwsc.proyecto.moviemanager.domain.Movie;

@Service
@FeignClient("FIND-MOVIE")
public interface FindMovieClient {

	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAllMovies();

	@GetMapping("movies/{id}")
	public ResponseEntity<Optional<Movie>> getMoviesById(@PathVariable String id);

	@GetMapping("movies/title")
	public ResponseEntity<Iterable<Movie>> getMoviesByTitle(@RequestParam String title);

	@GetMapping("movies/year")
	public ResponseEntity<Iterable<Movie>> getMoviesByYear(@RequestParam Integer year);

	@GetMapping("movies/score")
	public ResponseEntity<Iterable<Movie>> getMoviesByScore(@RequestParam double score);
}
