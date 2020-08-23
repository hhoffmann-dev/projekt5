package itech.bs14.projekt5.textadventure.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Dialog")
public class Dialog {
	
		@Id
		@Column(name = "idDialog")
		private int idDialog;

		@Column(name = "Text")
		private String dialogText;

		@ManyToMany(mappedBy = "dialogTexts")
		private List<Character> characters = new ArrayList<Character>();
		
		  @ManyToMany(cascade = { CascadeType.ALL })
		    @JoinTable(
		        name = "EnvironmentHasDialog", 
		        joinColumns = { @JoinColumn(name = "idDialog") }, 
		        inverseJoinColumns = { @JoinColumn(name = "idEnvironment") }
		    )
		  private List<Environment> environments = new ArrayList<Environment>();

		  
		  
		public int getIdDialog() {
			return idDialog;
		}

		public void setIdDialog(int idDialog) {
			this.idDialog = idDialog;
		}

		public String getDialogText() {
			return dialogText;
		}

		public void setDialogText(String dialogText) {
			this.dialogText = dialogText;
		}

		public List<Character> getCharacters() {
			return characters;
		}

		public void setCharacters(List<Character> characters) {
			this.characters = characters;
		}

		public List<Environment> getEnvironments() {
			return environments;
		}

		public void setEnvironments(List<Environment> environments) {
			this.environments = environments;
		}
}
