package br.com.sampaio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sampaio.model.Anexo;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {
    List<Anexo> findByIdEdificio(Long idEdificio);
    List<Anexo> findByAnoAndMes(Integer ano, Integer mes);
    List<Anexo> findByIdEdificioAndAnoAndMes(Long idEdificio, Integer ano, Integer mes);
    List<Anexo> findByTipo(String tipo);
}