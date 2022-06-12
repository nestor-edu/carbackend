package com.neim.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neim.app.domain.Car;
import com.neim.app.domain.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	CarRepository cRepository;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return cRepository.findAll();
	}

}
