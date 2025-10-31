package com.eventpro.OrganizerService.dto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "organizer-service", url = "http://organizer:8080", path = "/organizer")
public interface OrganizerClient {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody final OrganizerDTO organizer);
	
	@GetMapping("/{id}")
	public OrganizerDTO findById(@PathVariable final Integer id);
	
	@GetMapping
	public List<OrganizerDTO> findAll(@RequestParam(required = false) final String status);
	
	@PatchMapping("/status/{id}")
	public OrganizerDTO changeStatus(@PathVariable final Integer id);
}
