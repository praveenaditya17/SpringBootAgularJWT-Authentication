package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.CatalogueDesign;

public interface CatalogueRepository extends CrudRepository<CatalogueDesign,Integer> {
	
	@Query(value="Select * from catalogue_design where product_type= ?1",nativeQuery = true)
    Iterable<CatalogueDesign> findByProductType(String product_type);

}
