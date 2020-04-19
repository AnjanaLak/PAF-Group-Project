package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.ServiceTypesModel;

public class ServiceTypesRepository {

	Connection con = null;

	ServiceTypesModel labserviceType = new ServiceTypesModel();

	public ServiceTypesRepository() {

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

	public List<ServiceTypesModel> getServiceTypes() { // this function will get the
												// service-types inserted in the
												// database

		List<ServiceTypesModel> serT = new ArrayList<>();

		String sql = "SELECT * FROM service_type";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				ServiceTypesModel s1 = new ServiceTypesModel();

				s1.setIdService(rs.getString(1));
				s1.setServiceName(rs.getString(2));
				s1.setDescription(rs.getString(3));
				

				serT.add(s1);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return serT;
	}

	public ServiceTypesModel getServiceType(String serTypeID) { // this function will get
														// the required
														// laboratory from the
														// database

		String sql1 = "SELECT * FROM service_type WHERE idService = '" + serTypeID + "'";

		ServiceTypesModel sert2 = new ServiceTypesModel(); // creating a laboratory object

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql1);

			if (rs.next()) {

				sert2.setIdService(rs.getString(1));
				sert2.setServiceName(rs.getString(2));
				sert2.setDescription(rs.getString(3));
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return sert2;
	}

	public String createServiceTpye(String idService, String serviceName, String description) {
		// this function will crate a new service type
		
		String result = "";
		String sql = "INSERT INTO service_type VALUES(?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, idService);
			st.setString(2, serviceName);
			st.setString(3,  description);
			
			st.executeUpdate();
			con.close();
			
			result = "Inserted Successfully";

		}

		catch (SQLException e) {

			result = "Insertion Unsuccessful";
		}
		
		return result;
	}
	public String updateServiceType(String idService, String serviceName, String description) {
		// this function will update relevant service types
		
		String result = "";
		String sql = "UPDATE service_type SET serviceName=?, description=? WHERE idService = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			
			st.setString(1, serviceName);
			st.setString(2, description);
			st.setString(3, idService);
			
			st.executeUpdate();
			con.close();
			
			result = "Updated Successfully";

		}

		catch (SQLException e) {

			result = "Error while Updating";
		}
		
		return result;
	}

	public String deleteServiceType(String id) {

		String deletionResult = "";
		String sql = "DELETE FROM service_type WHERE idService=?";

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
