package dwsc.proyecto.moviemanager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dwsc.proyecto.moviemanager.domain.Comment;
import dwsc.proyecto.moviemanager.domain.Movie;
import dwsc.proyecto.moviemanager.service.CreateMovieClient;
import dwsc.proyecto.moviemanager.service.FindMovieClient;
import dwsc.proyecto.moviemanager.service.MovieCommentClient;

@Controller
@RequestMapping(value = "/movies")
public class MovieManagerController {

	/*
	 * 1.Crear pelicula: -mostrar listado pelis * -crear peli * -actualizar listado
	 * pelis *
	 * 
	 * 2.Borrar comentario: -mostrar listado pelis * -seleccionar peli * -detalle *
	 * -listado comentarios de la peli * -borrar * -actualizar listado comentarios
	 * (vuelvo a llamar al listado) *
	 */

	@Autowired
	CreateMovieClient createMovie;

	@Autowired
	FindMovieClient findMovie;

	@Autowired
	MovieCommentClient commentMovie;

	@GetMapping
	public String getMovies(Map<String, List<Movie>> model,
			@PathVariable(value = "title", required = false) String title) throws Exception {
		if (title != null) {
			try {
				ResponseEntity<List<Movie>> movies = findMovie.getMoviesByTitle(title);
				model.put("movies", movies.getBody());
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		try {
			ResponseEntity<List<Movie>> movies = findMovie.getAllMovies();
			model.put("movies", movies.getBody());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return "index";
	}

	@GetMapping("/movie/{id}")
	public String getMovieDetails(Model model, @PathVariable String id) throws Exception {
		try {
			ResponseEntity<Movie> movieRes = findMovie.getMoviesById(id);
			Movie movie = movieRes.getBody();
			model.addAttribute("movie", movie);
			ResponseEntity<Iterable<Comment>> commentRes = commentMovie.getCommentsByMovieId(id);
			Iterable<Comment> comments = commentRes.getBody();
			model.addAttribute("comments", comments);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return "movie";
	}

	@GetMapping("/comments/{id}")
	public String deleteComment(Model model, @PathVariable String id) throws Exception {
		try {
			commentMovie.deleteComment(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "redirect:/movies";
	}

	@GetMapping("/new-movie")
	public String createMovieForm(Model model) {
		model.addAttribute("movie", new Movie());
		return "newMovie";
	}

	@PostMapping("/new-movie")
	public String createMovieSubmit(@ModelAttribute Movie movie) throws Exception {
		try {
			ResponseEntity<Movie> response = createMovie.insertMovie(movie);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "redirect:/movies";
	}

}
