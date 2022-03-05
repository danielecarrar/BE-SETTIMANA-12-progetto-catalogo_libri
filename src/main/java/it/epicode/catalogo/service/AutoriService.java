package it.epicode.catalogo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.catalogo.exception.CatalogoException;
import it.epicode.catalogo.model.Autori;
import it.epicode.catalogo.repository.AutoriRepository;

@Service
public class AutoriService {

	@Autowired
	AutoriRepository autoriRepo;
	
	public Autori save(Autori autore) {
		return autoriRepo.save(autore);
	}

	public Optional<Autori> findById(Long id) {
		return autoriRepo.findById(id);
	}

	public List<Autori> findByNome(String nome) {
		return autoriRepo.findByNome(nome);
	}

	public List<Autori> findAll() {
		return autoriRepo.findAll();
	}

	public void delete(Long id) {
		autoriRepo.deleteById(id);
	}

	public Autori update(Long id, Autori autore) {
		Optional<Autori> autResult = autoriRepo.findById(id);

		if (autResult.isPresent()) {
			Autori autUpdate = autResult.get();
			autUpdate.setLibri(autore.getLibri());
			autUpdate.setNome(autore.getNome());
			autUpdate.setCognome(autore.getCognome());
			autoriRepo.save(autUpdate);
			return autUpdate;
		} else {
			throw new CatalogoException("Autore non aggiornato! Controlla e riprova");
		}
	}
}