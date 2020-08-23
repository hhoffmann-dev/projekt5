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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Armour")
public class Armour {

		@Id
		@Column(name = "idArmour")
		private int idArmour;

		@Column(name = "Name")
		private String name;
		
		@Column(name = "info")
		private String Defence;
		
		@ManyToMany(mappedBy = "armours")
		private List<Character> characters = new ArrayList<Character>();

		public int getIdArmour() {
			return idArmour;
		}

		public void setIdArmour(int idArmour) {
			this.idArmour = idArmour;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDefence() {
			return Defence;
		}

		public void setDefence(String defence) {
			Defence = defence;
		}

		public List<Character> getCharacters() {
			return characters;
		}

		public void setCharacters(List<Character> characters) {
			this.characters = characters;
		}
}
