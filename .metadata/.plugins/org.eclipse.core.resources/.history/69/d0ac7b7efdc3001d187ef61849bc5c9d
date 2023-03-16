package com.catcov.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catcov.spring.dao.RepositoryDao;
import com.catcov.spring.service.SessionService;


@Controller
public class HomeController {

	@Autowired
	RepositoryDao repositoryDao;

	@Autowired
	SessionService sessionService;

	// main
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("Home Page Requested");
		return "index";
	}
	

}
