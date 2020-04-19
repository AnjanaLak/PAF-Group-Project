package com.paymentServiceFunction.PaymentProjectAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;



public class PaymentRepository 
{
	
	Connection con = null;
	
	public PaymentRepository()
	{		
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		String username = "root";
		String password = "";
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Payment> getPayments()
	{
		List<Payment> payments = new ArrayList<>();
		String sql = "select * from payment";
		
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Payment p = new Payment();
				p.setPaymentId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPaymentType(rs.getString(3));
				p.setPaymentAmount(rs.getDouble(4));
				p.setPaymentDate(rs.getString(5));
				
				payments.add(p);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	   
		return payments;
	}
	
	public Payment getPayment(int paymentId) 
	{
          String sql = "select * from payment where paymentId="+paymentId;
          Payment p = new Payment();
		
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				p.setPaymentId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPaymentType(rs.getString(3));
				p.setPaymentAmount(rs.getDouble(4));
				p.setPaymentDate(rs.getString(5));
				
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return p;
		
	}

	public void create(Payment p1) {
		String sql = "insert into payment values (?,?,?,?,?)";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, p1.getPaymentId());
			st.setString(2, p1.getName());
			st.setString(3, p1.getPaymentType());
			st.setDouble(4, p1.getPaymentAmount());
			st.setString(5, p1.getPaymentDate());
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void update(Payment p1) {
		String sql = "update payment set Name=?, paymentType=?, paymentAmount=?,paymentDate=? where paymentId=?";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, p1.getName());
			st.setString(2, p1.getPaymentType());
			st.setDouble(3, p1.getPaymentAmount());
			st.setString(4, p1.getPaymentDate());
			st.setInt(5, p1.getPaymentId());
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

	public void delete(int paymentId) {
         String sql = "delete from payment where paymentId=?";
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);			
			st.setInt(1, paymentId);
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
