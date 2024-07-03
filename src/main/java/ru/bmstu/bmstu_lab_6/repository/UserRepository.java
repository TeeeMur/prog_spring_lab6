package ru.bmstu.bmstu_lab_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.bmstu_lab_6.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
	User findUserByUserLogin(String userLogin);

}
