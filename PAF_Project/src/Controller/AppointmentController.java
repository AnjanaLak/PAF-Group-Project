package Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import Model.AppointmentModel;
import Repository.AppointmentRepository;

@Path("/Appointments")
public class AppointmentController {

	AppointmentRepository apptRep = new AppointmentRepository();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Testing is Successful";
	} // this function only related to testing purposes
	

	@GET
	@Path("appointments/")
	@Produces({ MediaType.APPLICATION_XML })
	public List<AppointmentModel> getAppointments() {

		return apptRep.getAppointmentdetailsList();
	} // using GET to get all the appointments details
	
	
	
	
	
	@GET
	@Path("appointment/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public AppointmentModel getLab(@PathParam("id") String idAppointment) {

		return apptRep.getAnAppointmentDetail(idAppointment);
	} // using GET to get a required appointment details

	@POST
	@Path("appointment/create/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createAppointment(@FormParam("idAppointment") String idAppointment, @FormParam("date") String date,
			@FormParam("idPatient") String idPatient, @FormParam("lab_service_ID") String lab_service_ID) {

		String result = apptRep.createAnAppointment(idAppointment, date, idPatient, lab_service_ID);
		return result;

	} // using the POST to create an appointment

	@PUT
	@Path("appointment/update/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppointment(@FormParam("idAppointment") String idAppointment, @FormParam("date") String date,
			@FormParam("idPatient") String idPatient, @FormParam("lab_service_ID") String lab_service_ID) {

		String resultUpdate = apptRep.updateAnAppointment(idAppointment, date, idPatient, lab_service_ID);
		
		return resultUpdate;

	} // using put to update a required appointment
	
	
	@DELETE
	@Path("appointment/delete/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAppointment(String id) {

		Document doc = Jsoup.parse(id, "", Parser.xmlParser());
		
		String appointmentID = doc.select("appointmentID").text();
		
		String resultDelete = apptRep.deleteAnAppointment(appointmentID);
		
		return resultDelete;
		

		
	}
}
