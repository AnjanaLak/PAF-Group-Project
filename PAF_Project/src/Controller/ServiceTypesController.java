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

import Model.ServiceTypesModel;
import Repository.ServiceTypesRepository;

@Path("/ServiceTypes")
public class ServiceTypesController {

	ServiceTypesRepository stRep = new ServiceTypesRepository();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Testing is Successful";
	} // this function only related to testing purposes

	@GET
	@Path("serviceTypes/")
	@Produces({ MediaType.APPLICATION_XML })
	public List<ServiceTypesModel> getServiceTypes() {

		return stRep.getServiceTypes();
	} // using GET to get all the service types details
	
	@GET
	@Path("serviceType/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ServiceTypesModel getServiceType(@PathParam("id") String stID) {

		return stRep.getServiceType(stID);
	} // using GET to get a required service type details

	@POST
	@Path("serviceType/create/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createLab(@FormParam("idService") String idService, @FormParam("serviceName") String serviceName,
			@FormParam("description") String description) {

		String result = stRep.createServiceTpye(idService, serviceName, description);
		return result;

	} // using the POST to create a new service type

	@PUT
	@Path("serviceType/update/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateServiceType(@FormParam("idService") String idService, @FormParam("serviceName") String serviceName,
			@FormParam("description") String description) {

		String resultUpdate = stRep.updateServiceType(idService, serviceName, description);
		
		return resultUpdate;

	} // using put to update a required lab
	
	
	@DELETE
	@Path("serviceType/delete/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteServiceType(String id) {

		Document doc = Jsoup.parse(id, "", Parser.xmlParser());
		
		String serviceTypeID = doc.select("serviceTypeID").text();
		
		String resultDelete = stRep.deleteServiceType(serviceTypeID);
		
		return resultDelete;
		
	}
}
