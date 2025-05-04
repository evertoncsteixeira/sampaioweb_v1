package br.com.sampaio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.sampaio.model.Anexo;
import br.com.sampaio.repositories.AnexoRepository;

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
}
