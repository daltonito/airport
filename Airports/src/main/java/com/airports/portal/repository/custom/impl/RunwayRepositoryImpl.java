package com.airports.portal.repository.custom.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.airports.portal.model.Airport;
import com.airports.portal.model.Runway;
import com.airports.portal.repository.custom.RunwayRepositoryCustom;
import com.airports.portal.repository.custom.impl.core.BaseRepositoryImpl;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Repository
public class RunwayRepositoryImpl extends BaseRepositoryImpl<Airport, String> implements RunwayRepositoryCustom {

	/* (non-Javadoc)
	 * @see com.airports.portal.repository.custom.RunwayRepositoryCustom#getDistinctRunwayTypes(java.util.List)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getDistinctRunwayTypes(List<String> airportIdents) {
		
		Query query = new Query(where("airport_ident").in(airportIdents));
		return getMongoTemplate().getCollection("runways").distinct("surface", query.getQueryObject());
	}

	/* (non-Javadoc)
	 * @see com.airports.portal.repository.custom.RunwayRepositoryCustom#getMostCommonRunwayIdents(java.lang.Integer)
	 */
	@Override
	public Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords) {
		
		Aggregation agg = newAggregation(
				group("leIdent").count().as("total"),
				project("total").and("leIdent").previousOperation(),
				sort(Sort.Direction.DESC, "total"),
				limit(numberOfRecords));
			
			DBObject result	= getMongoTemplate().aggregate(agg, Runway.class, DBObject.class).getRawResults();
			
			Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
			BasicDBList dbList = (BasicDBList) result.get("result");
			
			for (BasicDBObject dbObject : dbList.toArray(new BasicDBObject[dbList.size()])) {
				resultMap.put(dbObject.getString("leIdent"), Integer.valueOf(dbObject.getString("total")));
			}
			
			return resultMap;
	}
	
}
