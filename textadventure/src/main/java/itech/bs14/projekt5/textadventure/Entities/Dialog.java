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
@Table(name = "`dialog`")
public class Dialog {

	@Id
	@Column(name = "Id")
	private int Id;

	@Column(name = "Text")
	private String dialogText;
	
	
	// n:m relations from Database Model
	@ManyToMany(mappedBy = "dialogs")
	private List<Character> characters = new ArrayList<Character>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "environmenthasdialog", joinColumns = {
			@JoinColumn(name = "dialog_id") }, inverseJoinColumns = {
					@JoinColumn(name = "environment_id") })
	private List<Environment> environments = new ArrayList<Environment>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "dialoghasOption", joinColumns = {
			@JoinColumn(name = "dialog_id") }, inverseJoinColumns = {
					@JoinColumn(name = "dialogoption_id") })
	private List<DialogOption> dialogoptions = new ArrayList<DialogOption>();

	public int getId() {
		return Id;
	}

	public void setIdDialog(int i) {
		Id = i;
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

	public List<DialogOption> getDialogOptions() {
		return dialogoptions;
	}

	public void setDialogoptions(List<DialogOption> dialogoptions) {
		this.dialogoptions = dialogoptions;
	}
}
