package com.praj.showease.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MovieDto {

	private String movieId;
	private String movieLocation;
	private String movieName;
	private String movieHallName;
	private int movieTotalSeats;
	private int movieSeatAvailables;
	private int movieBookedSeats;
	private int moviePrice;
}
