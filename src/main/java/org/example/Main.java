package org.example;

import org.example.DAO.EventoDAO;
import org.example.DAO.EventoDAOImpl;

import java.time.LocalDate;


public class Main {
	public static void main(String[] args) {

		Evento evento1 = new Evento(LocalDate.of(1982, 10, 04), 100, "privato", "muccaAssasina", "fantastico");

		//Mi creo un'istanza di DAO
		EventoDAO EventoDao = new EventoDAOImpl();

		//caso 1 debbo salvare una persona nel db

		EventoDao.save(evento1);
		System.out.println("Persona salvata! ID: " + evento1.getId());

		//caso 2: update
		//evento1.setTitolo("disco");
		//EventoDao.save(evento1);

		//caso 3: find by id (PK)
		Evento eventoDaTrovare = EventoDao.findById(evento1.getId());
		//scenario 1: ha trovato la persona
		//scenario 2: non l ha trovata, quindi abbiamo NULL
		if (eventoDaTrovare != null)
			System.out.println("Evento trovato, Titolo: " + eventoDaTrovare.getTitolo());
		else {
			System.out.println("Id non trovato");
		}

		//caso 4: delete
		EventoDao.deleteById(evento1.getId());
		Evento eventoEliminato = EventoDao.findById(evento1.getId());

		if (eventoEliminato == null) {
			System.out.println("Evento eliminato con successo!");
		} else {
			System.out.println("Errore: l'evento non è stato eliminato.");
		}


		//caso 5:
		/*
		 * ho implementato le relazioni, provo a salvare una persona che ha più numeri di telefono
		 *


		Persona niccolo = new Persona("Niccolò", "Albanese",LocalDate.of(1990,7,24));
		niccolo.addTelefono(new Telefono("3280000000"));
		niccolo.addTelefono(new Telefono("3350000000"));
		//save, grazie alla relazione definita, salverà lo studente e i suoi telefoni
		//"gestendo" le pk e fk
		personaDAO.save(niccolo);

		Persona personaTrovata = personaDAO.findById(niccolo.getId());
		if (personaTrovata!= null) {
			System.out.println("Persona trovata");
			personaTrovata.getTelefoni().forEach( telefono ->
					  System.out.println("Telefono : " + telefono.getNumero())
			);
		}
        */


	}
}