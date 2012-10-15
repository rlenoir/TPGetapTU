package org.ldv.sio.getap;

import java.sql.Date;
import org.ldv.sio.getap.DVCTAPException;

/**
 * Demande de validation d'un temps d'accompagnement personnalisé
 * 
 * 
 */

public class DemandeValidationConsoTempsAccPers {
	private static final int ACCEPTEE_ELEVE_MODIF_PROF=1;
	private static final int REFUSEE_ELEVE_MODIF_PROF=2;
	private static final int MODIF_ELEVE=4;
	private static final int ANNULEE_ELEVE=8;
	private static final int CREER_ELEVE=16;
	private static final int ACCEPTEE_PROF=32;
	private static final int REFUSEE_PROF=64;
	private static final int DATE_MODIFIEE =1024;
	private static final int DUREE_MODIFIEE =2048;
	private static final int AP_MODIFIEE =4096;

	/**
	 * Identifiant de la DCTAP
	 */
	private Long id;
	/**
	 * Année scolaire de la demande, par exemple "2011-2012"
	 */
	private String anneeScolaire;
	/**
	 * Date de réalisation de l'accompagnement
	 * 
	 */
	private java.sql.Date dateAction;
	/**
	 * Nombre de minutes d'accompagnement personnalisé à valider
	 */
	private Integer minutes;
	/**
	 * Professeur ayant assuré l'accompagnement personnalisé
	 */
	private User prof;
	/**
	 * Nature de l'accompagnement personnalisé associé à la demande
	 */
	private AccPersonalise accPers;
	/**
	 * Identifiant de l'élève ayant réalisé l'accompagnement personnalisé
	 */
	private User eleve;

	/**
	 * 
	 */
	private int etat;

	/**
	 * constructeur par défaut
	 */
	public DemandeValidationConsoTempsAccPers() {

	}

	/**
	 * Constructeur permettant de créer une demande complète.
	 * 
	 * @param id peut être null (moment de la creation)
	 *            
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve 
	 * @param etat
	 */
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire, Date date,
			Integer minutes, User prof, AccPersonalise accPers, User eleve,
			int etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.dateAction = date;
		this.minutes = minutes;
		this.prof = prof;
		this.accPers = accPers;
		this.eleve = eleve;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public java.sql.Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(java.sql.Date date) {
		this.dateAction = date;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public User getProf() {
		return prof;
	}

	public void setProf(User prof) {
		this.prof = prof;
	}

	public AccPersonalise getAccPers() {
		return accPers;
	}

	public void setAccPers(AccPersonalise accPers) {
		this.accPers = accPers;
	}

	public User getEleve() {
		return eleve;
	}

	public void setEleve(User eleve) {
		this.eleve = eleve;
	}

	public int getEtat() {
		return etat;
	}
	 
	/**
	 * Permet de modifier l'état de la demande
	 * 
	 * @param etat
	 *            prend ses valeur dans :
	 *            <ul>
	 *            <li>1 - demande acceptée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>2 - demande rejetée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>4 - demande modifiée par l'élève</li>
	 *            <li>8 - demande annulée par l'élève</li>
	 *            <li>16 - demande créée par l'élève</li>
	 *            <li>32 - demande validée par le professeur</li>
	 *            <li>64 - demande refusée par le professeur</li>
	 *            <li>1024 - demande où la date a été modifiée par le professeur
	 *            </li>
	 *            <li>2048 - demande où la durée a été modifiée par le
	 *            professeur</li>
	 *            <li>4096 - demande où l'accompagnement personnalisé a été
	 *            modifiée par le professeur</li>
	 *            </ul>
	 */
	
	
	public void setEtat(int etat) {
		this.etat = etat;
	}

	
	@Override
	public String toString() {
		return "DemandeConsoTempsAccPers [id=" + id + ", anneeScolaire="
				+ anneeScolaire + ", dateAction=" + dateAction + ", minutes="
				+ minutes + ", prof=" + prof + ", accPers=" + accPers
				+ ", eleve=" + eleve + ", etat=" + etat + "]";
	}


	/* Masques */
	
public boolean isEtatInitial(){
		Boolean bool = (this.etat & CREER_ELEVE ) == CREER_ELEVE;
		return bool;
	}

public boolean isUpdate(){
		Boolean bool = (this.etat & MODIF_ELEVE ) == MODIF_ELEVE;
		return bool;
}

public boolean isValideeProf(){
	Boolean bool = (this.etat & ACCEPTEE_PROF ) == ACCEPTEE_PROF;
	return bool;
}

public boolean isUpdateDateByTeacher(){
	Boolean bool = (this.etat & DATE_MODIFIEE ) == DATE_MODIFIEE;
	return bool;
}

public boolean isUpdateDurationByTeacher(){
	Boolean bool = (this.etat & DUREE_MODIFIEE ) == DUREE_MODIFIEE;
	return bool;
}

public boolean isUpdateAPByTeacher(){
	Boolean bool = (this.etat & AP_MODIFIEE ) == AP_MODIFIEE;
	return bool;
}

/* Méthodes changeant l'état d'une demande */
	
public void annuleeEleve(){
	if(this.isEtatInitial() || this.isUpdate())
	this.etat=ANNULEE_ELEVE;
}

public void refuseeProf(){
	if(this.isEtatInitial() || this.isUpdate())
	this.etat=REFUSEE_PROF;
}

public void valideeProf(){
	if(this.isEtatInitial() || this.isUpdate())
	this.etat=ACCEPTEE_PROF;
}


public void modifProfDate(){
	if(this.isEtatInitial() || this.isUpdate())
	this.etat=DATE_MODIFIEE;
}

public void modifProfDuree(){
	if(this.isEtatInitial() || this.isUpdate())
	this.etat=DUREE_MODIFIEE;
}

public void modifProfAP(){
	if(this.isEtatInitial() || this.isUpdate())
	this.etat=DUREE_MODIFIEE;
}

public void RefusedEleve(){
	if(this.isUpdateDateByTeacher()||isUpdateDurationByTeacher()||isUpdateAPByTeacher())
	this.etat=REFUSEE_ELEVE_MODIF_PROF;
}

public void AcceptedEleve(){
	if(this.isUpdateDateByTeacher()||isUpdateDurationByTeacher()||isUpdateAPByTeacher()||isValideeProf())
	this.etat=ACCEPTEE_ELEVE_MODIF_PROF;
}

}
