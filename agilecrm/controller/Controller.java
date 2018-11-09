package com.agilecrm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import com.agilecrm.model.Ticket;
import com.agilecrm.services.SerImp;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Controller()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("in doGet Method");
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("in doPost Method");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("Hello you in do post");
		String type = request.getParameter("actionType");
		SerImp s = new SerImp();
		

		if (type.equals("add")) {
			System.out.println("inside controller add");
			Ticket t= new Ticket();
			t.setName(request.getParameter("name"));
			t.setEmail(request.getParameter("email"));
			t.setMobNum(Long.parseLong(request.getParameter("mobNUm")));
			t.setType(request.getParameter("type"));
			t.setDept(request.getParameter("dept"));
			t.setDes(request.getParameter("des"));
			t.setActive(true);
			t.setCreatedBy(request.getParameter("createdBy"));
			t.setCreatedDate(com.agilecrm.util.Date.toDate(request.getParameter("createdDate")));
			t.setUpdatedBy(request.getParameter("updatedBy"));
			t.setUpdatedDate(com.agilecrm.util.Date.toDate(request.getParameter("updatedDate")));
			
			s.addTicketService(t);
			
		}
		else if (type.equals("delete"))
		{
			System.out.println("inside controller delete");
			String d =request.getParameter("id");
			int id = Integer.parseInt(d);
			 s.delTicketService(id);
			
		}
		else if (type.equals("update"))
		{
			System.out.println("insde controller update");
			Ticket t =new Ticket();
			String email = request.getParameter("email");
			t.setName(request.getParameter("name"));
			s.updateTicketService(t, email);
			
		}
		
		else if(type.equals("getAll"))
		{
			System.out.println("insde controller view all");
			PrintWriter out = response.getWriter();
			List<Ticket> l= s.retrieveTicketsService();
			
			ObjectMapper mapper = new ObjectMapper();
			for(int i = 0; i<l.size();i++)
			{
				mapper.writeValueAsString(l.get(i));
				String jsonInString1 = mapper.writeValueAsString(l.get(i));
				System.out.println(jsonInString1);
				
			}
		
		}
			
		doGet(request, response);
		
	}
}
