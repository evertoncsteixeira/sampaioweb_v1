package br.com.sampaio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sampaio.model.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}