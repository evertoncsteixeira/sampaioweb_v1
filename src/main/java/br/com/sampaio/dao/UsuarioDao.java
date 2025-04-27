package br.com.sampaio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sampaio.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmail(String email);
	
	@Query("select u from Usuario u where u.login = :login")
	public Usuario findByLogin(String login);
	
	@Query("select u from Usuario u where u.login = :login and u.senha = :senha" )
	public Usuario buscarLogin(String login, String senha);
}
