package com.libertymutual.goforcode.ironyardmoviedatabase.models;


public class MoviesNotSerializingActors {
	private Movie movie;
	
	public MoviesNotSerializingActors (Movie movie) {
		this.movie = movie;
	}

	public long getId() {
		return movie.getId();
	}
	
	public String getTitle() {
		return movie.getTitle();
	}
	
	public String getDirector() {
		return movie.getDirector();
	}
	
	public Genre getGenre() {
		return movie.getGenre();
	}
	
	public int getBoxOfficeEarnings() {
		return movie.getBoxOfficeEarnings();
	}
	
	public int getYear() {
		return movie.getYear();
	}
	
}
