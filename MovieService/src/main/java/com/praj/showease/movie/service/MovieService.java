package com.praj.showease.movie.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.praj.showease.movie.dto.MovieDto;
import com.praj.showease.movie.model.Movie;
import com.praj.showease.movie.utility.ResponseStructure;

public interface MovieService {

	public ResponseEntity<ResponseStructure<Movie>> createMovie(MovieDto movieDto);
	public ResponseEntity<ResponseStructure<List<Movie>>> getAllMovies();
	public ResponseEntity<ResponseStructure<Movie>> findByMovieId(String movieId);
}
