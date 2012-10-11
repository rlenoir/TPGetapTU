package org.ldv.sio.getap;

import java.sql.Date;

public class Exemple {

	public static void main (String[] args){
		Classe nbrclasse = new Classe(1, "SIO22");
		User nbr = new User((long) 1, "Nizar", "Ben Ragdel", nbrclasse, "eleve");
	    User kpu = new User((long) 2, "Olivier", "Capuozzo",null, "prof");
	    AccPersonalise salonlivre = new AccPersonalise(3, "Salon du livre",1,(long) 1);
	    Date date = Date.valueOf("2012-10-07"); 
	    DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers((long) 1, "2010", date, 20, kpu, salonlivre, nbr, 0);
	    
	    System.out.println(dvctap);
	    dvctap.setEtat(4);
	    System.out.println(dvctap);
	    dvctap.setEtat(32);
	    System.out.println(dvctap);
	    dvctap.setEtat(4);
	    System.out.println(dvctap);
	    dvctap.setEtat(2048);
	    System.out.println(dvctap);
	    dvctap.setEtat(2);
	    System.out.println(dvctap);
	    dvctap.setEtat(32);
	    System.out.println(dvctap);   
	}
}
