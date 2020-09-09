package itech.bs14.projekt5.textadventure.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`userdata`")
public class UserData {
	
			@Id
			@Column(name = "Id")
			@GeneratedValue
			private int Id;

			@Column(name = "Password")
			private String password;
			
			@Column(name = "UserName")
			private String name;

			public int getId() {
				return Id;
			}

			public void setId(int id) {
				Id = id;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

}
