package com.libertymutual.goforcode.ironyardmoviedatabase.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libertymutual.goforcode.ironyardmoviedatabase.models.ActorAward;

@Repository
public interface ActorAwardsRepository extends JpaRepository<ActorAward, Long> {

}
