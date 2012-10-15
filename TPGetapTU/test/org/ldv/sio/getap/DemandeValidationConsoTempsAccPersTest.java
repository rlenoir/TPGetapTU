package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class DemandeValidationConsoTempsAccPersTest {
	
	@Before
		public void testEtatInitial() {
			assertTrue("Etat initial", dvctap.isEtatInitial());
			}


	Classe nbrclasse = new Classe(1, "SIO22");
	User nbr = new User((long) 1, "Nizar", "Ben Ragdel", nbrclasse, "eleve");
    User kpu = new User((long) 2, "Olivier", "Capuozzo",null, "prof");
    AccPersonalise salonlivre = new AccPersonalise(3, "Salon du livre",1,(long) 1);
    Date date = Date.valueOf("2012-10-07"); 
    DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers((long) 1, "2010", date, 20, kpu, salonlivre, nbr, 0);
	
	@Test
	public void testDemandeValidationConsoTempsAccPers() {
		
	    assertTrue("Etat initial", dvctap.isEtatInitial());
		
	}
	
	@Test
	public void test() {

	}
	
}