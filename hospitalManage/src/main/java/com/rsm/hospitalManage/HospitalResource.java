package com.rsm.hospitalManage;

import java.util.Arrays;
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

@Path("hospitals")
public class HospitalResource 
{
	HospitalRepository repo = new HospitalRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Hospital> getHospitals()
	{
		
		return repo.getHospitals();  
		
	}
	
	@GET
	@Path("hospital/{hosID}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital getHospital(@PathParam("hosID")int hosID)
	{
		return repo.getHospital(hosID);
	}
	
	
	@POST
	@Path("hospital")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital createHospital(Hospital h1)
	{
		System.out.println(h1);
		repo.create(h1);
		return h1;
	}

	@PUT
	@Path("hospital")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital updateHospital(Hospital h1)
	{
		System.out.println(h1);
		if(repo.getHospital(h1.getHosID()).getHosID()==0)
		{
			repo.create(h1);	
		}
		else
		{
		repo.update(h1);
		}
		return h1;
	}
	
	
	@DELETE
	@Path("hospital/{hosID}")
	public Hospital deleteHospital(@PathParam("hosID")int hosID)
	{
		Hospital h = repo.getHospital(hosID);
		if(h.getHosID()!=0)
		repo.delete(hosID);
		return h;
	}
}
