package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Ligacao;
import com.projetojpa.repository.LigacaoRepository;

@Service
public class LigacaoService {
    private final LigacaoRepository ligacaoRepository;

    //construtor que recebe a dependencia
    @Autowired
    public LigacaoService(LigacaoRepository ligacaoRepository) {
        this.ligacaoRepository = ligacaoRepository;
    }
    public List<Ligacao> buscaTodosLigacoes() {
        return ligacaoRepository.findAll();  
    }
    public Ligacao buscaLigacaoId(Long id) {
    	Optional <Ligacao> ligacao = ligacaoRepository.findById(null);
    	return ligacao.orElse(null);
    }
    public Ligacao SalvaLigacao(Ligacao ligacao) {
    	return ligacaoRepository.save(ligacao);
    }
    public Ligacao alterarLigacao (Long id, Ligacao alterarLiga) {
    	Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
    	if (existeLigacao.isPresent()) {
    		alterarLiga.setId(id);
    		return ligacaoRepository.save(alterarLiga);
    	}
    	return null;
}
    public boolean apagarLigacao(Long id) {
    	Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
    	if(existeLigacao.isPresent()) {
    		ligacaoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}