package br.com.sampaio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.com.sampaio.dao.EdificioDao;
import br.com.sampaio.model.Edificio;

@Controller
public class EdificioController {
	
	@Autowired
	private EdificioDao edificioRepository;
	
	@GetMapping("/inserirEdificios")
	public String exibirFormularioCadastro(Model model) {
		model.addAttribute("edificio", new Edificio());
		return "edificio/formEdificio";
	}
	
	@PostMapping("/insertEdificio")
	public String salvarEdificio(@ModelAttribute("edificio") Edificio edificio, BindingResult result, Model model) {
    	if (result.hasErrors()) {
        	return "edificio/formEdificio";
    	}

    	// Salve o objeto no banco de dados
    	edificioRepository.save(edificio);
    	return "redirect:/edificios-adicionados";
	}

	
	@GetMapping("edificios-adicionados")
	public ModelAndView listagemEdificios(Edificio edificio) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edificio/listEdificios");
		mv.addObject("edificioList", edificioRepository.findAll());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edificio/alterar");
		Edificio edificio = edificioRepository.getOne(id);
		mv.addObject("edificio", edificio);
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Edificio edificio) {
		ModelAndView mv = new ModelAndView();
		edificioRepository.save(edificio);
		mv.setViewName("redirect:/edificios-adicionados");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirEdificio(@PathVariable("id") Long id) {
		edificioRepository.deleteById(id);
		return "redirect:/edificios-adicionados";
	}
	
	@GetMapping("filtro-edificios")
	public ModelAndView filtroEdificios(Edificio edificio) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edificio/filtroEdificios");
		return mv;
	}
	
	@GetMapping("edificios-sp")
	public ModelAndView listagemEdificiosSP(Edificio edificio) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edificio/edificios-SP");
		mv.addObject("edificioSP", edificioRepository.findByUfSP());
		return mv;
	}
	
	@PostMapping("pesquisar-edificio")
	public ModelAndView pesquisarEdificio(@RequestParam(required = false) String nome) {
		ModelAndView mv = new ModelAndView();
		List<Edificio> listaEdificio;
		if(nome == null || nome.trim().isEmpty()) {
			listaEdificio = edificioRepository.findAll();
		} else {
			listaEdificio = edificioRepository.findByNomeContainingIgnoreCase(nome);
		};
		mv.addObject("ListaDeEdificio", listaEdificio);
		mv.setViewName("edificio/pesquisa-resultado");
		return mv;
	}
}
