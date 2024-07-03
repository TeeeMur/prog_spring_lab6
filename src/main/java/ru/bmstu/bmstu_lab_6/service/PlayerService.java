package ru.bmstu.bmstu_lab_6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.bmstu_lab_6.dto.PlayerDTO;
import ru.bmstu.bmstu_lab_6.entity.Player;
import ru.bmstu.bmstu_lab_6.repository.PlayerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {

	private PlayerRepository playerRepository;

	public Player create(PlayerDTO playerDTO) {
		Player player = Player.builder()
				.playerLogin(playerDTO.getPlayerLogin())
				.playerEmail(playerDTO.getPlayerEmail())
				.build();
		return playerRepository.save(player);
	}

	public Player createByLogin(String login) {
		Player player = Player.builder()
				.playerLogin(login)
				.build();
		return playerRepository.save(player);
	}

	public Player getByLogin(String login) {
		return playerRepository.findByPlayerLogin(login);
	}

	public List<Player> readAll() {
		return playerRepository.findAll();
	}

	public Player update(Player player) {
		return playerRepository.save(player);
	}

	public void delete(String id) {
		playerRepository.deleteById(id);
	}
}
