package ru.bmstu.bmstu_lab_6.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UserDTO {

	private String userLogin;
	private String userEmail;
}
