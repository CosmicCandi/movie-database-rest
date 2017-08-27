package com.libertymutual.goforcode.ironyardmoviedatabase.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libertymutual.goforcode.ironyardmoviedatabase.models.Award;
import com.libertymutual.goforcode.ironyardmoviedatabase.models.MovieAward;
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
	private MovieAwardsRepository movieAwardsRepo;
	
	public AwardsController (ActorRepository actorRepo, AwardRepository awardRepo, MovieRepository movieRepo, MovieAwardsRepository movieAwardsRepo) {
		this.actorRepo = actorRepo;
		this.awardRepo = awardRepo;
		this.movieRepo = movieRepo;
		this.movieAwardsRepo = movieAwardsRepo;
	}
	
	@GetMapping("")
	public List<Award> index() {
		return awardRepo.findAll();
	}
	
	@GetMapping("/movies")
	public List<MovieAward> moviesIndex() {
		return movieAwardsRepo.findAll();
	}
	
	@PostMapping("/movies")
	public Award createAward (@RequestBody MovieAward movieAward) {
		movieAward.setMovie(movieRepo.findOne(movieAward.getId()));
		movieAwardsRepo.save(movieAward);
		return movieAward;
	}
}
