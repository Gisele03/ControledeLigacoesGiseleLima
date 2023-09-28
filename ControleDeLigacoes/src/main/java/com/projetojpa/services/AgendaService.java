package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Agenda;
import com.projetojpa.repository.AgendaRepository;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;

    //construtor que recebe a dependencia
    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }
    public List<Agenda> buscaTodosAgendas() {
        return agendaRepository.findAll();  
    }
    public Agenda buscaAgendaId(Long id) {
    	Optional <Agenda> agenda = agendaRepository.findById(null);
    	return agenda.orElse(null);
    }
    public Agenda SalvaAgenda(Agenda tarefa) {
    	return agendaRepository.save(tarefa);
    }
    public Agenda alterarAgenda (Long id, Agenda alterarAgen) {
    	Optional <Agenda> existeAgenda = agendaRepository.findById(id);
    	if (existeAgenda.isPresent()) {
    		alterarAgen.setId(id);
    		return agendaRepository.save(alterarAgen);
    	}
    	return null;
}
    public boolean apagarAgenda(Long id) {
    	Optional <Agenda> existeAgenda = agendaRepository.findById(id);
    	if(existeAgenda.isPresent()) {
    		agendaRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}