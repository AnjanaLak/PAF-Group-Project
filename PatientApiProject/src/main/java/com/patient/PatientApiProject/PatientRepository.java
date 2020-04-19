package com.patient.PatientApiProject;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PatientRepository {
 
	Connection con = null;
	List<Patient> patients;
	
	public PatientRepository() {
		
		String url = "jdbc:mysql://localhost:3306/patientapiproject";
		String username = "root";
		String password = "";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public List<Patient> getPatients(){
		
		List<Patient> patient = new ArrayList<>();
		String sql = "SELECT * FROM Patient";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Patient p = new Patient();
				p.setPID(rs.getInt(1));
				p.setPName(rs.getString(2));
				p.setPAge(rs.getInt(3));
				p.setTypeOfSick(rs.getString(4));
				
				patient.add(p);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return patient;
	}
	
	public Patient getPatient(int id) {
		 
		String sql = "select * from Patient where PID="+id;
		Patient p = new Patient();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			if(rs.next()) 
			{
				p.setPID(rs.getInt(1));
				p.setPName(rs.getString(2));
				p.setPAge(rs.getInt(3));
				p.setTypeOfSick(rs.getString(4));
				
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return p;
		
	}

	public void create(Patient p1) {
		
		String sql = "INSERT INTO Patient VALUES (?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, p1.getPID());
			st.setString(2, p1.getPName());
			st.setInt(3, p1.getPAge());
			st.setString(4, p1.getTypeOfSick());
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
	public void Update(Patient p1) {
		
		String sql = "UPDATE Patient SET PName=? ,PAge=? ,TypeOfSick=? WHERE PID=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, p1.getPName());
			st.setInt(2, p1.getPAge());
			st.setString(3, p1.getTypeOfSick());
			st.setInt(4, p1.getPID());
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
			String sql = "delete from Patient where PID=?";
			
			try 
			{
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1,id);
				st.executeUpdate();
				
			} catch (SQLException e) 
			{
				System.out.println(e);
			}
			
			
	}
	 
	
	
	
}
