package ru.bmstu.bmstu_lab_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.bmstu_lab_6.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {

	Player findByPlayerLogin(String playerLogin);

}
