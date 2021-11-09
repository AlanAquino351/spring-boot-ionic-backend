package com.dominioprojeto.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")  //End Point
public class CategoriaResources {
	
	@RequestMapping(method = RequestMethod.GET)  //GET pois está obtendo um dado, mas poderia ser DELET para deletar e etc
	public String listar() {
		return "Rest está funcionando!";
	}
	
}
