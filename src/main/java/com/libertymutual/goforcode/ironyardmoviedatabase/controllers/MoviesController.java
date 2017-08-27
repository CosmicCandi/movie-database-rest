package com.libertymutual.goforcode.ironyardmoviedatabase.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.ironyardmoviedatabase.models.Actor;
import com.libertymutual.goforcode.ironyardmoviedatabase.models.Movie;
import com.libertymutual.goforcode.ironyardmoviedatabase.models.MovieAward;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.ActorRepository;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.AwardRepository;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	private ActorRepository actorRepo;
	private AwardRepository awardRepo;
	private MovieRepository movieRepo;
	
	public MoviesController (ActorRepository actorRepo, AwardRepository awardRepo, MovieRepository movieRepo) {
		this.actorRepo = actorRepo;
		this.awardRepo = awardRepo;
		this.movieRepo = movieRepo;
	}
	
	@GetMapping("")
	public List<Movie> index() {
		return movieRepo.findAll();
	}
	
	@PostMapping ("{movieId}/awards")
	public MovieAward createAwardForMovie(@RequestBody MovieAward movieAward, @PathVariable Long movieId) {
		Movie movie = movieRepo.findOne(movieId);
		movieAward.setMovie(movie);
		awardRepo.save(movieAward);
		return movieAward;
	}
	
	@PostMapping ("")
	public Movie createMovie (@RequestBody Movie movie) {
		movieRepo.save(movie);
		return movie;
		
	}
	
	@PutMapping ("{movieId}/actors/{actorId}")
	public Movie addActorToMovie (@PathVariable Long movieId, @PathVariable Long actorId) {
		Movie movie = movieRepo.findOne(movieId);
		Actor actor = actorRepo.findOne(actorId);
		actor.starIn(movie);
		actorRepo.save(actor);
		
		return movie;
	}
}
