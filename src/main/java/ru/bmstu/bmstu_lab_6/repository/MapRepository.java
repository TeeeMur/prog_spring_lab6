package ru.bmstu.bmstu_lab_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.bmstu_lab_6.entity.Map;
import ru.bmstu.bmstu_lab_6.entity.Player;

import java.util.List;

@Repository
public interface MapRepository extends JpaRepository<Map,Long> {

	List<Map> findAllByOwnerPlayer(Player ownerPlayer);
	Map findOneByOwnerPlayerAndMapName(Player ownerPlayer, String mapName);
	void deleteByOwnerPlayer(Player ownerPlayer);
}
