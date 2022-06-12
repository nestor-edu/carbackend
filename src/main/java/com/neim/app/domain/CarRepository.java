package com.neim.app.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
	 
	// Custom queries
	// must start with a prefix and the class fields that are used in the query
	List<Car> findByBrand(@Param("brand") String brand);
	List<Car> findByColor(@Param("color") String color);
	
}
