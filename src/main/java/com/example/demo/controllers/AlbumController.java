package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Album;
import com.example.demo.models.Track;
import com.example.demo.services.AlbumService;

@Controller
@RequestMapping("album")
public class AlbumController {
	
	@Autowired
	private AlbumService service;
	
	// home
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}

	// add
	@GetMapping("/add")
	public String getGetForm(@ModelAttribute("item") Album item) {
		return "add.jsp";
	}
	
	@PostMapping("/add")
	public String add(
			@Valid @ModelAttribute("item") Album item,
			BindingResult result,
			RedirectAttributes redirectAttributes
			) {
		// direct back to add page
		if ( result.hasErrors() ) return "add.jsp";
		
		this.service.create(item);
		
		redirectAttributes.addFlashAttribute("message", "It has been added.");
		
		return "redirect:/view";
	}
	
	// get
	@GetMapping("/view/{id}")
	public String view(
			@PathVariable Long id,
			Model model
			) {
		model.addAttribute("album", this.service.retrieve(id));
		
		return "view.jsp";
	}
	
	// update
	@GetMapping("/update/{id}")
	public String edit(
			@PathVariable Long id,
			Model model
			) {
		model.addAttribute("album", this.service.retrieve(id));
		model.addAttribute("track", new Track());
		
		return "edit.jsp";
	}

	@PostMapping("/update/{id}")
	public String update(
			@Valid @ModelAttribute("item") Album item,
			BindingResult result,
			RedirectAttributes redirectAttributes
			) {
		if ( result.hasErrors() ) return "edit.jsp";
		
		this.service.update(item);
		
		redirectAttributes.addFlashAttribute("message", "It has been updated.");

		return "redirect:/edit";
	}
	
	// delete
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable Long id,
			RedirectAttributes redirectAttributes
			) {
		this.service.delete(id);
		
		redirectAttributes.addFlashAttribute("message", "It has been deleted.");
		
		return "redirect:/view";
	}
}
	
	
