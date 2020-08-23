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
@Table(name = "Character")
public class Character {
	
	@Id
	@Column(name = "idCharacter")
	private int idCharacter;

	@Column(name = "CharacterName")
	private String characterName;
	
	@Column(name = "HitPoints")
	private String hitPoints;
	
	  @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "CharacterHasArmour", 
	        joinColumns = { @JoinColumn(name = "idArmour") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idCharacter") }
	    )
	private List<Armour> armours = new ArrayList<Armour>();
	
	  @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "CharacterHasWeapon", 
	        joinColumns = { @JoinColumn(name = "idWeapon") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idCharacter") }
	    )
	  private List<Character> weapons = new ArrayList<Character>();
	  
	  @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "CharacterHasDialog", 
	        joinColumns = { @JoinColumn(name = "idDialog") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idCharacter") }
	    )
	  private List<Dialog> dialogTexts = new ArrayList<Dialog>();
	
	public int getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
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

}
