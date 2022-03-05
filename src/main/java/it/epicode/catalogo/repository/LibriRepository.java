package it.epicode.catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.catalogo.model.Libri;

//crudRepository NON ha la capacità di effettuare paging and sorting
public interface LibriRepository extends JpaRepository<Libri, Long> {

	public List<Libri> findByTitolo(String titolo);
}
