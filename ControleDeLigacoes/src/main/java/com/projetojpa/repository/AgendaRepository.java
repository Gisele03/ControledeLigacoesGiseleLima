package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}
