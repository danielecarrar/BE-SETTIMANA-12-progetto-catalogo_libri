package it.epicode.catalogo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.epicode.catalogo.model.Categorie;
import it.epicode.catalogo.service.CategorieService;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class CategorieController {
	
	@Autowired
	private CategorieService categoriaService;

	@GetMapping(path = "/categorie")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") // Se un SOLO ruolo : @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<Categorie>> findAll() {
		List<Categorie> findAll = categoriaService.findAll();

		if (findAll != null) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/categoria/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") // required per renderlo obbligatorio
	public ResponseEntity<Categorie> findById(@PathVariable(required = true) Long id) {
		Optional<Categorie> find = categoriaService.findById(id);

		if (find.isPresent()) {
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/categoria")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Categorie> save(@RequestBody Categorie categoria) {
		Categorie save = categoriaService.save(categoria);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PutMapping(path = "/categoria/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Categorie> update(@PathVariable Long id, @RequestBody Categorie categoria) {
		Categorie save = categoriaService.update(id, categoria);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/categoria/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		categoriaService.delete(id);
		return new ResponseEntity<>("Categoria rimossa", HttpStatus.OK);

	}

}