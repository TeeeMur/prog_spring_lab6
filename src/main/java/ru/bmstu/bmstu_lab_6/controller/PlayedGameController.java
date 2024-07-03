package ru.bmstu.bmstu_lab_6.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.bmstu_lab_6.dto.PlayedGameDTO;
import ru.bmstu.bmstu_lab_6.entity.Map;
import ru.bmstu.bmstu_lab_6.entity.PlayedGame;
import ru.bmstu.bmstu_lab_6.entity.Player;
import ru.bmstu.bmstu_lab_6.service.MapService;
import ru.bmstu.bmstu_lab_6.service.PlayedGameService;
import ru.bmstu.bmstu_lab_6.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/stats")
@AllArgsConstructor
public class PlayedGameController {

	private PlayedGameService playedGameService;
	private PlayerService playerService;
	private MapService mapService;

	@PostMapping("/createStatPlayer")
	public ResponseEntity<PlayedGame> createPlayedGame(@RequestBody PlayedGameDTO playedGameDTO) {
		Player player = playerService.getByLogin(playedGameDTO.getPlayerLogin());
		Map map = mapService.getMapByLoginAndMapName(player.getPlayerLogin(), playedGameDTO.getMapName());
		if (map == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(playedGameService.create(playedGameDTO), HttpStatus.CREATED);
	}

	@GetMapping("/getStatPlayer/{login}")
	public ResponseEntity<List<PlayedGame>> getStatPlayer(@PathVariable String login) {
		return new ResponseEntity<>(playedGameService.readAllByLogin(login), HttpStatus.OK);
	}
}
