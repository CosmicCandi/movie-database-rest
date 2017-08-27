package com.libertymutual.goforcode.ironyardmoviedatabase.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MovieAward extends Award {
	@ManyToOne
	@JsonIgnore
	private Movie movie;
	
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;		
	}

}
