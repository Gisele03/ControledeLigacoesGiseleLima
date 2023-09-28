package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Ligacao;

public interface LigacaoRepository extends JpaRepository<Ligacao, Long> {

	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}