package br.com.sampaio.controllers;

import br.com.sampaio.model.Apartamento;
import br.com.sampaio.repositories.ApartamentoRepository;
import br.com.sampaio.repositories.EdificioRepository;
import br.com.sampaio.services.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @Autowired
    private EdificioRepository edificioRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("apartamentos", apartamentoService.listarTodos());
        return "apartamento/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("apartamento", new Apartamento());
        model.addAttribute("edificios", edificioRepository.findAll());
        return "apartamento/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("apartamento") Apartamento apartamento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "apartamento/form";
        }
        apartamentoService.salvar(apartamento);
        return "redirect:/apartamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("apartamento", apartamentoService.buscarPorId(id));
        model.addAttribute("edificios", edificioRepository.findAll());
        return "apartamento/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        apartamentoService.excluir(id);
        return "redirect:/apartamentos";
    }
}