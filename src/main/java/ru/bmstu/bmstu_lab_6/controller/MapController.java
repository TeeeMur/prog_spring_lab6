package ru.bmstu.bmstu_lab_6.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.bmstu_lab_6.dto.MapDTO;
import ru.bmstu.bmstu_lab_6.entity.Map;
import ru.bmstu.bmstu_lab_6.service.MapService;
import ru.bmstu.bmstu_lab_6.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/maps")
@AllArgsConstructor
public class MapController {

	private final MapService mapService;
	private final PlayerService playerService;

	@PostMapping("/createMapPlayer")
	public ResponseEntity<Map> createMapPlayer(@RequestBody MapDTO mapDTO) {
		String playerLogin = mapDTO.getOwnerPlayerLogin();
		String mapName = mapDTO.getMapName();
		if (playerService.getByLogin(playerLogin) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (mapName == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Map map = mapService.create(mapDTO);
		if (map == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping("/getMapPlayer/{login}")
	public ResponseEntity<List<Map>> getMapsPlayer(@PathVariable String login) {
		if (playerService.getByLogin(login) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(mapService.getMapsByLogin(login), HttpStatus.OK);
	}
}
