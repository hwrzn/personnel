package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		ligue.setNom("Tennis");
		assertEquals("Tennis", ligue.getNom());
	}
	
	@Test
	void getAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe admin = ligue.addEmploye("Doe", "John", "johndoe@gmail.com", "nimda", null, null);
		ligue.setAdministrateur(admin);
		assertEquals(admin, ligue.getAdministrateur());
	}
	
	@Test
	void setAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe admin = ligue.addEmploye("John", "Doe", "johndoe@gmail.com", "nimda", null, null);
		ligue.setAdministrateur(admin);
		assertEquals(admin, ligue.getAdministrateur());
	}
	
	@Test
	void getEmployes() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", null, null);
		Employe admin = ligue.addEmploye("Thibaut", "Rongier", "t.rongier@gmail.com", "test", null, null);
		assertEquals(employe, ligue.getEmployes().first());
		assertEquals(admin, ligue.getEmployes().last());
	}
	
	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", null, null); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	void remove() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		ligue.remove();
		assertFalse(gestionPersonnel.getLigues().contains(ligue));
	}
	
	@Test
	void compareTo() throws SauvegardeImpossible
	{
		Ligue flechettes = gestionPersonnel.addLigue("Fléchettes");
		Ligue basketball = gestionPersonnel.addLigue("Fléchettes");
		assertEquals(0, basketball.compareTo(flechettes));
	}
	
	@Test
	void testToString() throws SauvegardeImpossible
	{
		Ligue basketball = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", basketball.toString());
	}
	
}
