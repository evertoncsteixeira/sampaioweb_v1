package br.com.sampaio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.sampaio.model.Anexo;
import br.com.sampaio.model.Edificio;
import br.com.sampaio.repositories.AnexoRepository;
import br.com.sampaio.repositories.EdificioRepository;
import br.com.sampaio.service.AnexoService;

@Controller
public class AnexoController {

    @Autowired
    private AnexoService anexoService;

    @Autowired
    private AnexoRepository anexoRepository; // Adicionada a anotação @Autowired

    
    @Autowired
    private EdificioRepository edificioRepository;

    @GetMapping("/anexo/upload")
    public String exibirFormularioUpload(Model model) {
        List<Edificio> edificios = edificioRepository.findAll();
        model.addAttribute("edificios", edificios);
        return "anexo/upload";
    }

    @PostMapping("/anexo/upload")
    public String processarUpload(MultipartFile arquivo, Long idEdificio, Integer ano, Integer mes, String tipo, Model model) {
        try {
            anexoService.gravarAnexoComDetalhes(arquivo, idEdificio, ano, mes, tipo);
            model.addAttribute("mensagem", "Arquivo enviado com sucesso!");
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro ao enviar o arquivo: " + e.getMessage());
        }
        return "anexo/upload";
    }

    @GetMapping("/anexo/download")
    @Transactional(readOnly = true)
    public String listarAnexos(
            @RequestParam(required = false) Long idEdificio,
            @RequestParam(required = false) Integer ano,
            @RequestParam(required = false) Integer mes,
            Model model) {

        // Busca todos os edifícios para preencher o select
        List<Edificio> edificios = edificioRepository.findAll();
        model.addAttribute("edificios", edificios);

        // Busca os anexos com base nos filtros fornecidos
        List<Anexo> anexos;
        if (idEdificio != null && ano != null && mes != null) {
            anexos = anexoRepository.findByIdEdificioAndAnoAndMes(idEdificio, ano, mes);
        } else if (idEdificio != null) {
            anexos = anexoRepository.findByIdEdificio(idEdificio);
        } else if (ano != null && mes != null) {
            anexos = anexoRepository.findByAnoAndMes(ano, mes);
        } else {
            anexos = anexoRepository.findAll();
        }
        model.addAttribute("anexos", anexos);

        return "anexo/download";
    }

    @GetMapping("/anexo/download/{id}")
    public ResponseEntity<ByteArrayResource> baixarAnexo(@PathVariable Long id) {
        Anexo anexo = anexoRepository.findById(id).orElseThrow(() -> new RuntimeException("Anexo não encontrado"));
        ByteArrayResource resource = new ByteArrayResource(anexo.getConteudo());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + anexo.getNomeOriginal() + "\"")
                .contentType(org.springframework.http.MediaType.parseMediaType(anexo.getTipoMime()))
                .body(resource);
    }
}