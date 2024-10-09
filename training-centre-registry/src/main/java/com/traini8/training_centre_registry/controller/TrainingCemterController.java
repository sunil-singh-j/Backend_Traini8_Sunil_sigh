package com.traini8.training_centre_registry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traini8.training_centre_registry.dto.TrainingCenter;
import com.traini8.training_centre_registry.service.TrainingCenterService;
import java.util.List;
import jakarta.validation.Valid;

@RestController
public class TrainingCemterController {
	@Autowired
	private TrainingCenterService trainingCenterService;
	@PostMapping("/save")
	public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
		TrainingCenter savedCenter=trainingCenterService.saveTrainingCenter(trainingCenter);
		return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
	}
	@GetMapping("/training-centers")
	public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(@RequestParam(required = false) String city,@RequestParam(required = false) String state) {

        List<TrainingCenter> trainingCenters = trainingCenterService.getAllTrainingCenters(city, state);
        if (trainingCenters.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trainingCenters);
    }
	
}
