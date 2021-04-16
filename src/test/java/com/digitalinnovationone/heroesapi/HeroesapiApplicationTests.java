package com.digitalinnovationone.heroesapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.digitalinnovation.livecoding.document.Heroes;
import com.digitalinnovationone.livecoding.repository.HeroesRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import javax.swing.*;
import java.util.List;

import static com.digitalinnovationone.livecoding.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesapiApplicationTests {


	@Autowired
	WebTestClient webTestClient;

	@Test
	public void getOneHeroById() {

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id"), "3")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneHeronotFound() {

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id"), "1")
				.exchange()
				.expectStatus().isNotFound();

	}

	@Test
	public void deleteHero() {
		web.TestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "10")
				.accept(MediaType.APPLICATION_JSONI)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}

	@Test
	void contextLoads() {
	}

}
