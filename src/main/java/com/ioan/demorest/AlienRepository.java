package com.ioan.demorest;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	
	List<Alien> aliens;
	
	public AlienRepository() {
		aliens = new ArrayList<Alien>();
		
		Alien a1 = new Alien();
		a1.setId(1);
		a1.setName("Vitoro");
		a1.setPoints(56);
		
		Alien a2 = new Alien();
		a2.setId(2);
		a2.setName("Clostor");
		a2.setPoints(67);
		
		aliens.add(a1);
		aliens.add(a2);
	}
	
	public List<Alien> getAliens() {
		return aliens;
	}
	
	public Alien getAlien(int id) {
		
		for (Alien a: aliens) {
			if (a.getId() == id)
				return a;
		}
		
		return new Alien();
	}
	
	public void create(Alien newAlien) {
		aliens.add(newAlien);
	}
}
