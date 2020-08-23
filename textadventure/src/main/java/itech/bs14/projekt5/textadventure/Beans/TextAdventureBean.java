package itech.bs14.projekt5.textadventure.Beans;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import itech.bs14.projekt5.textadventure.DAOs.TextAdventureDAO;


@Component("TextAdventureBean")
@Scope("singleton")
public class TextAdventureBean {
	@Autowired
	TextAdventureDAO taDAO;
	
	
	@PostConstruct
	public void init() {
		
		taDAO.listIncome();
	}
}
