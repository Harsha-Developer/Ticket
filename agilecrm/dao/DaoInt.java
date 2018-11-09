package com.agilecrm.dao;

import java.util.List;

import com.agilecrm.model.Ticket;
public interface DaoInt 
{
	public int addTicket(Ticket t);
	public int delContact(int id);
	public int updateTicket(Ticket t,String email);
	public Ticket retrieveTicket(int id);
	public List<Ticket> retrieveTickets();
	public List<Ticket> retrieveTickets(String arg);
	public void deleteAll();

}
