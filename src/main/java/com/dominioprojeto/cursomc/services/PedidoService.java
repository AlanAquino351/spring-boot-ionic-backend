package com.dominioprojeto.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominioprojeto.cursomc.domain.Pedido;
import com.dominioprojeto.cursomc.repositories.PedidoRepository;
import com.dominioprojeto.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	// Autowired instancia automaticamente a dependencia
	@Autowired
	private PedidoRepository repo; // Declarando dependencia
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
