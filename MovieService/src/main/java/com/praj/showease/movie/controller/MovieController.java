package com.praj.showease.movie.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praj.showease.movie.dto.MovieDto;
import com.praj.showease.movie.model.Movie;
import com.praj.showease.movie.service.MovieService;
import com.praj.showease.movie.utility.ResponseStructure;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {

	private MovieService movieService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Movie>> createMovie(@RequestBody MovieDto movieDto) {
		return movieService.createMovie(movieDto);
	}
	
	
	@GetMapping("/{movieId}")
	public ResponseEntity<ResponseStructure<Movie>> findByMovieId(@PathVariable("movieId") String movieId) {
		return movieService.findByMovieId(movieId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Movie>>> getAllMovies() {
		return movieService.getAllMovies();
	}
}
