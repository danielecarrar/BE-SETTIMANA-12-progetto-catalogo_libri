package it.epicode.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.catalogo.exception.CatalogoException;
import it.epicode.catalogo.model.Categorie;
import it.epicode.catalogo.repository.CategorieRepository;

@Service
public class CategorieService {

	@Autowired
	CategorieRepository catRepo;

	public Optional<Categorie> findById(Long id) {
		return catRepo.findById(id);
	}


	public List<Categorie> findAll() {
		return catRepo.findAll();
	}

	public void delete(Long id) {
		catRepo.deleteById(id);
	}

	public Categorie update(Long id, Categorie categoria) {
		Optional<Categorie> catResult = catRepo.findById(id);

		if (catResult.isPresent()) {
			Categorie catUpdate = catResult.get();
			catUpdate.setId(categoria.getId());
			catUpdate.setGenere(categoria.getGenere());
			catUpdate.setLibri(categoria.getLibri());
			catRepo.save(catUpdate);
			return catUpdate;
		} else {
			throw new CatalogoException("Categoria non aggiornata! Riprova");
		}
	}


	public Categorie save(Categorie categoria) {
		return catRepo.save(categoria);
	}


}
