package com.praj.showease.test.feed.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "cust_feedback")
public class FeedBack {
	
	private String fId;
	private String movieId;
	private String custId;
	private int fRating;
	private String fComment;
	private LocalDateTime fTimeStamp;

}
