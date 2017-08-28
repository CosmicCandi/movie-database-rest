package com.libertymutual.goforcode.ironyardmoviedatabase.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.ironyardmoviedatabase.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
	
	Actor findByFirstNameStartingWith (String firstName);
	
}
