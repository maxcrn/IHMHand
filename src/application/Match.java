package application;

import java.util.Date;

public class Match {
	
	private Equipe domicile;
	private Equipe visiteur;
	private String score_eq1;
	private String score_eq2;
	private Personne arbitre1;
	private Personne arbitre2;
	private Personne secretaire;
	private Personne chronometreur;
	private Personne delegue;
	private Date dateRencontre;
	
	public Match(Equipe domicile, Equipe visiteur, Personne arbitre1, Personne arbitre2, Personne secretaire, Personne chronometreur, Personne delegue, Date dateRencontre) {
		this.score_eq1 = "0";
		this.score_eq1 = "1";
		this.setDomicile(domicile);
		this.setVisiteur(visiteur);
		this.setArbitre1(arbitre1);
		this.setArbitre2(arbitre2);
		this.setSecretaire(secretaire);
		this.setChronometreur(chronometreur);
		this.setDelegue(delegue);
		this.setDateRencontre(dateRencontre);
	}
	
	public Equipe getDomicile() {
		return domicile;
	}

	public void setDomicile(Equipe domicile) {
		this.domicile = domicile;
	}

	public Equipe getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Equipe visiteur) {
		this.visiteur = visiteur;
	}

	public String getScore_eq1() {
		return score_eq1;
	}

	public void setScore_eq1(String score_eq1) {
		this.score_eq1 = score_eq1;
	}

	public String getScore_eq2() {
		return score_eq2;
	}

	public void setScore_eq2(String score_eq2) {
		this.score_eq2 = score_eq2;
	}

	public Personne getArbitre1() {
		return arbitre1;
	}

	public void setArbitre1(Personne arbitre1) {
		this.arbitre1 = arbitre1;
	}

	public Personne getArbitre2() {
		return arbitre2;
	}

	public void setArbitre2(Personne arbitre2) {
		this.arbitre2 = arbitre2;
	}

	public Personne getSecretaire() {
		return secretaire;
	}

	public void setSecretaire(Personne secretaire) {
		this.secretaire = secretaire;
	}

	public Personne getChronometreur() {
		return chronometreur;
	}

	public void setChronometreur(Personne chronometreur) {
		this.chronometreur = chronometreur;
	}

	public Personne getDelegue() {
		return delegue;
	}

	public void setDelegue(Personne delegue) {
		this.delegue = delegue;
	}

	public Date getDateRencontre() {
		return dateRencontre;
	}

	public void setDateRencontre(Date dateRencontre) {
		this.dateRencontre = dateRencontre;
	}

}
