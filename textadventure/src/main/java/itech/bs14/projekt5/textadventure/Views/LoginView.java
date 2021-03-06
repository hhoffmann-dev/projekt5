package itech.bs14.projekt5.textadventure.Views;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import itech.bs14.projekt5.textadventure.Beans.TextAdventureBean;
import itech.bs14.projekt5.textadventure.Entities.UserData;

@Component("LoginView")
@Scope("session")
public class LoginView   {
	
	@Autowired TextAdventureBean bean;

	public static final String GAME_PAGE_REDIRECT = "secured/GameUI.xhtml?faces-redirect=true";

	public static final String HOME_PAGE_REDIRECT = "/Login.xhtml?faces-redirect=true";

	public String userName;
	public String userPassword;

	private UserData currentUser = null;

	public String login() {
		// lookup the user based on user name and user password
		
		currentUser = bean.checkCredentials(userName, userPassword);
		if (currentUser != null) {
			
			return GAME_PAGE_REDIRECT;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Login fehlgeschlagen", "Ung�ltige Eingabedaten!"));

			return null;
		}
	}
	
	public String logout() {
		// invalidate the session
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		currentUser = null;
		
		return HOME_PAGE_REDIRECT;
	}
	
	public void createUser() {
		
		boolean nameExists = bean.checkIfNameExists(userName);
		
		if (nameExists) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Benutzername bereits vergeben!",
							"Benutzername bereits vergeben! Bitte w�hlen Sie einen anderen Namen!"));
			return;
		}
			
		bean.createUser(userName, userPassword);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Benutzer erstellt", "Benutzer erfolgreich erstellt"));
		
	}
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	public String checkIfLoggedIn() {
		if (isLoggedIn())
			return GAME_PAGE_REDIRECT;
				
		return null;
	}

	public UserData getCurrentUser() {
		return currentUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
