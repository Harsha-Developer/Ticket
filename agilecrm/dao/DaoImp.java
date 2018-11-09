package com.agilecrm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agilecrm.model.Ticket;
import com.agilecrm.util.JdbcCon;


public class DaoImp implements DaoInt	
{

	public int addTicket(Ticket t) 
	{
		System.out.println("inside dao");
	Connection con= JdbcCon.getConnect();
	String query = "insert into ticket(name,email,mobNum,type,dept,des,isActive,createdBy,createdDate,updatedBy,updatedDate) values(?,?,?,?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,t.getName());
		ps.setString(2, t.getEmail());
		ps.setLong(3, t.getMobNum());
		ps.setString(4, t.getType());
		ps.setString(5, t.getDept());
		ps.setString(6, t.getDes());
		ps.setBoolean(7,t.isActive());
		ps.setString(8, t.getCreatedBy());
		ps.setString(9, t.getCreatedDate());
		ps.setString(10, t.getUpdatedBy());
		ps.setString(11, t.getUpdatedDate());
		int n=ps.executeUpdate();
		if(n==1) {
			System.out.println("tkt  insert ");
		}
		else {
			System.out.println("tkt failed");
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return 0;
	}

	public int delContact(int id) {
		int n = 0;
		System.out.println("inside dao");
		Connection con= JdbcCon.getConnect();
		String query = "delete from ticket where id =?";
		try {
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		n = ps.executeUpdate();
		if(n==1) {
			System.out.println("tkt  deleted ");
		}
		else {
			System.out.println("tkt failed to delete");
		}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n ;
	}

	public int updateTicket(Ticket t, String email)
	{
		int n=0;
		Connection con = JdbcCon.getConnect();
		String query ="update ticket set name = ? where email =?";
		try {
			PreparedStatement ps =con.prepareStatement(query);
			ps.setString(1,t.getName());
			ps.setString(2, email);	
			n = ps.executeUpdate();
			if(n==1) {
				System.out.println("tkt  updated succesfully ");
			}
			else {
				System.out.println("tkt failed to update");
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public Ticket retrieveTicket(int id)
	{
		Connection con = JdbcCon.getConnect();
		String query ="select * from ticket where id  =?";
		Ticket t =new Ticket();
		try {
			PreparedStatement ps =con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
	
				
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	public List<Ticket> retrieveTickets()
	{
		List<Ticket> l = new ArrayList<Ticket>();
		Connection con = JdbcCon.getConnect();
		String query ="select * from ticket ";
		
		try {
			PreparedStatement ps =con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{Ticket t =new Ticket();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				long mobNUm = rs.getLong(4);
				String type = rs.getString(5);
				String dept = rs.getString(6);
				String des =rs.getString(7);
				Boolean isActive = rs.getBoolean(8);
				String createdBy = rs.getString(9);
				String createdDate =rs.getString(10);
				String updatedBy =rs.getString(11);
				String updatedDate =rs.getString(12);
				
				
				t.setId(id);
				t.setName(name);
				t.setEmail(email);
				t.setMobNum(mobNUm);
				t.setType(type);
				t.setDept(dept);
				t.setDes(des);
				t.setActive(true);
				t.setCreatedBy(createdBy);
				t.setCreatedDate(createdDate);
				t.setUpdatedBy(updatedBy);
				t.setUpdatedDate(updatedDate);
				
				l.add(t);
				
			}
			
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return l;
	}

	public List<Ticket> retrieveTickets(String arg) {
		return null;
	}
	public void deleteAll() {
		
		
		
		
	}
	
}
