package com.praj.showease.test.dto;

import java.util.ArrayList;
import java.util.List;

import com.praj.showease.test.model.FeedBack;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDto {

	
	private String custId;
	
	private String custName;
	
	private String custEmail;
	
	private String custPh;
	
	private String custAddress;
	
	@Transient  //
	private List<FeedBack> feedBacks = new ArrayList<>();
}
