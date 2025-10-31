package com.eventpro.OrganizerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eventpro.OrganizerService.dto.OrganizerDTO;
import com.eventpro.OrganizerService.service.OrganizerService;

@RestController
@RequestMapping("/organizer")
public class OrganizerController {
	
	@Autowired
	private OrganizerService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody final OrganizerDTO organizer) {
		this.service.create(organizer);
	}
	
	@GetMapping("/{id}")
	public OrganizerDTO findById(@PathVariable final Integer id) {
		return this.service.findById(id);
	}
	
	@GetMapping
	public List<OrganizerDTO> findAll(@RequestParam(required = false) final String status) {
		return this.service.findAll(status);
	}
	
	@PatchMapping("/status/{id}")
	public OrganizerDTO changeStatus(@PathVariable final Integer id) {
		return this.service.changeStatus(id);
	}
}
