package br.com.sampaio.controllers;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sampaio.exception.ServiceExc;
import br.com.sampaio.model.Edificio;
import br.com.sampaio.model.Usuario;
import br.com.sampaio.service.ServiceUsuario;
import br.com.sampaio.util.util;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("login/login");
		return mv;
	}
	
	@GetMapping("cadastroLogin")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("login/cadastro");
		return mv;
	}
	
	@PostMapping("cadastrarUsuario")
	public ModelAndView cadastrarUsuario(Usuario usuario) throws Exception {
			ModelAndView mv = new ModelAndView();
			serviceUsuario.cadastrarUsuario(usuario);
			mv.setViewName("redirect:/index");
			return mv;	
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc {
			ModelAndView mv = new ModelAndView();
			mv.addObject("usuario", new Usuario());
			if(br.hasErrors()) {
				mv.setViewName("login/login");
			}
			Usuario usuarioLogin = serviceUsuario.usuarioLogin(usuario.getLogin(), util.md5(usuario.getSenha()));
			if(usuarioLogin == null) {
				mv.addObject("msg","Usuario não encontrado.");
			} else {
				session.setAttribute("usuarioLogado", usuarioLogin);
				return index();	 
			}
			mv.setViewName("login/login");
			return mv;
		
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("edificio",new Edificio());
		return mv;
	}
	
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();	
	}
}
