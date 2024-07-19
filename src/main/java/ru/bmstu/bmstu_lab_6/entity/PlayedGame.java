package ru.bmstu.bmstu_lab_6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="played_games")
public class PlayedGame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playedGameId;
	private String playerLogin;
	private boolean gameIsWon;
	@ManyToOne
	@JoinColumn
	private Map playedMap;
}
