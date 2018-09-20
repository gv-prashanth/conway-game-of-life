package com.vadrin.conwaygameoflife.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vadrin.conwaygameoflife.services.World;

@RestController
public class GameOfLifeController {

	private Map<String, World> activeWorlds;
	private static final Logger log = LoggerFactory.getLogger(GameOfLifeController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/world")
	public ResponseEntity<Object> createAWorld(@RequestBody JsonNode worldInfo) {
		try {
			String id = UUID.randomUUID().toString();
			ObjectMapper mapper = new ObjectMapper();
			World thisWorld = mapper.treeToValue(worldInfo, World.class);
			activeWorlds.put(id, thisWorld);
			log.info("Constructed new world {}", id);
			return ResponseEntity.created(new URI("/world/" + id)).build();
		} catch (NullPointerException | URISyntaxException | JsonProcessingException e) {
			e.printStackTrace();
			Map<String, String> toReturn = new HashMap<String, String>();
			toReturn.put("Exception", "Invalid Input. Please see sample at XXXXX");
			return ResponseEntity.badRequest().body(toReturn);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/world/{id}")
	public ResponseEntity<Object> getWorld(@PathVariable("id") String id) {
		if (!activeWorlds.containsKey(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		World thisWorld = activeWorlds.get(id);
		return ResponseEntity.ok(thisWorld);
	}

	@Scheduled(fixedDelayString = "${com.vadrin.worldtick.frequency}")
	public void moveTheWorldForward() {
		activeWorlds.keySet().forEach(key -> {
			log.info("Moving the world forward one step at a time..." + key);
			activeWorlds.get(key).tick();
			// TODO: Check and remove the world if there is no life
		});
	}

	@PostConstruct
	private void startTheWorldEngine() {
		this.activeWorlds = new HashMap<String, World>();
	}

}
