package dwsc.proyecto.moviemanager.domain;

import java.util.Date;

public class Comment {
	private String id;
	private String author;
	private String text;
	private double score;
	private Date createdAt;
	private Movie movie;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getAverageScore() {
		return score;
	}

	public void setAverageScore(int averageScore) {
		this.score = averageScore;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public double getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
