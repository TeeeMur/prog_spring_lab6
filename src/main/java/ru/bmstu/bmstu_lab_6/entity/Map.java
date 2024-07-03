package ru.bmstu.bmstu_lab_6.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="maps")
public class Map {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mapId;
	private String mapName;
	@ManyToOne
	@JoinColumn
	private Player ownerPlayer;
}
