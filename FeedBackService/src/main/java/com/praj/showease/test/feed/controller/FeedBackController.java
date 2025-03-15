package com.praj.showease.test.feed.controller;

import org.springframework.http.ResponseEntity;
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
}
