package com.dominioprojeto.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity //Produto é uma entidade / tabela
public class Produto implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	@ManyToMany //Relação entre as tabelas é Muitos para Muitos (obs.: Um produto pode ter um ou mais categorias);
	@JoinTable(name = "PRODUTO_CATEGORIA", //Como é N-N, a relação vira uma tabela e para criar essa tabela pelo JPA, utilizamos @joinTable
		joinColumns = @JoinColumn(name = "produto_id"), //Chave que irá se relacionar com a outra tabela
		inverseJoinColumns = @JoinColumn(name = "categoria_id") //Chave estrageira 
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	public Produto() {
		
	}
	
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	
}
