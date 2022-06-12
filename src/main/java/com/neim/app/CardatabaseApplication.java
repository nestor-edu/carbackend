package com.neim.app;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neim.app.domain.Car;
import com.neim.app.domain.CarRepository;
import com.neim.app.domain.Owner;
import com.neim.app.domain.OwnerRepository;
import com.neim.app.domain.User;
import com.neim.app.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository oRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner("Sebastian", "Vettel", "vettel@astonmartin.com");
		Owner owner2 = new Owner("Kevin", "Magnussen", "kevmag@hass.com");
		
		oRepository.saveAll(Arrays.asList(owner1, owner2));
		
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 28000, owner2));
		repository.save(new Car("Jeep", "Patriot", "Black", "KKO-0212", 2017, 19000, owner1));
		
		for (Car car : repository.findAll()) {
			LOGGER.info(car.getBrand() + " " + car.getModel());
		}
		
		uRepository.save(new User("user", "$2a$10$i2W3kbU948ev1po6wdyT1e8h600vv6hZyUUUNUo3mlliaaxIiJfeS", "USER"));
		
		uRepository.save(new User("admin", "$2a$10$i.IsPbg9Q2ERGqCCSioxpOSAzYAj93fd4wQbx8PsoMvCm6ppTJARG", "ADMIN"));
		
	}

}
