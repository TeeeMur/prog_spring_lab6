package ru.bmstu.bmstu_lab_6.controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.bmstu_lab_6.dto.UserDTO;
import ru.bmstu.bmstu_lab_6.entity.User;
import ru.bmstu.bmstu_lab_6.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping("/createUserByLogin")
	public ResponseEntity<User> createUserByLogin(@RequestBody UserDTO userDTO) {
		String userLogin = userDTO.getUserLogin();
		if (userLogin == null || userLogin.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (userService.findByUserLogin(userLogin) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userService.createByLogin(userLogin), HttpStatus.CREATED);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
	}

	@GetMapping("/getUser/{login}")
	public ResponseEntity<User> getUserByLogin(@PathVariable String login) {
		User user = userService.findByUserLogin(login);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUserByLogin/{login}")
	public ResponseEntity<User> deleteUserByLogin(@PathVariable String login) {
		User user = userService.findByUserLogin(login);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.delete(login);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deleteAllUsers")
	public ResponseEntity<User> deleteAllUsers() {
		userService.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
