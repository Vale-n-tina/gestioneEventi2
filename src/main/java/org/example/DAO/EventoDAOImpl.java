package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerUtil;
import org.example.Evento;

import java.util.List;

public class EventoDAOImpl implements EventoDAO {
	@Override
	public void save(Evento evento) {

		EntityManager em = EntityManagerUtil.getEntityManager();
		try {

			em.getTransaction().begin();
			em.persist(evento);

			em.getTransaction().commit();

		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}

	@Override
	public Evento findById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Evento eventoTrovato = em.find(Evento.class,id);
			em.getTransaction().commit();
			return eventoTrovato;
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
		}
	}

	@Override
	public void deleteById(Long id) {
		//entity manager
		EntityManager em = EntityManagerUtil.getEntityManager();
		//try catch
		try {
			em.getTransaction().begin();
			//Evento evento = findById(id);
			Evento evento = em.find(Evento.class,id);
			if(evento!=null)
				em.remove(evento);

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}

	}

	@Override
	public List<Evento> findAll() {
		EntityManager em = EntityManagerUtil.getEntityManager();

		/*
		 *
		 * eseguiamo una query custom sul db, e la restituisce come una List
		 */
		try {
			// return em.createQuery("SELECT * FROM studenti ",Persona.class).getResultList();
			return em.createQuery("SELECT * FROM studenti WHERE cognome = :cognome", Evento.class)
					  .setParameter("cognome", "Morabito").getResultList();
		}
		finally {
			em.close();
		}

	}


}
