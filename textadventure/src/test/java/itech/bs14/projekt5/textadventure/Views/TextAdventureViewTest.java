package itech.bs14.projekt5.textadventure.Views;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import itech.bs14.projekt5.textadventure.Beans.TextAdventureBean;

class TextAdventureViewTest {
	TextAdventureView testView = new TextAdventureView();

	@Test
	void testRestartGame() {
		testView.selectedDialogId = 9999;
		
		testView.restartGame();
		
		assertEquals(1, testView.selectedDialogId);
		assertNull(testView.selectedDialog);
		assertNull(testView.selectedEnvironment);
		assertNull(testView.option);
		assertNull(testView.dialogOptions);
	}

}
