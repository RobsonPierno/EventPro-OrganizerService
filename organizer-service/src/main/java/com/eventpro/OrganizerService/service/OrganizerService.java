package com.eventpro.OrganizerService.service;

import java.util.List;

import com.eventpro.OrganizerService.dto.OrganizerDTO;

public interface OrganizerService {

	public void create(final OrganizerDTO organizer);
	
	public OrganizerDTO findById(final Integer id);
	
	public List<OrganizerDTO> findAll(final String status);

	public OrganizerDTO changeStatus(final Integer id);
}
