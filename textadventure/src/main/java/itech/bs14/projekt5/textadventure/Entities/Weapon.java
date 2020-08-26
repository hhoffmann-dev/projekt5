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
@Table(name = "weapon")
public class Weapon {

	@Id
	@Column(name = "Id")
	private int Id;

	@Column(name = "WeaponName")
	private String weaponName;

	@Column(name = "Damage")
	private String damage;
	
	@ManyToMany(mappedBy = "weapons")
	private List<Character> characters = new ArrayList<Character>();

	public int getId() {
		return Id;
	}

	public void setIdWeapon(int i) {
		Id = i;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
}
