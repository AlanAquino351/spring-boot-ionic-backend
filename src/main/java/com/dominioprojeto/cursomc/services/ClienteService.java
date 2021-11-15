package com.dominioprojeto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominioprojeto.cursomc.domain.Cliente;
import com.dominioprojeto.cursomc.repositories.ClienteRepository;
import com.dominioprojeto.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	// Autowired instancia automaticamente a dependencia
	@Autowired
	private ClienteRepository repo; // Declarando dependencia
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
