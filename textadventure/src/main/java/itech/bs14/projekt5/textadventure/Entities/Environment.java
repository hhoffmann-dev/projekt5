package itech.bs14.projekt5.textadventure.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`environment`")
public class Environment {
	
			@Id
			@Column(name = "Id")
			private int Id;

			@Column(name = "EnvironmentName")
			private String environmentName;

			@ManyToMany(mappedBy = "environments")
			private List<Dialog> dialogs = new ArrayList<Dialog>();

			public int getId() {
				return Id;
			}

			public void setIdEnvironment(int i) {
				Id = i;
			}

			public String getEnvironmentName() {
				return environmentName;
			}

			public void setEnvironmentName(String environmentName) {
				this.environmentName = environmentName;
			}

			public List<Dialog> getDialogs() {
				return dialogs;
			}

			public void setDialogs(List<Dialog> dialogs) {
				this.dialogs = dialogs;
			}

}
