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
public class Weapon {

	@Id
	@Column(name = "idWeapon")
	private int idWeapon;

	@Column(name = "WeaponName")
	private String weaponName;

	@Column(name = "Damage")
	private String damage;
	
	@ManyToMany(mappedBy = "weapons")
	private List<Character> characters = new ArrayList<Character>();

	public int getIdWeapon() {
		return idWeapon;
	}

	public void setIdWeapon(int idWeapon) {
		this.idWeapon = idWeapon;
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
