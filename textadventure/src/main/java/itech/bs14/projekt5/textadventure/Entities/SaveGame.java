package itech.bs14.projekt5.textadventure.Entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`savegame`")
public class SaveGame {
	
			@Id
			@Column(name = "Id")
			@GeneratedValue
			private int Id;

			@Column(name = "dialog_id")
			private int dialogId;
			
			@Column(name = "user_id")
			private int userId;
			
			public int getId() {
				return Id;
			}

			public void setId(int id) {
				Id = id;
			}

			public int getDialogId() {
				return dialogId;
			}

			public void setDialogId(int dialogId) {
				this.dialogId = dialogId;
			}

			public int getUserId() {
				return userId;
			}

			public void setUserId(int userId) {
				this.userId = userId;
			}

}
