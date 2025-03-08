package br.com.sampaio.enums;

public enum TipoUsuario {
	ADMINISTRADOR("Administrador"),
	SINDICO("Sindico"),
	FUNCIONARIO("Funcionário");
	
	private String tipoUsuario;
	
	private TipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	

}
