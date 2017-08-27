package com.libertymutual.goforcode.ironyardmoviedatabase.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.ironyardmoviedatabase.models.Award;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {
	
}
