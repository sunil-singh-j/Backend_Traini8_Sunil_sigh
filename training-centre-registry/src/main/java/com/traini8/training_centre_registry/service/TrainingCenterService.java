package com.traini8.training_centre_registry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traini8.training_centre_registry.dto.TrainingCenter;
import com.traini8.training_centre_registry.repository.TrainingCenterRepository;

@Service
public class TrainingCenterService {
	@Autowired
	private TrainingCenterRepository trainingCenterRepository;
	 // POST API to create a new Training Center
	public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {
		return trainingCenterRepository.save(trainingCenter);
	}
	
	 // Retrieve all training centers or filter by city/state
    public List<TrainingCenter> getAllTrainingCenters(String city, String state) {
        if (city != null && state != null) {
            return trainingCenterRepository.findByAddress_CityAndAddress_State(city, state);
        } else if (city != null) {
            return trainingCenterRepository.findByAddress_City(city);
        } else if (state != null) {
            return trainingCenterRepository.findByAddress_State(state);
        } else {
            return trainingCenterRepository.findAll();
        }
    }
    
    
	

}
