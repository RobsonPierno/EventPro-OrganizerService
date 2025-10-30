package com.eventpro.OrganizerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventpro.OrganizerService.model.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {

}
