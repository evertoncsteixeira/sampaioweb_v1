package br.com.sampaio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.sampaio.model.Anexo;
import br.com.sampaio.repositories.AnexoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository anexoRepository;

    public void gravarAnexo(MultipartFile arquivo) throws Exception {
        Anexo anexo = new Anexo();
        anexo.setNomeOriginal(arquivo.getOriginalFilename());
        anexo.setTipoMime(arquivo.getContentType());
        anexo.setTamanho(arquivo.getSize());
        anexo.setConteudo(arquivo.getBytes());
        anexoRepository.save(anexo);
    }
    
    @Transactional
    public void gravarAnexoComDetalhes(MultipartFile arquivo, Long idEdificio, Integer ano, Integer mes, String tipo) throws Exception {
        Anexo anexo = new Anexo();
        anexo.setNomeOriginal(arquivo.getOriginalFilename());
        anexo.setTipoMime(arquivo.getContentType());
        anexo.setTamanho(arquivo.getSize());
        anexo.setConteudo(arquivo.getBytes());
        anexo.setIdEdificio(idEdificio);
        anexo.setAno(ano);
        anexo.setMes(mes);
        anexo.setTipo(tipo);

        anexoRepository.save(anexo);
    }

    @Transactional(readOnly = true)
    public List<Anexo> buscarAnexosPorEdificio(Long idEdificio) {
        return anexoRepository.findByIdEdificio(idEdificio);
    }
}
