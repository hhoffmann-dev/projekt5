package itech.bs14.projekt5.textadventure.Beans;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import itech.bs14.projekt5.textadventure.DAOs.TextAdventureDAO;
import itech.bs14.projekt5.textadventure.Entities.Dialog;

@Component("TextAdventureBean")
@Scope("singleton")
public class TextAdventureBean {
	@Autowired
	TextAdventureDAO taDAO;

	@PostConstruct
	public void init() {

	}

	public Dialog loadDialog(int DialogId) {
		Dialog dialog = taDAO.loadDialog(DialogId);
		return dialog;

	}

	public int setNewDialog(int optionId) {
		int dialogId = 0;
		if (optionId == 1) {
			dialogId = 2;
		}
		return dialogId;
		
	}
}
