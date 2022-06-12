package com.neim.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neim.app.web.CarController;

@SpringBootTest
class CardatabaseApplicationTests {
	
	@Autowired
	private CarController controller;

	@Test
	@DisplayName("Check instance controller was created and injected")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
