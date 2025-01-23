package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "persona")
	private Persona persona;
	@ManyToOne
	@JoinColumn(name = "evento")
	private Evento evento;
	private String stato;

	public Partecipazione(String stato, Evento evento, Persona persona) {
		this.stato = stato;
		this.evento = evento;
		this.persona = persona;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Partecipazione{" +
				  "id=" + id +
				  ", persona=" + persona +
				  ", evento=" + evento +
				  ", stato='" + stato + '\'' +
				  '}';
	}
}

