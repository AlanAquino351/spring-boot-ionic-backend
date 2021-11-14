package com.dominioprojeto.cursomc.domain.enums;

import java.util.Iterator;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	//Construtor de tipo enum é privado
	private TipoCliente(int cod, String descricao) { 
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//Somente GET, pois não vamos alterar esses valores
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

