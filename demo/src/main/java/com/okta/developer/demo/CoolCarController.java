package com.okta.developer.demo;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoolCarController {
	private CarRepository repository;
	
	public CoolCarController(CarRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/cool-cars")
	public Collection<Car> coolCars(){
		return repository.findAll().stream()
				.filter(this::isCool)
				.collect(Collectors.toList());
	}
	
	private boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
	}
}
