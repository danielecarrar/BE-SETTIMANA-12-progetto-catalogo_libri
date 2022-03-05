package it.epicode.catalogo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.catalogo.exception.CatalogoException;
import it.epicode.catalogo.model.Libri;
import it.epicode.catalogo.repository.LibriRepository;

@Service
@Transactional
public class LibriService {

	@Autowired
	LibriRepository libriRepo;

	public Optional<Libri> findById(Long id) {
		return libriRepo.findById(id);
	}

	public List<Libri> findAll() {
		return libriRepo.findAll();
	}

	public void delete(Long id) {
		libriRepo.deleteById(id);
	}

	public Libri update(Long id, Libri libro) {
		Optional<Libri> trovatoLibro = libriRepo.findById(id);

		if (trovatoLibro.isPresent()) {
			Libri newLibro = trovatoLibro.get();
			newLibro.setTitolo(libro.getTitolo());
			newLibro.setPrezzo(libro.getPrezzo());
			newLibro.setAutori(libro.getAutori());
			newLibro.setAnno(libro.getAnno());
			newLibro.setCategorie(libro.getCategorie());
			libriRepo.save(newLibro);
			return newLibro;
		} else {
			throw new CatalogoException("Errore! Il libro non è stato aggiornato!");
		}

	}

	public List<Libri> findByTitolo(String titolo) {
		return libriRepo.findByTitolo(titolo);
	}

	public Libri save(Libri libro) {
		return libriRepo.save(libro);
	}
}
