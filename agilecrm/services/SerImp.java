package com.agilecrm.services;

import java.util.ArrayList;
import java.util.List;

import com.agilecrm.dao.DaoImp;
import com.agilecrm.model.Ticket;

public class SerImp implements SerInt
{

	public int addTicketService(Ticket t)
	{
		System.out.println("inside service");
		
		DaoImp d = new DaoImp();
		d.addTicket(t);
		
		return 0;
	}

	public List<Ticket> retrieveTicketsService() 
	{
		List<Ticket> l = new ArrayList<Ticket>();
		System.out.println("inside service");
	
		DaoImp d = new DaoImp();
		l = d.retrieveTickets();
		
		
		return l;
	}

	
	
	public int delTicketService(int id) {
		System.out.println("inside service");
		DaoImp d =new DaoImp();
		d.delContact(id);	
		return 0;
	}

	public Ticket retrieveContactService(int id) {
		DaoImp d = new DaoImp();
		return d.retrieveTicket(id);
	}

	public List<Ticket> retrieveTicketService(String fName) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateTicketService(Ticket t, String idEmail) 
	{
	System.out.println("inside service update method");
	DaoImp d =new DaoImp();
	d.updateTicket(t, idEmail);

		return 0;
	}

}
