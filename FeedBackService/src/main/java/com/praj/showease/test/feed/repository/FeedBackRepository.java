package com.praj.showease.test.feed.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.praj.showease.test.feed.model.FeedBack;

public interface FeedBackRepository extends MongoRepository<FeedBack, String> {

	/*
	 * Here, I'm create the custom finder method
	 */
	
	Optional<List<FeedBack>> findByCustId(String custId);
	Optional<List<FeedBack>> findByMovieId(String movieId);
}
