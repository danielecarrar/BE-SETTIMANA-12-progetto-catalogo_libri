package it.epicode.catalogo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.catalogo.model.Autori;

public interface AutoriRepository extends JpaRepository<Autori, Long> {

	public Optional<Autori> findById(Integer id);

	public Optional<Autori> findByCognome(String cognome);

	List<Autori> findByNome(String nome);
}
