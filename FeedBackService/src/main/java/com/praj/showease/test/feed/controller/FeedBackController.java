package com.praj.showease.test.feed.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praj.showease.test.feed.dto.FeedBackDto;
import com.praj.showease.test.feed.model.FeedBack;
import com.praj.showease.test.feed.service.FeedBackService;
import com.praj.showease.test.feed.utility.ResponseStructure;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("feedBack")
@AllArgsConstructor
public class FeedBackController {

	private FeedBackService feedBackService;

	
	@PostMapping
	public ResponseEntity<ResponseStructure<FeedBack>> createFeedBack(@RequestBody FeedBackDto feedDto) {
		return feedBackService.createFeedBack(feedDto);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getAllFeedBacks() {
		return feedBackService.getAllFeedBack();
	}
	
	@GetMapping("/customers/{custId}")
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getFeedBackByCustId(@PathVariable("custId") String custId) {
		return feedBackService.getFeedBackByCustId(custId);
	}
}
