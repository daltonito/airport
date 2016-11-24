package com.airports.portal.repository.custom.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.airports.portal.model.Runway;
import com.airports.portal.repository.custom.RunwayRepositoryCustom;
import com.mongodb.DBObject;

@Repository
public class RunwayRepositoryImpl implements RunwayRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getDistinctRunwayTypes(List<String> airportIdents) {
		
		Query query = new Query(where("airport_ident").in(airportIdents));
		return mongoTemplate.getCollection("runways").distinct("surface", query.getQueryObject());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getMostCommonRunwayIdents(Integer numberOfRecords) {
		
		Aggregation agg = newAggregation(
				group("leIdent").count().as("total"),
				project("total").and("leIdent").previousOperation(),
				sort(Sort.Direction.DESC, "total"),
				limit(numberOfRecords));
			
			DBObject result	= mongoTemplate.aggregate(agg, Runway.class, DBObject.class).getRawResults();
			
			return new ArrayList<String>(((Map<String, Integer>) result.toMap()).keySet());
	}
	
}
