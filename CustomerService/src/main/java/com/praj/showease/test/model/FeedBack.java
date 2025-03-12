package com.praj.showease.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FeedBack {
	
	
	private String F_id;
	private String F_movieId;
	private String F_userId;
	private String F_rating;
	private String F_comment;
	private String F_timeStamp;

}
