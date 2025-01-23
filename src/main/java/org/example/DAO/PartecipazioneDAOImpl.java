package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.EntityManagerUtil;
import org.example.Partecipazione;

import java.util.List;

public class PartecipazioneDAOImpl implements PartecipazioneDAO {


	@Override
	public void save(Partecipazione partecipazione) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {

			em.getTransaction().begin();
			em.persist(partecipazione);

			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public Partecipazione findById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Partecipazione partecipazioneTrovata = em.find(Partecipazione.class, id);
			em.getTransaction().commit();
			return  partecipazioneTrovata ;
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			Partecipazione partecipazioneTrovata= em.find(Partecipazione.class, id);
			if (partecipazioneTrovata != null)
				em.remove(partecipazioneTrovata);

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Partecipazione> findAll() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try {
			return em.createQuery("SELECT * FROM Partecipazione ", Partecipazione.class).getResultList();

		} finally {
			em.close();
		}
	}
	}

