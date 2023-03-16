package com.catcov.spring.controllers;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.catcov.spring.dao.RepositoryDao;
import com.catcov.spring.models.ImageAndDesc;

@Controller
public class TestController {
	
	@Autowired
	RepositoryDao repositoryDao;
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userLogin");
		session.removeAttribute("userPass");
		return "redirect:/";
	}
	
	@GetMapping("contact")
	public String contact() {
		return "contacts";
	}
	
	@GetMapping("about")
	public String aboutUs() {
		return "about";
	}
	
	@GetMapping("successful_added_image")
	public String getImages(Model model, ImageAndDesc product) {
		model.addAttribute("products", repositoryDao.getImageAndDesc());
		return "your_image";
	}
	
	@GetMapping("addImageandDesc")
	public String addImageAndDesc() {
		return "form_add_image";
	}
	
	@PostMapping("successful_added_image")
	public String formAddingImage(@RequestParam("description") String desc, @RequestParam("file") MultipartFile file,
			Model model) throws IOException {
		String base64Encoded = new String(Base64.getEncoder().encodeToString(file.getBytes()));
		model.addAttribute("fileName", base64Encoded);
		try {
			repositoryDao.saveImageAndDesc(desc, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "your_image";
	}
	
	
}

