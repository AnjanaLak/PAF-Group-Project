package com.rsm.hospitalManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class HospitalRepository {

	
	Connection con = null;
	public HospitalRepository()
	{
		String url = "Jdbc:mysql://localhost:3306/hospitalmanagement";
		String username = "root";
		String password = "";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<Hospital>getHospitals()
	{
		List<Hospital> hospitals = new ArrayList<>();
		String sql = "select * from hospital";
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			Hospital h = new Hospital();
			h.setHosID(rs.getInt(1));
			h.setHosName(rs.getString(2));
			h.setHosTelNo(rs.getString(3));
			h.setHosAddress(rs.getString(4));
			
			hospitals.add(h);
		}
		
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return hospitals;
	}
	public Hospital getHospital(int hosID) 
	{
		
		String sql = "select * from hospital where hosID="+hosID;
		Hospital h = new Hospital();
		try 
	{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next())
		{
			
			h.setHosID(rs.getInt(1));
			h.setHosName(rs.getString(2));
			h.setHosTelNo(rs.getString(3));
			h.setHosAddress(rs.getString(4));
			
			
		}
		
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return h;
	}

	public void create(Hospital h1)
	{
		String sql ="insert into hospital values(?,?,?,?)";
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setInt(1, h1.getHosID());
			st.setString(2, h1.getHosName());
			st.setString(3, h1.getHosTelNo());
			st.setString(4, h1.getHosAddress());
			st.executeUpdate();
			
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
	
	public void update(Hospital h1)
	{
		String sql ="update hospital set hosName=?, hosTelNo=?, hosAddress=? where hosID=?";
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setInt(4, h1.getHosID());
			st.setString(1, h1.getHosName());
			st.setString(2, h1.getHosTelNo());
			st.setString(3, h1.getHosAddress());
			st.executeUpdate();
			
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}

	public void delete(int hosID) 
	{
		
		String sql ="delete from hospital where hosID=?";
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setInt(1, hosID);
			
			st.executeUpdate();
			
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}

	
	
}
