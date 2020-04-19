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

import Model.LaboratoryModel;
import Repository.LaboratoryRepository;

@Path("/Laboratory")
public class LaboratoryController {

	LaboratoryRepository labrep = new LaboratoryRepository();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Testing is Successful";
	} // this function only related to testing purposes

	@GET
	@Path("labs/")
	@Produces({ MediaType.APPLICATION_XML })
	public List<LaboratoryModel> getLabs() {

		return labrep.getLaboraotries();
	} // using GET to get all the laboratory details

	@GET
	@Path("lab/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public LaboratoryModel getLab(@PathParam("id") String labID) {

		return labrep.getLaboraotory(labID);
	} // using GET to get a required laboratory details

	@POST
	@Path("lab/create/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createLab(@FormParam("idLaboratory") String idLaboratory, @FormParam("LabName") String LabName,
			@FormParam("address") String address, @FormParam("telNo") String telNo, @FormParam("city") String city) {

		String result = labrep.createLaboratory(idLaboratory, LabName, address, telNo, city);
		return result;

	} // using the POST to create a lab

	@PUT
	@Path("lab/update/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateLab(@FormParam("idLaboratory") String idLaboratory, @FormParam("LabName") String LabName,
			@FormParam("address") String address, @FormParam("telNo") String telNo, @FormParam("city") String city) {

		String resultUpdate = labrep.updateLaboratory(idLaboratory, LabName, address, telNo, city);
		
		return resultUpdate;

	} // using put to update a required lab
	
	
	@DELETE
	@Path("lab/delete/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteLab(String id) {

		Document doc = Jsoup.parse(id, "", Parser.xmlParser());
		
		String labID = doc.select("labID").text();
		
		String resultDelete = labrep.deleteLaboratory(labID);
		
		return resultDelete;
		
	}
}
