package itech.bs14.projekt5.textadventure.Beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import itech.bs14.projekt5.textadventure.DAOs.TextAdventureDAO;

class TextadventureBeansTest {
	TextAdventureBean testBean = new TextAdventureBean();
	
	TextAdventureDAO testDAO = new TextAdventureDAO();

	@Test
	void testOptionId() {
		int optionId = testBean.setNewDialogByOptionId(1);
		
		assertEquals(8, optionId);
	}
	
	@Test
	void testDialogId() {
		int dialogId = testBean.setNewDialogByDialogId(2);
		
		assertEquals(4, dialogId);
	}

}
