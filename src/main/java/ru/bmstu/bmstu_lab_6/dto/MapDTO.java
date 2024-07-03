package ru.bmstu.bmstu_lab_6.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MapDTO {

	@JsonIgnore
	private Long mapId;
	private String mapName;
	private String ownerPlayerLogin;
}
