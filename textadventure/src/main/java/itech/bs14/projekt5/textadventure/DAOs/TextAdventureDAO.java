package itech.bs14.projekt5.textadventure.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import itech.bs14.projekt5.textadventure.Entities.Armour;
import itech.bs14.projekt5.textadventure.Entities.Character;
import itech.bs14.projekt5.textadventure.Entities.Dialog;
import itech.bs14.projekt5.textadventure.Entities.DialogOption;
import itech.bs14.projekt5.textadventure.Entities.Environment;
import itech.bs14.projekt5.textadventure.Entities.Weapon;


@Transactional
@Component("TextAdventureDAO")
public class TextAdventureDAO {

	@PersistenceContext(unitName = "textadventurePU", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public Dialog loadDialog(int selectedDialogId) {
		
		Query query = entityManager.createQuery("SELECT m FROM Dialog m Where Id = :dialog");
		
		if (selectedDialogId != 0) {
			query.setParameter("dialog", selectedDialogId);
		}
		else {
			query.setParameter("dialog", 1);
		}

		Dialog dialog = (Dialog) query.getResultList().get(0);
		return dialog;
	}
}
