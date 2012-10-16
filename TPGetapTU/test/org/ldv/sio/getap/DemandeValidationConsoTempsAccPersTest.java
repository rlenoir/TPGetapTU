package org.ldv.sio.getap;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class DemandeValidationConsoTempsAccPersTest {

	Classe nbrclasse = new Classe(1, "SIO22");
	User nbr = new User((long) 1, "Nizar", "Ben Ragdel", nbrclasse, "eleve");
	User kpu = new User((long) 2, "Olivier", "Capuozzo",null, "prof");
	AccPersonalise salonlivre = new AccPersonalise(3, "Salon du livre",1,(long) 1);
	Date date = Date.valueOf("2012-10-07"); 
	DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers
			((long) 1, "2010", date, 20, kpu, salonlivre, nbr, 16);


	@Before
	public void testEtatInitial() {
	}

	@Test
	public void testMethodeAnnuleEleve() {
		try  {
			dvctap.annuleeEleve();
			assertTrue("Etat : Annulee par eleve", dvctap.isAnnulee());
		}
		catch(DVCTAPException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testMethodeRefuseProf() {
		try  {
			dvctap.refuseeProf();
			assertTrue("Etat : Annulee par eleve", dvctap.isRefuseeProf());
		}
		catch(DVCTAPException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testValideeProf() {
		try  {
			dvctap.valideeProf();
			assertTrue("Etat : Annulee par eleve", dvctap.isValideeProf());
		}
		catch(DVCTAPException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testModifProfDate() {
		try  {
			dvctap.modifProfDate();
			assertTrue("Etat : Annulee par eleve", dvctap.isUpdateDateByTeacher());
		}
		catch(DVCTAPException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testModifProfDuree() {
		try  {
			dvctap.modifProfDuree();
			assertTrue("Etat : Annulee par eleve", dvctap.isUpdateDurationByTeacher());
		}
		catch(DVCTAPException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModifProfAPB() {
		try  {
			dvctap.modifProfAP();
			assertTrue("Etat : Annulee par eleve", dvctap.isUpdateAPByTeacher());
		}
		catch(DVCTAPException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRefusedEleve() {
		try  {
			dvctap.RefusedEleve();
			assertTrue("Etat : Annulee par eleve", dvctap.isRefusedEleve());
		}
		catch(DVCTAPException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAcceptedEleve() {
		try  {
			dvctap.RefusedEleve();
			assertTrue("Etat : Annulee par eleve", dvctap.isAcceptedEleve());
		}
		catch(DVCTAPException e){
			e.printStackTrace();
		}
	}
}