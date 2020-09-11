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
import itech.bs14.projekt5.textadventure.Entities.SaveGame;
import itech.bs14.projekt5.textadventure.Entities.UserData;

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

	public int selectedDialogId = 1;

	public Dialog selectedDialog;

	public Environment selectedEnvironment;

	public DialogOption option;

	public List<DialogOption> dialogOptions;

	@Autowired
	TextAdventureBean bean;

	@Autowired
	LoginView loginView;

	public void loadDialog(int selectedDialogId) {

		selectedDialog = bean.loadDialog(selectedDialogId);

		List<Environment> envoLst = null;
		// 1:1 kardinality for episode one of Laverra. For future purpose n:m

		try {
			envoLst = selectedDialog.getEnvironments();
		} catch (NullPointerException ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Kein Dialog vorhanden", "Bitt kontaktieren Sie den Administrator"));
		}

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

	public void restartGame() {

		selectedDialogId = 1;
		selectedDialog = null;
		selectedEnvironment = null;
		option = null;
		dialogOptions = null;

	}

	public void save() {
		UserData user = loginView.getCurrentUser();

		bean.writeGameprocess(selectedDialog, user);
	}

	public void loadSaving() {
		UserData user = loginView.getCurrentUser();

		if (user == null)
			return;

		SaveGame saveState = bean.readGameProcess(user);
		loadDialog(saveState.getDialogId());
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
}
