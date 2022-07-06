package net.traininguniverse.logging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.traininguniverse.logging.repository.UserRepository;

@Controller
public class AppController {

	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	
}
