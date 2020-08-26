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
@Table(name = "`armour`")
public class Armour {

		@Id
		@Column(name = "Id")
		private int Id;

		@Column(name = "Name")
		private String name;
		
		@Column(name = "Defence")
		private int Defence;
		
		@ManyToMany(mappedBy = "armours")
		private List<Character> characters = new ArrayList<Character>();

		public int getId() {
			return Id;
		}

		public void setId( int i ) {
			Id = i;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDefence() {
			return Defence;
		}

		public void setDefence(int defence) {
			Defence = defence;
		}

		public List<Character> getCharacters() {
			return characters;
		}

		public void setCharacters(List<Character> characters) {
			this.characters = characters;
		}
}
