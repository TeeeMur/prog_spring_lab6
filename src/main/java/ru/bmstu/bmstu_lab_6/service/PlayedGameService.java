package ru.bmstu.bmstu_lab_6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.bmstu_lab_6.dto.PlayedGameDTO;
import ru.bmstu.bmstu_lab_6.entity.PlayedGame;
import ru.bmstu.bmstu_lab_6.entity.Player;
import ru.bmstu.bmstu_lab_6.repository.MapRepository;
import ru.bmstu.bmstu_lab_6.repository.PlayedGameRepository;
import ru.bmstu.bmstu_lab_6.repository.PlayerRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class PlayedGameService {

	private PlayedGameRepository playedGameRepository;
	private MapRepository mapRepository;
	private PlayerRepository playerRepository;

	public PlayedGame create(PlayedGameDTO playedGameDTO) {
		Player ownerPlayer = playerRepository.findByPlayerLogin(playedGameDTO.getPlayerLogin());
		PlayedGame playedGame = PlayedGame.builder()
				.gameIsWon(playedGameDTO.isGameIsWon())
				.playedMap(mapRepository.findOneByOwnerPlayerAndMapName(ownerPlayer, playedGameDTO.getMapName()))
				.playerLogin(ownerPlayer.getPlayerLogin())
				.build();
		playedGameRepository.save(playedGame);
		return playedGame;
	}

	public List<PlayedGame> readAll() {
		return playedGameRepository.findAll();
	}

	public List<PlayedGame> readAllByLogin(String login) {
		Player ownerPlayer = playerRepository.findByPlayerLogin(login);
		return playedGameRepository.findPlayedGamesByPlayerLogin(login);
	}

	public PlayedGame update(PlayedGame playedGame) {
		return playedGameRepository.save(playedGame);
	}

	public void delete(Long id) {
		playedGameRepository.deleteById(id);
	}
}
