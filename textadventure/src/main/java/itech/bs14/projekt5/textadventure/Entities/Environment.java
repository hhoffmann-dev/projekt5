package itech.bs14.projekt5.textadventure.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Environment")
public class Environment {
	
			@Id
			@Column(name = "idEnvironment")
			private int idEnvironment;

			@Column(name = "EnvironmentName")
			private String environmentName;

			@ManyToMany(mappedBy = "environments")
			private List<Dialog> dialogs = new ArrayList<Dialog>();

			public int getIdEnvironment() {
				return idEnvironment;
			}

			public void setIdEnvironment(int idEnvironment) {
				this.idEnvironment = idEnvironment;
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
