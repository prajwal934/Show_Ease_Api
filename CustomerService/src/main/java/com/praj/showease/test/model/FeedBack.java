package com.praj.showease.test.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FeedBack {
	
	private String fId;
	private String movieId;
	private String custId;
	private int fRating;
	private String fComment;
	private LocalDateTime fTimeStamp;

}
