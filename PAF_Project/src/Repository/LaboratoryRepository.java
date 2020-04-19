package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.LaboratoryModel;

public class LaboratoryRepository {

	Connection con = null;

	LaboratoryModel lab1 = new LaboratoryModel();

	public LaboratoryRepository() {

		String url = "jdbc:mysql://localhost:3308/newdb";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<LaboratoryModel> getLaboraotries() { // this function will get the
												// laboratories inserted in the
												// database

		List<LaboratoryModel> labs = new ArrayList<>();

		String sql = "SELECT * FROM laboratory";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				LaboratoryModel lab1 = new LaboratoryModel();

				lab1.setIdLaboratory(rs.getString(1));
				lab1.setLabName(rs.getString(2));
				lab1.setAddress(rs.getString(3));
				lab1.setTelNo(rs.getInt(4));
				lab1.setCity(rs.getString(5));

				labs.add(lab1);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return labs;
	}

	public LaboratoryModel getLaboraotory(String labID) { // this function will get
														// the required
														// laboratory from the
														// database

		String sql1 = "SELECT * FROM laboratory WHERE idLaboratory = '" + labID + "'";

		LaboratoryModel lab = new LaboratoryModel(); // creating a laboratory object

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql1);

			if (rs.next()) {

				lab.setIdLaboratory(rs.getString(1));
				lab.setLabName(rs.getString(2));
				lab.setAddress(rs.getString(3));
				lab.setTelNo(rs.getInt(4));
				lab.setCity(rs.getString(5));

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return lab;
	}

	public String createLaboratory(String idLaboratory, String LabName, String address, String telNo, String city ) {
		// this function will crate a new laboratory
		
		String result = "";
		String sql = "INSERT INTO laboratory VALUES(?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, idLaboratory);
			st.setString(2, LabName);
			st.setString(3,  address);
			st.setInt(4, Integer.parseInt(telNo));
			st.setString(5, city);

			st.executeUpdate();
			con.close();
			
			result = "Inserted Successfully";

		}

		catch (SQLException e) {

			result = "Insertion Unsuccessful";
		}
		
		return result;
	}
	public String updateLaboratory(String idLaboratory, String LabName, String address, String telNo, String city) {
		// this function will update the relevant laboratory
		
		String result = "";
		String sql = "UPDATE laboratory SET name=?, address=?, telNo=?, city=? WHERE idLaboratory = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			
			st.setString(1, LabName);
			st.setString(2,  address);
			st.setInt(3, Integer.parseInt(telNo));
			st.setString(4, city);
			st.setString(5, idLaboratory);
			
			st.executeUpdate();
			con.close();
			
			result = "Updated Successfully";

		}

		catch (SQLException e) {

			result = "Error while Updating";
		}
		
		return result;
	}

	public String deleteLaboratory(String id) {

		String deletionResult = "";
		String sql = "DELETE FROM laboratory WHERE idLaboratory=?";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.executeUpdate();
			
			deletionResult = "Deletion Successful";
		}

		catch (SQLException e) {

			deletionResult = "Deletion Unsucessful";	
			}
		return deletionResult;
	}
	
}
