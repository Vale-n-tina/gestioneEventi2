package org.example;

import jakarta.persistence.EntityManager;
import org.example.DAO.EventoDAO;
import org.example.DAO.EventoDAOImpl;

import java.time.LocalDate;


public class Main {
	public static void main(String[] args) {
  /*
		Evento evento1 = new Evento(LocalDate.of(1982, 10, 04), 100, "privato", "muccaAssasina", "fantastico");

		//Mi creo un'istanza di DAO
		EventoDAO EventoDao = new EventoDAOImpl();

		//caso 1 debbo salvare una persona nel db
		EventoDao.save(evento1);
		System.out.println("Persona salvata! ID: " + evento1.getId());


		//caso 3: find by id (PK)
		Evento eventoDaTrovare = EventoDao.findById(evento1.getId());

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

*/
		EventoDAO EventoDao = new EventoDAOImpl();


		Persona valentina = new Persona("f", LocalDate.of(2000, 03, 10), "valentina.gmail.com", "gar", "nome");
		Evento eventoMucca = new Evento(LocalDate.of(2025, 06, 20), 100, "pubblico", "spazio", "bello");
		Partecipazione partecipazione1 = new Partecipazione("confermato", eventoMucca, valentina);
		valentina.addPArtecipazioni(partecipazione1);
		System.out.println("partecipazioni di valentina: " + valentina.getListaPartecipazioni());

		EntityManager en=EntityManagerUtil.getEntityManager();



	}
}