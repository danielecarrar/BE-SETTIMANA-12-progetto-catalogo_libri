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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Libri {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	private String titolo;
	private int anno;
	private double prezzo;

	@ManyToMany // piu libri possono avere piu autori
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JoinTable(name = "libri_autori", joinColumns = @JoinColumn(name = "id_libro", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_autore", referencedColumnName = "id"))
	private List<Autori> autori = new ArrayList<>();

	@ManyToMany
	// piu libri possono avere piu categorie
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JoinTable(name = "libri_categorie", joinColumns = @JoinColumn(name = "id_libro", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
	private List<Categorie> categorie = new ArrayList<>();

}
