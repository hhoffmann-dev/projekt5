package itech.bs14.projekt5.textadventure.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`savegame`")
public class SaveGame {
	
			@Id
			@Column(name = "Id")
			private int Id;

			@Column(name = "dialog_id")
			private String dialogId;
			
			@Column(name = "user_id")
			private String userId;

			public int getId() {
				return Id;
			}

			public void setId(int id) {
				Id = id;
			}

			public String getDialogId() {
				return dialogId;
			}

			public void setDialogId(String dialogId) {
				this.dialogId = dialogId;
			}

			public String getUserId() {
				return userId;
			}

			public void setUserId(String userId) {
				this.userId = userId;
			}

}
