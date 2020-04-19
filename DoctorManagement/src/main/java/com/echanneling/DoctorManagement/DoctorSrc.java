package com.echanneling.DoctorManagement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DoctorSrc { 
	
	Connection con = null ;
	   
    Statement statement ;
  
    PreparedStatement preStatement ;

	public DoctorSrc() {  
		String dbURL = "jdbc:mysql://127.0.0.1:3306/doctor" ;
        String dbUsername = "root" ;
        String dbPassword = "root";
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL,dbUsername , dbPassword);
       
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public List<Doctor> getDoctorDetails() {
		System.out.println("step1");
		List<Doctor> doctors = new ArrayList<>();
		System.out.println("step2");
		String sql = "SELECT * FROM hospital_doctor";
		System.out.println("step3");
	try {
		System.out.println("step4");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		System.out.println("step5");
		while (rs.next()) {
			Doctor doc = new Doctor();
			
			doc.setDoctorID(rs.getString(1));
			doc.setFullName(rs.getString(2));	
			doc.setPassword(rs.getString(3));
			doc.setEmail(rs.getString(4));
			doc.setPhoneNumber(rs.getString(5));
			System.out.println(rs.getString(1));
			
			doctors.add(doc);
			System.out.println(doc);
			System.out.println("step7");
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return doctors;

	}
	
	public void insertDoc(Doctor docdt) {
		
		String sql = "INSERT INTO doctor.hospital_doctor (doctorID,fullname,password,phoneNo,email) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, docdt.getDoctorID());
			st.setString(2, docdt.getFullName());
			st.setString(3, docdt.getPassword());
			st.setString(4, docdt.getPhoneNumber());
			st.setString(5, docdt.getEmail());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(String doctorID) {
		String sql = "DELETE FROM doctor.hospital_doctor WHERE doctorID=?;";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, doctorID);
			
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void update(Doctor docdt) {
		
		String sql = "UPDATE doctor.hospital_doctor SET doctorID = ?, fullname =?, password = ?, phoneNo =?, email = ? WHERE doctorID = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, docdt.getDoctorID());
			st.setString(2, docdt.getFullName());
			st.setString(3, docdt.getPassword());
			st.setString(4, docdt.getPhoneNumber());
			st.setString(5, docdt.getEmail());
			st.setString(6, docdt.getDoctorID());
			
			
			st.executeUpdate();
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
