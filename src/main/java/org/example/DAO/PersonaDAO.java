package org.example.DAO;

import org.example.Evento;
import org.example.Persona;

import java.util.List;

public interface PersonaDAO {
	//metodo per il salvataggio
	void save (Persona persona);

	//metodo per recuperare una persona by id
	Persona findById(Long id);

	//metodo per cancellare un entità persona
	void deleteById(Long id);

	//trovare tutte le persone, magari con un query custom
	List<Persona> findAll();


}
