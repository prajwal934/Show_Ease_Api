package com.praj.showease.test.feed.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.praj.showease.test.feed.model.FeedBack;

public interface FeedBackRepository extends MongoRepository<FeedBack, String> {

}
