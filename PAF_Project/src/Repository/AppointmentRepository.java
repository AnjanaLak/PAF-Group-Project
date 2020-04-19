package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.AppointmentModel;

public class AppointmentRepository {

	Connection con = null;

	AppointmentModel lab1 = new AppointmentModel();

	public AppointmentRepository() {

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

	public List<AppointmentModel> getAppointmentdetailsList() { // this function will get the
												// appointments inserted in the
												// database

		List<AppointmentModel> appt = new ArrayList<>();

		String sql = "SELECT * FROM appointment";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				AppointmentModel apt1 = new AppointmentModel();

				apt1.setIdAppointment(rs.getString(1));
				apt1.setDate(rs.getString(2));
				apt1.setIdPatient(rs.getString(3));
				apt1.setLab_service_ID(rs.getInt(4));

				appt.add(apt1);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return appt;
	}

	public AppointmentModel getAnAppointmentDetail(String apptID) { // this function will get
														// the required
														// appointment from the
														// database

		String sql1 = "SELECT * FROM appointment WHERE idAppointment = '" + apptID + "'";

		AppointmentModel apt2 = new AppointmentModel(); // creating a laboratory object

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql1);

			if (rs.next()) {

				apt2.setIdAppointment(rs.getString(1));
				apt2.setDate(rs.getString(2));
				apt2.setIdPatient(rs.getString(3));
				apt2.setLab_service_ID(rs.getInt(4));

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return apt2;
	}

	public String createAnAppointment(String idAppointment, String date, String idPatient, String lab_service_ID ) {
		// this function will crate a new laboratory
		
		String result = "";
		String sql = "INSERT INTO appointment VALUES(?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, idAppointment);
			st.setString(2, date);
			st.setString(3,  idPatient);
			st.setInt(4, Integer.parseInt(lab_service_ID));

			st.executeUpdate();
			con.close();
			
			result = "Inserted Successfully";

		}

		catch (SQLException e) {

			result = "Insertion Unsuccessful";
		}
		
		return result;
	}
	public String updateAnAppointment(String idAppointment, String date, String idPatient, String lab_service_ID) {
		// this function will update the relevant laboratory
		
		String result = "";
		String sql = "UPDATE appointment SET date=?, idPatient=?, lab_service_ID=? WHERE idAppointment = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, date);
			st.setString(2,  idPatient);
			st.setInt(3, Integer.parseInt(lab_service_ID));
			st.setString(4, idAppointment);

			
			st.executeUpdate();
			con.close();
			
			result = "Updated Successfully";

		}

		catch (SQLException e) {

			result = "Error while Updating";
		}
		
		return result;
	}

	public String deleteAnAppointment(String id) {

		String deletionResult = "";
		String sql = "DELETE FROM appointment WHERE idAppointment=?";

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
	
	public boolean labServiceExistChecker() { // check whether a requested lab service exists on the lab service table while 
											// inserting data into an appointment
		
		
		
		return true;
	}


}
