package com.dominioprojeto.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dominioprojeto.cursomc.domain.Categoria;
import com.dominioprojeto.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")  //End Point
public class CategoriaResources {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)  //GET pois está obtendo um dado, mas poderia ser DELET para deletar e etc
	public ResponseEntity<?> find(@PathVariable Integer id) { // @PathVariable faz com que o sistema saiba que é o valor da ID é o mesmo da linha 17 (value="/{id}")
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj); // Ok que deu certo e body é o corpo, que é o obj
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
