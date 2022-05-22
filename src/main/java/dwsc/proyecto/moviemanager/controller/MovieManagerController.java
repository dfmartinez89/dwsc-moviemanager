package dwsc.proyecto.moviemanager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dwsc.proyecto.moviemanager.domain.Movie;
import dwsc.proyecto.moviemanager.service.CreateMovieClient;
import dwsc.proyecto.moviemanager.service.FindMovieClient;
import dwsc.proyecto.moviemanager.service.MovieCommentClient;

@Controller
@RequestMapping(value = "/movies")
public class MovieManagerController {

	/*
	 * 1.Crear pelicula:
	 * -mostrar listado pelis *
	 * -crear peli *
	 * -actualizar listado pelis *
	 * 
	 * 2.Borrar comentario:
	 * -mostrar listado pelis *
	 * -seleccionar peli *
	 * -detalle *
	 * -listado comentarios de la peli  *
	 * -borrar *
	 * -actualizar listado comentarios (vuelvo a llamar al listado) *
	 */
	
	@Autowired
	CreateMovieClient createMovie;
	
	@Autowired
	FindMovieClient findMovie;
	
	@Autowired
	MovieCommentClient commentMovie;
	
	@GetMapping
	public String getMovies(Map<String, List<Movie>> model) throws Exception{
		try {
			ResponseEntity<List <Movie>> movies = findMovie.getAllMovies();
			model.put("movies", movies.getBody());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "index";
	}
	
}
