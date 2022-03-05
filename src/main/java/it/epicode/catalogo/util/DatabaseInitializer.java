package it.epicode.catalogo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.catalogo.model.Autori;
import it.epicode.catalogo.model.Categorie;
import it.epicode.catalogo.model.Libri;
import it.epicode.catalogo.repository.AutoriRepository;
import it.epicode.catalogo.repository.CategorieRepository;
import it.epicode.catalogo.repository.LibriRepository;
import lombok.extern.slf4j.Slf4j;

//questa classe inserisce i primi dati di esempio nel database

@Component
@Slf4j
public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	private LibriRepository libriRepo;

	@Autowired
	private AutoriRepository autoriRepo;

	@Autowired
	private CategorieRepository categorieRepo;

	@Override
	public void run(String... args) throws Exception {
		List<Categorie> categorie = initCategoria();
		List<Autori> autori = initAutore();
		initLibro(autori, categorie);
		log.info("Dati iniziali inseriti!");
	}

	/**
	 * 
	 * @param autori    set di autori ottenuto con metodo sottostante
	 * @param categorie set categorie ottenuto con metodo sottostante
	 */
	private void initLibro(List<Autori> autori, List<Categorie> categorie) {
		log.info("creazione libro...OK");
		Libri l1 = new Libri();

		l1.setTitolo("Later");
		l1.setAutori(autori);
		l1.setPrezzo(9.90);
		l1.setAnno(2020);
		l1.setCategorie(categorie);

		libriRepo.save(l1);
	}

	/**
	 * 
	 * @return una lista di autori da utilizzare poi nei libri
	 */
	private List<Autori> initAutore() {
		log.info("creazione autori...OK");
		Autori a1 = new Autori();
		a1.setNome("Stephen");
		a1.setCognome("King");
		Autori a2 = new Autori();
		a2.setNome("Sandra");
		a2.setCognome("Malloni");
		List<Autori> autori = new ArrayList<>();
		autori.add(a1);
		autori.add(a2);

		autoriRepo.saveAll(autori);

		return autori;
	}

	/**
	 * 
	 * @return una lista di categorie da utilizzare poi per i libri
	 */
	private List<Categorie> initCategoria() {
		log.info("creazione categorie...OK");
		List<Categorie> categorie = new ArrayList<>();
		Categorie c1 = new Categorie();
		c1.setGenere("Thriller");
		Categorie c2 = new Categorie();
		c2.setGenere("Azione");
		categorie.add(c1);
		categorie.add(c2);

		categorieRepo.saveAll(categorie);

		return categorie;
	}
}