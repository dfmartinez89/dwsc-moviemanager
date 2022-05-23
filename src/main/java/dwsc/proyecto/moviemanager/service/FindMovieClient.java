package dwsc.proyecto.moviemanager.service;

import java.util.List;

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
	public ResponseEntity <Movie> getMoviesById(@PathVariable String id);

	@GetMapping("movies/title")
	public ResponseEntity<List<Movie>> getMoviesByTitle(@RequestParam String title);

	@GetMapping("movies/year")
	public ResponseEntity<List<Movie>> getMoviesByYear(@RequestParam Integer year);

	@GetMapping("movies/score")
	public ResponseEntity<List<Movie>> getMoviesByScore(@RequestParam double score);
}
