package com.stealth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stealth.model.GModel;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(path="/home")
	public String home(Model model){
		model.addAttribute("gModel", new GModel());
		return "Home";
	}
}
