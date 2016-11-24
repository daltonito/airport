package com.airports.portal.model.core;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public abstract class BaseDocument {

	private ObjectId _id;
	
	@Id
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
}
