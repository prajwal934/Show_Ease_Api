package com.praj.showease.test.feed.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.praj.showease.test.feed.dto.FeedBackDto;
import com.praj.showease.test.feed.model.FeedBack;
import com.praj.showease.test.feed.utility.ResponseStructure;

public interface FeedBackService {

	public ResponseEntity<ResponseStructure<FeedBack>> createFeedBack(FeedBackDto feedDto);
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getAllFeedBack();
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getFeedBackByCustId(String custId);
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getFeedBackByMovieId(String movieId);
	
}
