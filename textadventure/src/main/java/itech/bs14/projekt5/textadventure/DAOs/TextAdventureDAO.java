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
	public void listAll() {
		Query query = entityManager.createQuery("SELECT m FROM Character m");
		List<Character> ch = query.getResultList();
		
		for (Character c : ch) {
			for (Armour a : c.getArmours()) {
				System.out.print("Armour:");
				System.out.println(a.getName());
			}
		}
		
		for (Character c : ch) {
			for (Dialog d : c.getDialog()) {
				System.out.print("Dialog:");
				System.out.println(d.getDialogText());
			}
		}
		
		for (Character c : ch) {
			for (Weapon w : c.getWeapons()) {
				System.out.print("Weapon: ");
				System.out.println(w.getWeaponName());
			}
		}
		
		Query query2 = entityManager.createQuery("SELECT m FROM Dialog m");
		List<Dialog> ds = query2.getResultList();
		
		for (Dialog d : ds) {
			for (DialogOption do1 : d.getDialogoptions() ) {
				System.out.print("Dialogoption: ");
				System.out.println(do1.getDialogText());
			}
		}
		
		for (Dialog d : ds) {
			for (Environment env : d.getEnvironments() ) {
				System.out.print("Environment: ");
				System.out.println(env.getEnvironmentName());
			}
		}
		
	}
}
