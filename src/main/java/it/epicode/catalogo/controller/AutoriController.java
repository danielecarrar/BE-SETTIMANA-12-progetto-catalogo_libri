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
import it.epicode.catalogo.model.Autori;
import it.epicode.catalogo.service.AutoriService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class AutoriController {
	
	@Autowired
	private AutoriService autoreService;
	
	@GetMapping(path = "/autori")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") // Se un SOLO ruolo : @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<Autori>> findAll() {
		List<Autori> findAll = autoreService.findAll();

		if (findAll != null) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/autore/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public ResponseEntity<Autori> findById(@PathVariable(required = true) Long id) {
		Optional<Autori> find = autoreService.findById(id);

		if (find.isPresent()) { 
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/autore")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Autori> save(@RequestBody Autori autore) {
		Autori save = autoreService.save(autore);
		log.info("Aggiunto un autore");
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PutMapping(path = "/autore/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Autori> update(@PathVariable Long id, @RequestBody Autori autore) {
		Autori save = autoreService.update(id, autore);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/autore/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		autoreService.delete(id);
		return new ResponseEntity<>("Autore rimosso!", HttpStatus.OK);

	}

}
