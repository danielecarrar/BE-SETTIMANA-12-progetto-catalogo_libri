package it.epicode.catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.catalogo.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	public List<Categorie> findByGenere(String titolo);
}
