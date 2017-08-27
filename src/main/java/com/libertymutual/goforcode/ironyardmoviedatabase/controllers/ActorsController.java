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
import com.libertymutual.goforcode.ironyardmoviedatabase.models.ActorAward;
import com.libertymutual.goforcode.ironyardmoviedatabase.models.Award;
import com.libertymutual.goforcode.ironyardmoviedatabase.models.Movie;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.ActorRepository;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.AwardRepository;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.MovieRepository;
 
@RestController
@RequestMapping("/actors")
public class ActorsController {

	private ActorRepository actorRepo;
	private AwardRepository awardRepo;
	private MovieRepository movieRepo;
	
	public ActorsController (ActorRepository actorRepo, AwardRepository awardRepo, MovieRepository movieRepo) {
		this.actorRepo = actorRepo;
		this.awardRepo = awardRepo;
		this.movieRepo = movieRepo;
	}
	
	@GetMapping ("") 
	public List<Actor> index() {
		return actorRepo.findAll();
	}
	
	@PostMapping ("")
	public Actor createActor (@RequestBody Actor actor) {
		actorRepo.save(actor);
		return actor;
	}
	
	@GetMapping("{actorId}")
	public Actor getActorById(@PathVariable Long actorId) {
		Actor actor = actorRepo.findOne(actorId);	
		return actor;
	}
	
	@PutMapping("{actorId}/movies/{movieId}")
	public Actor addMovieToActor(@PathVariable Long actorId, @PathVariable Long movieId) {
		Actor actor = actorRepo.findOne(actorId);
		Movie movie = movieRepo.findOne(movieId);
		actor.starIn(movie);
		actorRepo.save(actor);
		return actor;
	}
	
	@PostMapping ("{actorId}/awards")
	public Award createAwardForActor(@RequestBody ActorAward actorAward, @PathVariable Long actorId) {
		 Actor actor = actorRepo.findOne(actorId);
		 actorAward.setActor(actor);
		 awardRepo.save(actorAward);
		 return actorAward;
	}
	
//	@PostMapping ("{actorId}/movies")
//	public Movie createMovieForActor(@RequestBody Movie movie, @PathVariable Long actorId) {
//		Actor actor = actorRepo.findOne(actorId);
//		movie.setActors(actor);
//		movieRepo.save(movie);
//		return movie;
//	}
	
	
}
