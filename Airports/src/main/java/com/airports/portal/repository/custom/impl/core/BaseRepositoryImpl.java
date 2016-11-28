package com.airports.portal.repository.custom.impl.core;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Basic repository implementation class that should be extended 
 * by all custom implemented repositories.
 * This class should be used for accessing the MongoTemplate object, 
 * defining common attributes and methods that would be used by all custom repositories etc.
 *
 * @param <T> entity type on which the repository is based 
 * @param <ID> type of the ID (unique identifier object)
 */
public abstract class BaseRepositoryImpl<T, ID extends Serializable> {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
}
