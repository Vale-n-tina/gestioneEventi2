package org.example.DAO;
import java.util.List;
import org.example.Evento;

public interface EventoDAO {
	//metodo per il salvataggio
	void save (Evento evento);

	//metodo per recuperare una persona by id
	Evento findById(Long id);

	//metodo per cancellare un entità   PErsona
	void deleteById(Long id);

	//trovare tutte le persone, magari con un query custom
	List<Evento> findAll();


}
