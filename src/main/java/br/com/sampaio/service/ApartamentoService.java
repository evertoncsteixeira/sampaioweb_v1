package br.com.sampaio.services;

import br.com.sampaio.model.Apartamento;
import br.com.sampaio.repositories.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    public List<Apartamento> listarTodos() {
        return apartamentoRepository.findAll();
    }

    public void salvar(Apartamento apartamento) {
        apartamentoRepository.save(apartamento);
    }

    public Apartamento buscarPorId(Long id) {
        return apartamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Apartamento não encontrado: " + id));
    }

    public void excluir(Long id) {
        apartamentoRepository.deleteById(id);
    }
}