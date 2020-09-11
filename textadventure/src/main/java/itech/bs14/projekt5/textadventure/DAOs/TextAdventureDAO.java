package itech.bs14.projekt5.textadventure.DAOs;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
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

@Scope("singleton")
@Transactional
@Component("TextAdventureDAO")
public class TextAdventureDAO {

	@PersistenceContext(unitName = "textadventurePU", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public Dialog loadDialog(int selectedDialogId) {
		
		Dialog dialog = null;

		Query query = entityManager.createQuery("SELECT m FROM Dialog m Where Id = :dialog");

			query.setParameter("dialog", selectedDialogId);
			
			try {
				dialog = (Dialog) query.getResultList().get(0);
			}catch(NullPointerException ex) {
				return null;
			}
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

	public void createSaveStage(Dialog selectedDialog, UserData user) {
		SaveGame game = new SaveGame();
		game.setUserId(user.getId());
		
		
		// If create User initial save state entry for database
		if(selectedDialog == null) {
			game.setDialogId(1);
		}
		else
		{
			game.setDialogId(selectedDialog.getId());
		}
		

		Query query = entityManager.createQuery("SELECT m FROM SaveGame m Where userId = :userId");

		query.setParameter("userId", Integer.valueOf(user.getId()));

		if (query.getResultList().isEmpty()) {
			entityManager.merge(game);
			return;
		}
		// For update save state of already existing account

		SaveGame savedGame = (SaveGame) query.getResultList().get(0);

		game.setId(savedGame.getId());

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

	public void createUser(String userName, String userPassword) {
		UserData user = new UserData();
		user.setName(userName);
		user.setPassword(userPassword);
		entityManager.merge(user);
		
		Query query = entityManager.createQuery("SELECT m FROM UserData m Where name = :name AND password = :password");

		query.setParameter("name", userName);
		query.setParameter("password", userPassword);

		
		//@GeneratedValue annotation only generate id in database not in java object so select database user id and set it 
		UserData userAccount = (UserData) query.getResultList().get(0);
		
		user.setId(userAccount.getId());
		
		//Set initial saveState to 1
		createSaveStage(null , user);
		
	}

	public boolean checkifNameExists(String userName) {
		Query query = entityManager.createQuery("SELECT m FROM UserData m Where name = :name");

		query.setParameter("name", userName);
		
		if (query.getResultList().isEmpty())
			return false;
		
		return true;
	}
}
