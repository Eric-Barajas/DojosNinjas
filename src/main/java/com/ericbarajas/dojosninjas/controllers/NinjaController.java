package com.ericbarajas.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ericbarajas.dojosninjas.models.Ninja;
import com.ericbarajas.dojosninjas.services.DojoService;
import com.ericbarajas.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	DojoService dojoServ;
	
	@Autowired
	NinjaService ninjaServ;
	
	
	// ---------------- CREATING A NINJA -----------------//
	@GetMapping("/ninja/new")
	public String createNinja(
		@ModelAttribute("ninjaObj") Ninja emptyNinjaObj,
		Model model
	) {
		model.addAttribute("allDojos", dojoServ.getAllDojoes());
		return "/ninja/create.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String processNinja(
		@Valid @ModelAttribute("ninjaObj")Ninja filledNinja,
		BindingResult results,
		Model model
	) {
		// VALIDATIONS FAIL
		if(results.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.getAllDojoes());
			return "/ninja/create.jsp";
		}
		// VALIDATIONS PASS
		ninjaServ.createNinja(filledNinja);
		return "redirect:/ninja/new";
	}
}
