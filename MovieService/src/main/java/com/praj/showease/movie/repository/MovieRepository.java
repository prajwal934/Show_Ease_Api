package com.praj.showease.movie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.praj.showease.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String>{
	
	
}
