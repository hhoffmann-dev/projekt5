package itech.bs14.projekt5.textadventure.Views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import itech.bs14.projekt5.textadventure.Beans.TextAdventureBean;
import itech.bs14.projekt5.textadventure.Entities.Dialog;

@Component("TextAdventureView")
@Scope("session")
public class TextAdventureView {
	
	public int selectedDialogId;
	
	public Dialog selectedDialog;
	
	@Autowired
	TextAdventureBean bean;
	
	public void loadDialog(int selectedDialogId) {
		
		selectedDialog = bean.loadDialog(selectedDialogId);
	}
	
	public void setNewDialog(int optionId) {
		selectedDialogId  = bean.setNewDialog(optionId);
		
		loadDialog(selectedDialogId);
	}

	public Dialog getSelectedDialog() {
		
		if (selectedDialog == null)
			loadDialog(selectedDialogId);
		
		
		return selectedDialog;
	}
	
}
