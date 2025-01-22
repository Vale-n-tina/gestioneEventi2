package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name = "id")
	private Persona persona;
	@JoinColumn(name = "id")
	private Evento evento;

}
