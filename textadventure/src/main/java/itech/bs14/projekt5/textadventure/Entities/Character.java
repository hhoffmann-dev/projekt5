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
@Table(name = "`character`")
public class Character {
	
	@Id
	@Column(name = "Id")
	private int Id;

	@Column(name = "CharacterName")
	private String characterName;
	
	@Column(name = "HitPoints")
	private String hitPoints;
	
	  @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "characterhasarmour", 
	        joinColumns = { @JoinColumn(name = "character_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "armour_id") }
	    )
	private List<Armour> armours = new ArrayList<Armour>();
	
	  @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "characterhasweapon", 
	        joinColumns = { @JoinColumn(name = "character_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "weapon_id") }
	    )
	  private List<Weapon> weapons = new ArrayList<Weapon>();
	  
	  @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "characterhasdialog", 
	        joinColumns = { @JoinColumn(name = "character_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "dialog_id") }
	    )
	  private List<Dialog> dialogs = new ArrayList<Dialog>();
	
	public int getId() {
		return Id;
	}

	public void setIdCharacter(int i) {
		Id = i;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(String hitPoints) {
		this.hitPoints = hitPoints;
	}

	public List<Armour> getArmours() {
		return armours;
	}

	public void setArmours(List<Armour> armours) {
		this.armours = armours;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public List<Dialog> getDialog() {
		return dialogs;
	}

	public void setDialog(List<Dialog> dialog) {
		this.dialogs = dialog;
	}

}
