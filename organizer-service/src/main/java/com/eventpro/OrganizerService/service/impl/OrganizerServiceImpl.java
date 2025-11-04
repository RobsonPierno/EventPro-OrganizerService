package com.eventpro.OrganizerService.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eventpro.OrganizerService.dto.OrganizerDTO;
import com.eventpro.OrganizerService.enums.StatusEnum;
import com.eventpro.OrganizerService.exception.OrganizerNotFoundException;
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
											.orElseThrow(() -> new OrganizerNotFoundException("It was nor possible to find the Organizer with ID "+ id));
		return dto;
	}

	@Override
	public List<OrganizerDTO> findAll(final String status) {
		log.debug("findAll({})", status);
		
		List<OrganizerDTO> response = new ArrayList<>();
		Consumer<Organizer> convertEntityToDto = e -> response.add(this.mapper.toDto(e));
		
		if (status != null) {
			StatusEnum statusEnum = StatusEnum.valueOf(status);
			this.repository.findAllByStatusOrderByNameAsc(statusEnum).forEach(convertEntityToDto);
			return response;
		}
		
		this.repository.findAllByOrderByNameAsc().forEach(convertEntityToDto);
		return response;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public OrganizerDTO changeStatus(final Integer id) {
		log.debug("changeStatus({})",id);
		
		Organizer organizer = this.repository.findById(id).orElseThrow(RuntimeException::new);
		StatusEnum status = organizer.getStatus();
		StatusEnum oppositeStatus = StatusEnum.ACTIVE.equals(status) ? StatusEnum.INACTIVE : StatusEnum.ACTIVE;
		organizer.setStatus(oppositeStatus);
		log.info("Changing Status of {} to {}", organizer.getName(), organizer.getStatus());
		
		return this.mapper.toDto(organizer);
	}
	
	

}
