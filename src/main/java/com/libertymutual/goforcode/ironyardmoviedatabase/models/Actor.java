package com.libertymutual.goforcode.ironyardmoviedatabase.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@NamedQuery (name="findByFistNameStartingWith", query= "select u from Actor u where u.firstName = ?1")
public class Actor {
	//Instance Variables
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="actor_id_seq")
	@SequenceGenerator(name="actor_id_seq", sequenceName="actor_id_seq")
	private Long id;
	
	private String firstName;
	private String lastName;
	private Media media; // For example film, television, voice

	@ManyToMany
	@JoinTable(name="MOVIES_JOIN")
	@JsonIgnore
	private List<Movie> movies;
	
	public List<Movie> getMovies() {
		return movies;
	}
	@JsonProperty("movies")
	public List<MoviesNotSerializingActors> getMoviesNotSerializingActors() {
		List<MoviesNotSerializingActors> moviesNSA = new ArrayList<MoviesNotSerializingActors>();
		for (Movie m : movies) {
			moviesNSA.add(new MoviesNotSerializingActors(m));
		}
		return moviesNSA;		
	}
	
	@OneToMany(mappedBy="actor")
	private List<ActorAward> awards;
	public List<ActorAward> getAwards() {return awards;}

	//Constructors
	
	public Actor() {
		awards = new ArrayList<ActorAward>();
		movies = new ArrayList<Movie>();
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}
	
	public void starIn(Movie movie) {
		movies.add(movie);
	}	
}
