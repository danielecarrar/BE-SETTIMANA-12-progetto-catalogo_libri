package it.epicode.catalogo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autori {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;

	@ManyToMany
	@JoinTable(name = "autore_libro", joinColumns = @JoinColumn(name = "autore_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "libro_id", referencedColumnName = "id"))
	private List<Libri> libri = new ArrayList<>();

}