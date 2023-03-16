package com.catcov.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catcov.spring.dao.RepositoryDao;
import com.catcov.spring.models.Product;
import com.catcov.spring.models.SearchEntity;
import com.catcov.spring.models.User;
import com.catcov.spring.models.UserAddress;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	RepositoryDao repositoryDao;

	private static final int WEAK_STRENGTH = 1;
	private static final int FEAR_STRENGTH = 8;
	private static final int STRONG_STRENGTH = 12;

	// user
	@GetMapping("/registration_form")
	public String showSignUp(Model model, User user) {
		model.addAttribute("admin", "admin");
		System.out.println("Registration form Page Requested");
		return "registration_form";
	}

	// user
	@PostMapping("/registration")
	public String registration(Model model, @Valid @ModelAttribute("user") User user, BindingResult result,
			UserAddress userAddress, HttpSession session, @ModelAttribute("searchEntity") SearchEntity searchEntity) {
		model.addAttribute("searchTitle", searchEntity.getSearchTitle());
		model.addAttribute("admin", "admin");
		if (result.hasErrors()) {
			return "registration_form";
		}

		session.setAttribute("userEmail", user.getEmail());
		int checker = repositoryDao.checkUser(user.getLogin(), user.getPass());
		if (checker > 0) {
			return "registration_error";
		} else {
			System.out.println(user.getLogin() + ", " + user.getPass() + ", " + user.getEmail() + ", " + user.getFirstName() + ", " + user.getLastName());
			repositoryDao.saveUser(user.getLogin(), user.getPass(), user.getEmail(), user.getFirstName(),
					user.getLastName());
			repositoryDao.saveUserAdress(userAddress.getCountry(), userAddress.getCity(), userAddress.getStreet(),
					userAddress.getZipCode(), user.getEmail());
			return "success_registration";

		}
	}

	// user
	@GetMapping("/userCabinet")
	public String userCabinet(Model model, User user, UserAddress userAddress, HttpSession session) {
		String login = (String) session.getAttribute("userLogin");
		String email = repositoryDao.getUserEmail(login);
		System.out.println("userCabinet login and email - " + login + " " + email);
		model.addAttribute("userInfo", repositoryDao.getUserInfo(email));
		model.addAttribute("userAddress", repositoryDao.getUserAddress(email));
		return "userCabinet";
	}

	// user
	@GetMapping("editUserAddress")
	public String editUserAddress(HttpSession session) {
		return "editUserAddress";
	}

	// user
	@GetMapping("editUser")
	public String editUser() {
		return "editUser";
	}

	// user
	@GetMapping("addUserAddress")
	public String addUserAddress() {
		return "addUserAddress";
	}

	// user
	@GetMapping("successeful_changed")
	public String success_changing() {
		return "successeful_changed";
	}

	// user
	@PostMapping("successeful_changed_userInfo")
	public String changedInfo(Model model, UserAddress userAddress, User user, HttpSession session) {
		String login = (String) session.getAttribute("userLogin");
		String email = repositoryDao.getUserEmail(login);
		System.out.println("userInfo - " + email);
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		repositoryDao.updateUser(user.getFirstName(), user.getLastName(), email);
		return "redirect:/successeful_changed";
	}

	// user
	@PostMapping("successeful_changed_address")
	public String changedAddress(Model model, UserAddress userAddress, User user, HttpSession session) {
		String login = (String) session.getAttribute("userLogin");
		String email = repositoryDao.getUserEmail(login);
		System.out.println("userAddress - " + email);
		model.addAttribute("country", userAddress.getCountry());
		model.addAttribute("city", userAddress.getCity());
		model.addAttribute("street", userAddress.getStreet());
		model.addAttribute("zipCode", userAddress.getZipCode());
		repositoryDao.updateUserAddress(userAddress.getCountry(), userAddress.getCity(), userAddress.getStreet(),
				userAddress.getZipCode(), email);
		return "redirect:/successeful_changed";
	}

	// user
	@PostMapping("successeful_added_address")
	public String addAddress(Model model, UserAddress userAddress, User user, HttpSession session) {
		String login = (String) session.getAttribute("userLogin");
		String email = repositoryDao.getUserEmail(login);
		System.out.println("addUserAddress - " + email);
		model.addAttribute("country", userAddress.getCountry());
		model.addAttribute("city", userAddress.getCity());
		model.addAttribute("street", userAddress.getStreet());
		model.addAttribute("zipCode", userAddress.getZipCode());
		repositoryDao.saveUserAdress(userAddress.getCountry(), userAddress.getCity(), userAddress.getStreet(),
				userAddress.getZipCode(), email);
		return "redirect:/successeful_changed";
	}

	@GetMapping(path = "/registration_form/checkStrength", consumes = "application/json", produces = {
			"text/html; charset=UTF-8" })
	public @ResponseBody String checkStrength(@RequestParam String password) {
		if (password.length() >= WEAK_STRENGTH && password.length() < FEAR_STRENGTH) {
			return "Weak";
		} else if (password.length() >= FEAR_STRENGTH && password.length() < STRONG_STRENGTH) {
			return "Fear";
		} else if (password.length() >= STRONG_STRENGTH) {
			return "Strong";
		}
		return "";
	}

	@PostMapping("/findProduct")
	public String dropDownBoxWithSearch(@ModelAttribute("searchEntity") SearchEntity searchEntity, Model model) {
		model.addAttribute("searchTitle", searchEntity.getSearchTitle());
		return "products";
	}

	@GetMapping(path = "/findProducts", consumes = { "application/json; charset=UTF-8" }, produces = {
			"application/json; charset=UTF-8" })
	public @ResponseBody List<Product> findProduct(@RequestParam(value = "temp", required = false, defaultValue = "") String temp, HttpSession session) {
		List<Product> res = new ArrayList<>();
		try {
			int id = Integer.parseInt(temp);
			res = repositoryDao.findProductByIdOrName(id, (String) session.getAttribute("currency"));
		} catch (Exception e) {
			res = repositoryDao.findProductByIdOrName(temp, (String) session.getAttribute("currency"));

		}

		return res;
	}

}
