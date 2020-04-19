package com.echanneling.DoctorManagement;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("doctor")
public class DoctorRepo {
	
	DoctorSrc doc = new DoctorSrc();
	
	@GET
	public List<Doctor> getDoctors() {
		System.out.println("step1");
		return doc.getDoctorDetails();
		
	}
	
	@DELETE
	@Path("/{doctorID}")
	public void delete(@PathParam("doctorID") String doctorID) {
		doc.delete(doctorID);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void insertDoc(Doctor docdt) {
		System.out.println(docdt);
		doc.insertDoc(docdt);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Doctor doct) {
		System.out.println(doct);
		doc.update(doct);
	}

}
