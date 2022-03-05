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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.epicode.catalogo.model.Libri;
import it.epicode.catalogo.service.LibriService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class LibriController {

	@Autowired
	private LibriService libserv;

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	@GetMapping("/libri")
	public ResponseEntity<List<Libri>> findAll() {
		List<Libri> findAllLibri = libserv.findAll();

		if (findAllLibri != null) {
			return new ResponseEntity<>(findAllLibri, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/libro/{id}")
	public ResponseEntity<Libri> findById(@PathVariable Long id){
		Optional<Libri> libro = libserv.findById(id);
		
		if(libro.isPresent()) {
			return new ResponseEntity<>(libro.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/libro/{id}")
	public ResponseEntity<String> deleteLibro(@PathVariable Long id){
		if(libserv.findById(id).isEmpty()) {
			return new ResponseEntity<>("Eccezione! il libro non esiste! Ritenta", HttpStatus.NOT_ACCEPTABLE);
		}
		libserv.delete(id);
		return new ResponseEntity<>("Il Libro con id specificato è stato eliminato!", HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/libro")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Libri> save(@RequestBody Libri libri) {
		
		Libri save = libserv.save(libri);
		
		log.info(libri.toString());
		
		return new ResponseEntity<>(save, HttpStatus.OK);

	}
	

	
	
	
}
