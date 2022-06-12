package com.neim.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.neim.app.domain.Owner;
import com.neim.app.domain.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {
	
	@Autowired
	private OwnerRepository repository;
	
	@Test
	void saveOwner() {
		repository.save(new Owner("Lucy", "Smith", "lusmith@email.com"));
		assertThat(repository.findByFirstname("Lucy").isPresent()).isTrue();
	}
	
	@Test
	void deleteOwners() {
		repository.save(new Owner("Mike", "Chandler", "mikech@email.com"));
		repository.deleteAll();
		assertThat(repository.count()).isEqualTo(0);
	}

}
