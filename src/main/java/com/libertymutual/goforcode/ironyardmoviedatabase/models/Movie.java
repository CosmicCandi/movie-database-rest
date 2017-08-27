package com.libertymutual.goforcode.ironyardmoviedatabase.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movie_id_seq")
	@SequenceGenerator(name="movie_id_seq", sequenceName="movie_id_seq")
	private long id;
	
	private String title;
	private String director;
	private Genre genre;
	private int boxOfficeEarnings;
	
	@ManyToMany(mappedBy="movies")
	private List<Actor> actors;
	public List<Actor> getActors() {return actors;}
	
	@OneToMany(mappedBy="movie")
	List<MovieAward> awards;
	public List<MovieAward> getAwards() {return awards;}
	
	
	private int year;
	
	public Movie() {
		actors = new ArrayList<Actor>();
		awards = new ArrayList<MovieAward>();
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getBoxOfficeEarnings() {
		return boxOfficeEarnings;
	}

	public void setBoxOfficeEarnings(int boxOfficeEarnings) {
		this.boxOfficeEarnings = boxOfficeEarnings;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
}
