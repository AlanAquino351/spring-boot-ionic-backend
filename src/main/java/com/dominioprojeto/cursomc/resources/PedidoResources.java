package com.dominioprojeto.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dominioprojeto.cursomc.domain.Pedido;
import com.dominioprojeto.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")  //End Point
public class PedidoResources {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)  //GET pois está obtendo um dado, mas poderia ser DELET para deletar e etc
	public ResponseEntity<Pedido> find(@PathVariable Integer id) { // @PathVariable faz com que o sistema saiba que é o valor da ID é o mesmo da linha 17 (value="/{id}")
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj); // Ok que deu certo e body é o corpo, que é o obj
	}
}
