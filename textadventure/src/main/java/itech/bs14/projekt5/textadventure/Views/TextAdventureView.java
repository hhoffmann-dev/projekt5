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
import itech.bs14.projekt5.textadventure.Entities.DialogOption;
import itech.bs14.projekt5.textadventure.Entities.Environment;

@Component("TextAdventureView")
@Scope("session")
public class TextAdventureView {

	public int selectedDialogId;

	public Dialog predecessorDialog;

	public Dialog selectedDialog;
	
	public Environment selectedEnvironment;

	public DialogOption option;

	List<DialogOption> dialogOptions;

	public Map<Integer, DialogOption> reducedMapOptions;

	@Autowired
	TextAdventureBean bean;

	public void loadDialog(int selectedDialogId) {

		selectedDialog = bean.loadDialog(selectedDialogId);
		
		// 1:1 kardinality for episode one of Laverra. For future purpose n:m
		
		List<Environment> envoLst = selectedDialog.getEnvironments();
		
		if (!envoLst.isEmpty())
			selectedEnvironment = envoLst.get(0);
			

		dialogOptions = selectedDialog.getDialogOptions();

		if (!selectedDialog.getDialogOptions().isEmpty())
			predecessorDialog = selectedDialog;
	}

	public void setNewDialog(int optionId, DialogOption opt) {

		option = opt;
		
		selectedDialogId = bean.setNewDialogByOptionId(optionId);

		loadDialog(selectedDialogId);
	}

	private void reducePossibleOption(DialogOption option) {
		
		reducedMapOptions = new HashMap<Integer, DialogOption>();
		
		for ( DialogOption opt : predecessorDialog.getDialogOptions()) {
			reducedMapOptions.put(Integer.valueOf(opt.getId()), opt);
		}
		
		reducedMapOptions.remove(Integer.valueOf(option.getId()), option);
		dialogOptions = new ArrayList<DialogOption>(reducedMapOptions.values());
	}


	public void continueDialog() {
		
		if (selectedDialog.getId()==1)
			return;
		
		// For possibility an option are not heading to new dialog
		if (option.isDeadEnd()) {
			selectedDialog = predecessorDialog;
			reducePossibleOption(option);
		}
		
		// For Possibility a dialog doesn't have options to continue
		if (reducedMapOptions == null ) {
			int followDialogId = bean.setNewDialogByDialogId(selectedDialog.getId());
			loadDialog(followDialogId);
			return;
		}
		
		if (reducedMapOptions.isEmpty()) {
			int followDialogId = bean.setNewDialogByDialogId(selectedDialog.getId());
			loadDialog(followDialogId);
		}
		
		reducedMapOptions.clear();
	}
	
	public Dialog getSelectedDialog() {
		
		if (selectedDialog == null)
			loadDialog(selectedDialogId);
		
		return selectedDialog;
	}

	public List<DialogOption> getDialogOptions() {
		return dialogOptions;
	}

	public Environment getselectedEnvironment() {
		return selectedEnvironment;
	}
	
	public void restartGame () {
		
		selectedDialogId = 0;
		predecessorDialog = null;
		selectedDialog = null;
		selectedEnvironment = null;
		option = null;
		dialogOptions = null;
		reducedMapOptions = null;
		
	}
}
