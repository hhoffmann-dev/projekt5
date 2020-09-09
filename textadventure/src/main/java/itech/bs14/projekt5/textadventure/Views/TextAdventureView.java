package itech.bs14.projekt5.textadventure.Views;

import java.io.IOException;
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

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component("TextAdventureView")
@Scope("session")
public class TextAdventureView {
	
	public int selectedDialogId;

	public Dialog selectedDialog;

	public Environment selectedEnvironment;

	public DialogOption option;

	public List<DialogOption> dialogOptions;

	@Autowired
	TextAdventureBean bean;

	public void loadDialog(int selectedDialogId) {

		selectedDialog = bean.loadDialog(selectedDialogId);

		// 1:1 kardinality for episode one of Laverra. For future purpose n:m

		List<Environment> envoLst = selectedDialog.getEnvironments();

		if (!envoLst.isEmpty())
			selectedEnvironment = envoLst.get(0);

		dialogOptions = selectedDialog.getDialogOptions();

	}

	public void setNewDialog(int optionId, DialogOption opt) {

		option = opt;

		selectedDialogId = bean.setNewDialogByOptionId(optionId);

		loadDialog(selectedDialogId);
	}
	
	public void continueDialog() {

		if (selectedDialog.getDialogOptions().isEmpty()) {
			int nextDialogId = bean.setNewDialogByDialogId(selectedDialog.getId());
			loadDialog(nextDialogId);
		}
	}

	public Dialog getSelectedDialog() {

		if (selectedDialog == null)
			loadDialog(selectedDialogId);

		return selectedDialog;
	}
	public void restartGame() {
		
		selectedDialogId = 0;
		selectedDialog = null;
		selectedEnvironment = null;
		option = null;
		dialogOptions = null;
		
	}
	
//	public void save() {
//		bean.writeGameprocess(selectedDialog)
//	}

	public List<DialogOption> getDialogOptions() {
		return dialogOptions;
	}

	public Environment getselectedEnvironment() {
		return selectedEnvironment;
	}
}
