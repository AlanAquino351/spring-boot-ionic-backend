package com.dominioprojeto.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/* Implentação da interface Serializable: 
 * Exigido pela linguagem Java;
 * Faz com que os objetos da classe sejam convertidos para uma sequencia de bits
 * para que os objetos sejam gravados em arquivos, trafegar em rede e etc... 
*/ 

@Entity
public class Categoria implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	/*@JsonManagedReference utilizado para referenciar corretamente os produtos sem a interferencia da classe Produto.
	 * Obs.: Na classe Produto, temos o comando @JsonBackReference.
	*/
	@JsonManagedReference 
	@ManyToMany(mappedBy = "categorias") //Como na tabela de produtos foi feito a relação entre PK e FK, aqui só é necessario informar que o mapeamento é o mesmo do produto.
	private List<Produto> produtos = new ArrayList<>();
	
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
