package ru.bmstu.bmstu_lab_6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.bmstu_lab_6.dto.MapDTO;
import ru.bmstu.bmstu_lab_6.entity.Map;
import ru.bmstu.bmstu_lab_6.entity.Player;
import ru.bmstu.bmstu_lab_6.repository.MapRepository;
import ru.bmstu.bmstu_lab_6.repository.PlayerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MapService {


	private MapRepository mapRepository;
	private PlayerRepository playerRepository;

	public Map create(MapDTO mapDTO) {
		Player ownerPlayer = playerRepository.getReferenceById(mapDTO.getOwnerPlayerLogin());
		if (mapRepository.findOneByOwnerPlayerAndMapName(ownerPlayer, mapDTO.getMapName()) != null) {
			return null;
		}
		Map map = Map.builder()
				.mapId(mapDTO.getMapId())
				.mapName(mapDTO.getMapName())
				.ownerPlayer(playerRepository.getReferenceById(mapDTO.getOwnerPlayerLogin()))
				.build();
		mapRepository.save(map);
		return map;
	}

	public List<Map> readAll() {
		return mapRepository.findAll();
	}

	public Map update(Map map) {
		return mapRepository.save(map);
	}

	public List<Map> getMapsByLogin(String login) {
		return mapRepository.findAllByOwnerPlayer(playerRepository.findByPlayerLogin(login));
	}

	public Map getMapByLoginAndMapName(String login, String mapName) {
		return mapRepository.findOneByOwnerPlayerAndMapName(playerRepository.findByPlayerLogin(login), mapName);
	}

	public Map getMapById(Long mapId) {
		return mapRepository.getReferenceById(mapId);
	}

	public void delete(Long id) {
		mapRepository.deleteById(id);
	}

	public void deleteByOwnerPlayerLogin(String login) {
		mapRepository.deleteByOwnerPlayer(playerRepository.findByPlayerLogin(login));
	}
}
