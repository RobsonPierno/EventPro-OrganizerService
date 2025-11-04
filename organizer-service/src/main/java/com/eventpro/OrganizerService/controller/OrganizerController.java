package com.eventpro.OrganizerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventpro.OrganizerService.client.OrganizerClient;
import com.eventpro.OrganizerService.dto.OrganizerDTO;
import com.eventpro.OrganizerService.service.OrganizerService;

@RestController
@RequestMapping("/organizer")
public class OrganizerController implements OrganizerClient {
	
	@Autowired
	private OrganizerService service;

	public void create(final OrganizerDTO organizer) {
		this.service.create(organizer);
	}
	
	public OrganizerDTO findById(final Integer id) {
		return this.service.findById(id);
	}
	
	public List<OrganizerDTO> findAll(final String status) {
		return this.service.findAll(status);
	}
	
	public OrganizerDTO changeStatus(final Integer id) {
		return this.service.changeStatus(id);
	}
}
