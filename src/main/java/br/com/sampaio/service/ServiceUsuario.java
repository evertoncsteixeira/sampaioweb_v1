package br.com.sampaio.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sampaio.dao.UsuarioDao;
import br.com.sampaio.exception.CriptoExistsException;
import br.com.sampaio.exception.EmailExistsException;
import br.com.sampaio.exception.LoginExistsException;
import br.com.sampaio.model.Usuario;
import br.com.sampaio.util.util;

@Service
public class ServiceUsuario {
	
	@Autowired
	private UsuarioDao usuarioRepository;
	
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		try {
			if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
				throw new EmailExistsException("Já existe um cadastro usando esse email");
			}
			if (usuarioRepository.findByLogin(usuario.getLogin()) != null) {
				throw new LoginExistsException("Já existe um cadastro usando esse login");
			}
			
			usuario.setSenha(util.md5(usuario.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			
			throw new CriptoExistsException("Erro na criptografia da senha");
			
		}
		
		usuarioRepository.save(usuario);
	}
	
	public Usuario usuarioLogin(String login, String senha) {
		Usuario usuarioLogin = usuarioRepository.buscarLogin(login, senha);
		return usuarioLogin;
	}
}
