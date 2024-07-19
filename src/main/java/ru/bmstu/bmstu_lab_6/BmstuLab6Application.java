package ru.bmstu.bmstu_lab_6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BmstuLab6Application {

	public static void main(String[] args) {
		SpringApplication.run(BmstuLab6Application.class);
	}

}
