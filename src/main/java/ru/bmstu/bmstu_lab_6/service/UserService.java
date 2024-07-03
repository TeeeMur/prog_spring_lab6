package ru.bmstu.bmstu_lab_6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.bmstu_lab_6.dto.UserDTO;
import ru.bmstu.bmstu_lab_6.entity.User;
import ru.bmstu.bmstu_lab_6.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

	private UserRepository userRepository;

	public User create(UserDTO userDTO) {
		User newUser =  User.builder()
				.userLogin(userDTO.getUserLogin())
				.userEmail(userDTO.getUserEmail())
				.build();
		userRepository.save(newUser);
		return newUser;
	}

	public User createByLogin(String userLogin) {
		User newUser = User.builder()
				.userLogin(userLogin)
				.build();
		userRepository.save(newUser);
		return newUser;
	}

	public User findByUserLogin(String userLogin) {
		for (User user : userRepository.findAll()) {
			if (user.getUserLogin().equals(userLogin)) {
				return user;
			}
		}
		return null;
	}

	public List<User> readAll() {
		return userRepository.findAll();
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void delete(String userLogin) {
		userRepository.deleteById(userLogin);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}
}
