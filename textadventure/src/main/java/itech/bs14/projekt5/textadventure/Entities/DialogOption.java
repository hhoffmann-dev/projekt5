package itech.bs14.projekt5.textadventure.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`dialogoption`")
public class DialogOption {

			@Id
			@Column(name = "Id")
			private int Id;

			@Column(name = "Text")
			private String dialogText;

			@ManyToMany(mappedBy = "dialogoptions")
			private List<Dialog> dialogs = new ArrayList<Dialog>();

			public int getId() {
				return Id;
			}

			public void setIdDialogOption(int i) {
				Id = i;
			}

			public String getDialogText() {
				return dialogText;
			}

			public void setDialogText(String dialogText) {
				this.dialogText = dialogText;
			}

			public List<Dialog> getDialog() {
				return dialogs;
			}

			public void setDialog(List<Dialog> dialog) {
				this.dialogs = dialog;
			}
			

}
