package com.ericbarajas.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ericbarajas.dojosninjas.models.Dojo;
import com.ericbarajas.dojosninjas.services.DojoService;
import com.ericbarajas.dojosninjas.services.NinjaService;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoServ;
	
	@Autowired
	NinjaService ninjaServ;
	
	// ---------------- CREATING A Dojo -----------------//
	@GetMapping(value={"/", "/dojo/new"})
	public String createDojo(
		@ModelAttribute("dojoObj")Dojo emptyDojo
	) {
		return "/dojo/create.jsp";
	}
	
	@PostMapping("/dojo/new")
	public String processDojo(
		@Valid @ModelAttribute("dojoObj")Dojo filledDojo,
		BindingResult results
	) {
		// VALIDATIONS FAIL
		if(results.hasErrors()) {
			return "/dojo/create.jsp";
		}
		// VALIDATIONS PASS
		dojoServ.createDojo(filledDojo);
		return "redirect:/";
	}
	
	
	
	// ---------------- READ (DISPLAY ONE DOJO) -----------------//
	@GetMapping("/dojo/{id}")
	public String oneDojo(
		@PathVariable("id") Long DojoId,
		Model model
	) {
		Dojo oneDojo = dojoServ.getOneDojo(DojoId);
		model.addAttribute("dojo", oneDojo);
		return "/dojo/display.jsp";
	}
}
