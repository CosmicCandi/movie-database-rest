package com.libertymutual.goforcode.ironyardmoviedatabase.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.ironyardmoviedatabase.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
	
	List<Actor> findByFirstNameStartingWith (String firstName);
	
}
