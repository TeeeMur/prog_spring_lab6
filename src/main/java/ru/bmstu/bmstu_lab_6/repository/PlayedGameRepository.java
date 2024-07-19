package ru.bmstu.bmstu_lab_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.bmstu_lab_6.entity.PlayedGame;
import ru.bmstu.bmstu_lab_6.entity.Player;

import java.util.List;

@Repository
public interface PlayedGameRepository extends JpaRepository<PlayedGame,Long> {

	List<PlayedGame> findPlayedGamesByPlayerLogin(String playerLogin);
}
