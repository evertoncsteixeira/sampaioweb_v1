package br.com.sampaio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sampaio.model.Edificio;

public interface EdificioDao extends JpaRepository<Edificio, Long> {
	
	@Query("select a from Edificio a where a.uf = 'SP' ")
	public List<Edificio> findByUfSP();
	
	public List<Edificio> findByNomeContainingIgnoreCase(String nome);
}
