package com.agilecrm.services;

import java.util.List;

import com.agilecrm.model.Ticket;

public interface SerInt 
{
	
	public int addTicketService(Ticket t);

	public List<Ticket> retrieveTicketsService();

	public int delTicketService(int id);

	public Ticket retrieveContactService(int id);

	public List<Ticket> retrieveTicketService(String fName);

	public int updateTicketService(Ticket t, String idEmail);
}
