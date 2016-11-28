package com.airports.portal.model.core;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Basic document class that should be extended by all documents.
 * This class should be used for defining common attributes and methods
 * that would be used by all documents.
 */
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
