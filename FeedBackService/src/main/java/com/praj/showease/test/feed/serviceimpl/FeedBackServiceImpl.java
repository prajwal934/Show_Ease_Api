package com.praj.showease.test.feed.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.praj.showease.test.feed.dto.FeedBackDto;
import com.praj.showease.test.feed.exceptions.FeedBackNotFoundException;
import com.praj.showease.test.feed.model.FeedBack;
import com.praj.showease.test.feed.repository.FeedBackRepository;
import com.praj.showease.test.feed.service.FeedBackService;
import com.praj.showease.test.feed.utility.ResponseStructure;

@Service
public class FeedBackServiceImpl implements FeedBackService{
	
	private FeedBackRepository feedBackRepository;
	private ResponseStructure<FeedBack> responseStructure;
	private ResponseStructure<List<FeedBack>> rs;
	

	public FeedBackServiceImpl(FeedBackRepository feedBackRepository, ResponseStructure<FeedBack> responseStructure,
			ResponseStructure<List<FeedBack>> rs) {
		super();
		this.feedBackRepository = feedBackRepository;
		this.responseStructure = responseStructure;
		this.rs = rs;
	}

	@Override
	public ResponseEntity<ResponseStructure<FeedBack>> createFeedBack(FeedBackDto feedDto) {
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("FeedBack Created Successfully!")
				.setData(feedBackRepository.save(mapToFeedBack(feedDto))));
	}
	
	private FeedBack mapToFeedBack(FeedBackDto feedDto) {
		String randomFeedBackId = UUID.randomUUID().toString(); 
		return FeedBack.builder()
					.fRating(feedDto.getFRating())
					.custId(feedDto.getCustId())
					.movieId(feedDto.getMovieId())
					.fComment(feedDto.getFComment())
					.fTimeStamp(feedDto.getFTimeStamp())
					.fId(randomFeedBackId).build();
	}


	@Override
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getAllFeedBack() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("FeedBack Data Fetched Successfully!")
				.setData(feedBackRepository.findAll()));
	}

	/* Here i get the data of the feedback by the help of Customer Id */
	@Override
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getFeedBackByCustId(String custId) {
		// TODO Auto-generated method stub
		return feedBackRepository.findByCustId(custId).map(feedback -> ResponseEntity.ok(
				rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("FeedBack By Customers have been founded Successfully!")
				.setData(feedback)))
				.orElseThrow(() -> new FeedBackNotFoundException("Sorry, It's not found!!!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getFeedBackByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
