package br.com.sampaio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sampaio.model.Anexo;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {
}