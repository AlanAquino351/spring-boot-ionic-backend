package com.dominioprojeto.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

/* Implentação da interface Serializable: 
 * Exigido pela linguagem Java;
 * Faz com que os objetos da classe sejam convertidos para uma sequencia de bits
 * para que os objetos sejam gravados em arquivos, trafegar em rede e etc... 
*/ 

public class Categoria implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() { // Método que gera um código para cada objeto
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { //Faz a comparação dos valores de dois objetos
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	
}
