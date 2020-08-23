package itech.bs14.projekt5.textadventure.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("TextAdventureDAO")
public class TextAdventureDAO {

	@PersistenceContext(unitName = "textadventurePU", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public void listIncome() {
		Query query = entityManager.createQuery("SELECT m FROM Income m");
	}
}
