package com.libertymutual.goforcode.ironyardmoviedatabase.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class MovieAward extends Award {
	@ManyToOne
	private Movie movie;
	
	@JsonIgnore
	public Movie getMovie() {
		return movie;
	}
	
	@JsonProperty("movie")
	public void setMovie(Movie movie) {
		this.movie = movie;		
	}

}
