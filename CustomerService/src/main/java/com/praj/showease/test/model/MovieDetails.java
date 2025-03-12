package com.praj.showease.test.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MovieDetails {

	private Long MD_id;
    private String MD_title;
    private String MD_description;
    private Date MD_releaseDate;
    private String MD_genre;
    private String MD_director;
    private List<String> MD_cast;
    private Double MD_rating;
    private Integer MD_duration;
}
