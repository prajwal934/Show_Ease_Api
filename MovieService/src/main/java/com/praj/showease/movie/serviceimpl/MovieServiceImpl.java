package com.praj.showease.movie.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.praj.showease.movie.dto.MovieDto;
import com.praj.showease.movie.exceptions.MovieNotFoundByIdException;
import com.praj.showease.movie.model.Movie;
import com.praj.showease.movie.repository.MovieRepository;
import com.praj.showease.movie.service.MovieService;
import com.praj.showease.movie.utility.ResponseStructure;


@Service
public class MovieServiceImpl implements MovieService{
	
	private MovieRepository movieRepository;
	private ResponseStructure<Movie> responseStructure;
	private ResponseStructure<List<Movie>> rs;
	
	

	public MovieServiceImpl(MovieRepository movieRepository, ResponseStructure<Movie> responseStructure,
			ResponseStructure<List<Movie>> rs) {
		super();
		this.movieRepository = movieRepository;
		this.responseStructure = responseStructure;
		this.rs = rs;
	}

	@Override
	public ResponseEntity<ResponseStructure<Movie>> createMovie(MovieDto movieDto) {
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Movie Created Successfully!!")
				.setData(movieRepository.save(mapToMovie(movieDto))));
	}
	
	private Movie mapToMovie(MovieDto movieDto) {
		String randomMovieId = UUID.randomUUID().toString();
		return Movie.builder()
				.movieName(movieDto.getMovieName())
				.movieLocation(movieDto.getMovieLocation())
				.movieBookedSeats(movieDto.getMovieBookedSeats())
				.movieHallName(movieDto.getMovieHallName())
				.movieSeatAvailables(movieDto.getMovieSeatAvailables())
				.movieTotalSeats(movieDto.getMovieTotalSeats())
				.moviePrice(movieDto.getMoviePrice())
				.movieId(randomMovieId).build();
	}

	

	
	@Override
	public ResponseEntity<ResponseStructure<List<Movie>>> getAllMovies() {
		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("Movie Data fetched Successfully!!")
				.setData(movieRepository.findAll()));
	}

	@Override
	public ResponseEntity<ResponseStructure<Movie>> findByMovieId(String movieId) {
		return movieRepository.findById(movieId).map(movie -> ResponseEntity.ok(
				responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Movie have been founded Successfully!!").setData(movie)))
				.orElseThrow(() -> new MovieNotFoundByIdException("Sorry, Movie is not avilable"));
	}

}
