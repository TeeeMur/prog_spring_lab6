package ru.bmstu.bmstu_lab_6.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PlayedGameDTO {

	@JsonIgnore
	private Long playedGameId;
	private String mapName;
	private String playerLogin;
	private boolean gameIsWon;
}
