package com.praj.showease.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "movies")
public class Movie {

	@Id
	private String movieId;
	private String movieLocation;
	private String movieName;
	private String movieHallName;
	private int movieTotalSeats;
	private int movieSeatAvailables;
	private int movieBookedSeats;
	private int moviePrice;
}
