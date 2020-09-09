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
import itech.bs14.projekt5.textadventure.Entities.SaveGame;
import itech.bs14.projekt5.textadventure.Entities.UserData;
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
		} else {
			query.setParameter("dialog", 1);
		}

		Dialog dialog = (Dialog) query.getResultList().get(0);
		return dialog;
	}

	public UserData checkCredentialsWithDBEntries(String user, String password) {
		Query query = entityManager.createQuery("SELECT m FROM UserData m Where name = :name AND password = :password");

		query.setParameter("name", user);
		query.setParameter("password", password);

		if (query.getResultList().isEmpty())
			return null;

		UserData userAccount = (UserData) query.getResultList().get(0);

		return userAccount;

	}

	public void saveStage(Dialog selectedDialog, UserData user) {
		SaveGame game = new SaveGame();
		game.setDialogId(selectedDialog.getId());
		game.setUserId(user.getId());
		entityManager.merge(game);
	}

	public SaveGame readState(UserData user) {
		Query query = entityManager.createQuery("SELECT m FROM SaveGame m Where userId = :userId");

		query.setParameter("userId", Integer.valueOf(user.getId()));

		if (query.getResultList().isEmpty())
			return null;

		SaveGame saveState = (SaveGame) query.getResultList().get(0);

		return saveState;
	}
}
