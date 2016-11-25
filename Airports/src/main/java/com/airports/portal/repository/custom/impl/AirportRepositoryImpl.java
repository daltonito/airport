package com.airports.portal.repository.custom.impl;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.airports.portal.model.Airport;
import com.airports.portal.repository.custom.AirportRepositoryCustom;
import com.airports.portal.repository.custom.impl.core.BaseRepositoryImpl;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Repository
public class AirportRepositoryImpl extends BaseRepositoryImpl<Airport, String> implements AirportRepositoryCustom {

	@Override
	public Map<String, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder) {
		
		Aggregation agg = newAggregation(
			group("isoCountry").count().as("total"),
			project("total").and("isoCountry").previousOperation(),
			sort(descendingOrder ? DESC : ASC, "total"),
			limit(numberOfRecords));
		
		DBObject result	= getMongoTemplate().aggregate(agg, Airport.class, DBObject.class).getRawResults();
		
		Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
		BasicDBList dbList = (BasicDBList) result.get("result");
		
		for (BasicDBObject dbObject : dbList.toArray(new BasicDBObject[dbList.size()])) {
			resultMap.put(dbObject.getString("isoCountry"), Integer.valueOf(dbObject.getString("total")));
		}
		
		return resultMap;
	}

	@Override
	public List<String> getAirportIdentsByCountry(String countryCode) {
		
		Query query = new Query(where("isoCountry").is(countryCode));
		query.fields().include("ident");
		
		List<Airport> airports = getMongoTemplate().find(query, Airport.class);
		List<String> results = new ArrayList<String>();
		
		for (Airport airport : airports) {
			results.add(airport.getIdent());
		}
		
		return results;
	}
	
}
