package com.airports.portal.repository.core;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Basic repository which should be extended by all repositories.
 * Provides additional methods to retrieve entities using the pagination and sorting abstraction.
 *  
 * @param <T> entity type on which the repository is based 
 * @param <ID> type of the ID (unique identifier object)
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}
	