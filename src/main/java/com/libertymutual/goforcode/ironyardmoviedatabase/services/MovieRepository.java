package com.libertymutual.goforcode.ironyardmoviedatabase.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libertymutual.goforcode.ironyardmoviedatabase.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
