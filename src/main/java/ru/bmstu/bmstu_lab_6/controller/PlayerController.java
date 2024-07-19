package ru.bmstu.bmstu_lab_6.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.bmstu_lab_6.dto.PlayerDTO;
import ru.bmstu.bmstu_lab_6.entity.Player;
import ru.bmstu.bmstu_lab_6.service.PlayerService;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {

	private PlayerService playerService;

	@PostMapping("/createPlayerByLogin")
	public ResponseEntity<Player> CreatePlayerByLogin(@RequestBody PlayerDTO playerDTO) {
		String playerLogin = playerDTO.getPlayerLogin();
		if (playerLogin == null || playerLogin.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (playerService.getByLogin(playerLogin) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(playerService.createByLogin(playerLogin), HttpStatus.CREATED);
	}

	@GetMapping("/getPlayer/{login}")
	public ResponseEntity<Player> getPlayer(@PathVariable String login) {
		Player returnPlayer = playerService.getByLogin(login);
		if (returnPlayer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(returnPlayer, HttpStatus.OK);
	}

	@DeleteMapping("/deletePlayer/{login}")
	public ResponseEntity<Player> deletePlayer(@PathVariable String login) {
		Player returnPlayer = playerService.getByLogin(login);
		if (returnPlayer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		playerService.delete(login);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
