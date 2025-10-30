package com.eventpro.OrganizerService.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventpro.OrganizerService.dto.OrganizerDTO;
import com.eventpro.OrganizerService.model.Organizer;
import com.eventpro.OrganizerService.repository.OrganizerRepository;
import com.eventpro.OrganizerService.service.OrganizerService;
import com.eventpro.OrganizerService.utils.OrganizerMapper;

@Service
public class OrganizerServiceImpl implements OrganizerService {
	
	private static final Logger log = LogManager.getLogger(OrganizerService.class);
	
	@Autowired
	private OrganizerRepository repository;
	
	@Autowired
	private OrganizerMapper mapper;

	@Override
	public void create(final OrganizerDTO dto) {
		log.debug("create({})", dto);
		
		Organizer entity = this.mapper.toEntity(dto);
		this.repository.save(entity);
	}

	@Override
	public OrganizerDTO findById(final Integer id) {
		log.debug("findById({})", id);
		
		OrganizerDTO dto = this.repository.findById(id)
											.map(e -> this.mapper.toDto(e))
											.orElseThrow(RuntimeException::new);
		return dto;
	}

	@Override
	public List<OrganizerDTO> findAll() {
		log.debug("findAll()");
		
		List<OrganizerDTO> response = new ArrayList<>();
		this.repository.findAll().forEach(e -> response.add(this.mapper.toDto(e)));
		return response;
	}
	
	

}
