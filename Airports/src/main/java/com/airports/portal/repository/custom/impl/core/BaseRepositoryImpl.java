package com.airports.portal.repository.custom.impl.core;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class BaseRepositoryImpl<T, ID extends Serializable> {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
}
