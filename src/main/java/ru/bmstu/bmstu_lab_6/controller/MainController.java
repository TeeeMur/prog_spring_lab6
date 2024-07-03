package ru.bmstu.bmstu_lab_6.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class MainController {

	@RequestMapping("/getStatus")
	public String getStatus() {
		return "Service is working now!";
	}
}
