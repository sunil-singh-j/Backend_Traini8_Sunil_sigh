package com.traini8.training_centre_registry.repository;

import com.traini8.training_centre_registry.dto.TrainingCenter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
	
	 List<TrainingCenter> findByAddress_City(String city);

	    List<TrainingCenter> findByAddress_State(String state);

	    List<TrainingCenter> findByAddress_CityAndAddress_State(String city, String state);
}
