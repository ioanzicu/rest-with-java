package com.ioan.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResources {
	
	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAlien() {
		
		System.out.println("getAlien called");
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id) {
		return repo.getAlien(id);
	}
	
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien ceateAlien(Alien newAlien) {
		System.out.println(newAlien);
	
		repo.create(newAlien);
		return newAlien;
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien updateAlien(Alien alien) {
		System.out.println(alien);
		
		// If no such alien, create it, if no, update		
		if (repo.getAlien(alien.getId()).getId() == 0) {
			repo.create(alien);
		} else {
			repo.update(alien);
		}
		
		return alien;
	}
	
	@DELETE
	@Path("alien/{id}")
	public Alien deleteAlien(@PathParam("id") int id) {
		Alien alien = repo.getAlien(id);
		
		if (alien.getId() != 0) {			
			repo.delete(id);
		}
		
		return alien;
	}
	
}
