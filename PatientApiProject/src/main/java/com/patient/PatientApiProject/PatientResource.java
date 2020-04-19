package com.patient.PatientApiProject;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.org.apache.bcel.internal.generic.RETURN;

@Path("patients")

public class PatientResource {
	
	PatientRepository pr = new PatientRepository();

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Patient> getPatient() {
		
		System.out.println("Patient Called :");
		return pr.getPatients();	
	}
	
	@GET
	@Path("patient/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Patient getPatients(@PathParam("id") int id) {
		
		return pr.getPatient(id);
	}
	
	
	@POST
	@Path("/patient")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Patient createaPatient(Patient p1) {
		System.out.println(p1);
		pr.create(p1);
		return p1;
		
	}
	
	@PUT
	@Path("patient")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Patient UpdatePatient(Patient p1) {
		System.out.println(p1);
		if(pr.getPatient(p1.getPID())==null)
		{
			pr.create(p1);
		}
		else
		{
			pr.Update(p1);
		}
		return p1;
		
	}
	
	@DELETE
	@Path("patient/{id}")
	public Patient deletePatient(@PathParam("id") int id)
	{
		Patient p = pr.getPatient(id);
		
		if(p.getPID()!=0)
			pr.delete(id);  
				
		return p;
	}
}
 