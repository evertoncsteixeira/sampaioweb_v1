package br.com.sampaio.enums;

public enum Pessoa {
	CPF("CPF"),
	CNPJ("CNPJ");
	
	private String pessoa;
	
	private Pessoa(String pessoa) {
		this.pessoa = pessoa;
	}

}
