package org.example;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cognome;
	private String email;
	@Column(name = "data_nascita")
	private LocalDate dataNascita;
	private String sesso;
	@Column(name = "lista_partecipazioni")
	private List<Partecipazioni> listaPartecipazioni = new ArrayList<>();

	public Persona(){

	}

	public Persona(List<Partecipazioni> listaPartecipazioni, String sesso, LocalDate dataNascita, String email, String cognome, String nome) {
		this.listaPartecipazioni = listaPartecipazioni;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.email = email;
		this.cognome = cognome;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Partecipazioni> getListaPartecipazioni() {
		return listaPartecipazioni;
	}

	public void setListaPartecipazioni(List<Partecipazioni> listaPartecipazioni) {
		this.listaPartecipazioni = listaPartecipazioni;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
