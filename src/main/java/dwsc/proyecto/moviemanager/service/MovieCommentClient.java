package dwsc.proyecto.moviemanager.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dwsc.proyecto.moviemanager.domain.Comment;

@Service
@FeignClient("DELETE-COMMENT")
public interface MovieCommentClient {

	@GetMapping("/comment/{movieId}")
	public ResponseEntity<Iterable<Comment>> getCommentsByMovieId(@PathVariable String movieId);

	@DeleteMapping("/comment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable String id);
}
