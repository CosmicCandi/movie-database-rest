package com.libertymutual.goforcode.ironyardmoviedatabase.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.ironyardmoviedatabase.models.ActorAward;
import com.libertymutual.goforcode.ironyardmoviedatabase.models.Award;
import com.libertymutual.goforcode.ironyardmoviedatabase.models.MovieAward;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.ActorAwardsRepository;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.ActorRepository;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.AwardRepository;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.MovieAwardsRepository;
import com.libertymutual.goforcode.ironyardmoviedatabase.services.MovieRepository;

@RestController
@RequestMapping("/awards")
public class AwardsController {
	private ActorRepository actorRepo;
	private AwardRepository awardRepo;
	private MovieRepository movieRepo;
	private ActorAwardsRepository actorAwardsRepo;
	private MovieAwardsRepository movieAwardsRepo;
	
	public AwardsController (ActorRepository actorRepo, AwardRepository awardRepo, ActorAwardsRepository actorAwardsRepo, MovieRepository movieRepo, MovieAwardsRepository movieAwardsRepo) {
		this.actorRepo = actorRepo;
		this.awardRepo = awardRepo;
		this.movieRepo = movieRepo;
		this.actorAwardsRepo = actorAwardsRepo;
		this.movieAwardsRepo = movieAwardsRepo;
	}
	
	@GetMapping("")
	public List<Award> index() {
		return awardRepo.findAll();
	}
	
	@GetMapping("/actors")
	public List<ActorAward> actorsIndex() {
		return actorAwardsRepo.findAll();
	}
	
	@PostMapping("/actors")
	public Award createActorAward (@RequestBody ActorAward actorAward) {
		actorAward.setActor(actorRepo.findOne(actorAward.getActor().getId()));
		actorAwardsRepo.save(actorAward);
		return actorAward;
	}
	
	@GetMapping("/movies")
	public List<MovieAward> moviesIndex() {
		return movieAwardsRepo.findAll();
	}
	
	@PostMapping("/movies")
	public Award createMovieAward (@RequestBody MovieAward movieAward) {
		movieAward.setMovie(movieRepo.findOne(movieAward.getMovie().getId()));
		movieAwardsRepo.save(movieAward);
		return movieAward;
	}
}
