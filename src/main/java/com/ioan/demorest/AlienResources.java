package com.ioan.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResources {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAlien() {
		
		System.out.println("getAlien called");
		Alien a1 = new Alien();
		a1.setName("Vitoro");
		a1.setPoints(56);
		
		Alien a2 = new Alien();
		a2.setName("Clostor");
		a2.setPoints(67);
		
		
		List<Alien> aliens = Arrays.asList(a1, a2);
		
		return aliens;
	}
}
