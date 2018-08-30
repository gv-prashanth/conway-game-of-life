package com.vadrin.conwaygameoflife.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.vadrin.conwaygameoflife.services.World;

@RestController
public class GameOfLifeController {

	private Map<String, World> activeWorlds;
	private static final Logger log = LoggerFactory.getLogger(GameOfLifeController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/world")
	public ResponseEntity<Object> createAWorld(@RequestBody JsonNode worldInfo) {
		try {
			String id = UUID.randomUUID().toString();
			World thisWorld = new World(100, 100);
			// thisWorld.populate();
			log.info("Constructed new world {}", id);
			activeWorlds.put(id, thisWorld);
			return ResponseEntity.created(new URI("/world/" + id)).build();
		} catch (NullPointerException | URISyntaxException e) {
			Map<String, String> toReturn = new HashMap<String, String>();
			toReturn.put("Exception", "Invalid Input. Please see sample at XXXXX");
			return ResponseEntity.badRequest().body(toReturn);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/world/{id}")
	public ResponseEntity<Object> getWorld(@PathParam(value = "id") String id) {
		World thisWorld = activeWorlds.get(id);
		return null;
	}
	
	//write a scheduler to 	myWorld.tick();

}
