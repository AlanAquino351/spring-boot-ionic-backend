package com.dominioprojeto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominioprojeto.cursomc.domain.Categoria;
import com.dominioprojeto.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	// Autowired instancia automaticamente a dependencia
	@Autowired
	private CategoriaRepository repo; // Declarando dependencia
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}