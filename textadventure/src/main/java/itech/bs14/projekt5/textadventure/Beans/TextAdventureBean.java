package itech.bs14.projekt5.textadventure.Beans;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import itech.bs14.projekt5.textadventure.DAOs.TextAdventureDAO;
import itech.bs14.projekt5.textadventure.Entities.Dialog;
import itech.bs14.projekt5.textadventure.Entities.SaveGame;
import itech.bs14.projekt5.textadventure.Entities.UserData;

@Component("TextAdventureBean")
@Scope("singleton")
public class TextAdventureBean {
	@Autowired
	TextAdventureDAO taDAO;

	@PostConstruct
	public void init() {

	}

	public Dialog loadDialog(int dialogId) {
		Dialog dialog = taDAO.loadDialog(dialogId);
		return dialog;

	}

	public int setNewDialogByOptionId(int optionId) {
		int dialogId = 0;
		
		switch (optionId) {
		case 1:
			dialogId = 8;
			break;
		case 2:
			dialogId = 5;
			break;
		case 4:
			dialogId = 26;
			break;
		case 5:
			dialogId = 7;
			break;
		case 6:
			dialogId = 2;
			break;
		case 7:
			dialogId = 3;
			break;
		case 8:
			dialogId = 10;
			break;
		case 9:
			dialogId = 10;
			break;
		case 10:
			dialogId = 10;
			break;
		case 11:
			dialogId = 11;
			break;
		case 12:
			dialogId = 12;
			break;
		case 13:
			dialogId = 14;
			break;
		case 14:
			dialogId = 16;
			break;
		case 15:
			dialogId = 27;
			break;
		case 16:
			dialogId = 17;
			break;
		case 17:
			dialogId = 13;
			break;
		case 18:
			dialogId = 19;
			break;
		case 19:
			dialogId = 21;
			break;
		case 20:
			dialogId = 25;
			break;
		case 21:
			dialogId = 15;
			break;
		case 22:
			dialogId = 18;
			break;
		}

		return dialogId;
	}

	public int setNewDialogByDialogId(int dialogId) {

		switch (dialogId) {
		case 2:
			dialogId = 4;
			break;
		case 3:
			dialogId = 4;
			break;
		case 7:
			dialogId = 8;
			break;
		case 8:
			dialogId = 9;
			break;
		case 11:
			dialogId = 13;
			break;
		case 12:
			dialogId = 13;
			break;
		case 15:
			dialogId = 13;
			break;
		case 19:
			dialogId = 20;
			break;
		case 20:
			dialogId = 28;
			break;
		case 21:
			dialogId = 22;
			break;
		case 22:
			dialogId = 23;
			break;
		case 23:
			dialogId = 24;
			break;
		case 24:
			dialogId = 29;
			break;
		}

		return dialogId;
	}

	public UserData checkCredentials(String user, String password) {
		UserData userAccount = taDAO.checkCredentialsWithDBEntries(user, password);
		return userAccount;
	}

	public void writeGameprocess(Dialog selectedDialog, UserData user) {
		taDAO.createSaveStage(selectedDialog, user);
		
	}

	public SaveGame readGameProcess(UserData user) {
		SaveGame saveState = taDAO.readState(user);
		return saveState;
	}

	public void createUser(String userName, String userPassword) {
		taDAO.createUser(userName, userPassword);
	}

	public boolean checkIfNameExists(String userName) {
		return taDAO.checkifNameExists(userName);
		
	}
}
