package application;

public class Equipe {
	
	private String nomEquipe;
	private int victoire;
	private int defaite;
	private int egalite;
	private Personne entraineur;
	private int nbPoints;
	private int tempsMorts;
	private String ligue;
	
	public Equipe (String nomEquipe, Personne entraineur, String ligue) {
		this.setNomEquipe(nomEquipe);
		this.setEntraineur(entraineur);
		this.setLigue(ligue);
		this.victoire = 0;
		this.defaite = 0;
		this.egalite = 0;
		this.nbPoints = 0;
		this.tempsMorts = 3;
	}
	
	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public int getVictoire() {
		return victoire;
	}

	public void setVictoire(int victoire) {
		this.victoire = victoire;
	}

	public int getDefaite() {
		return defaite;
	}

	public void setDefaite(int defaite) {
		this.defaite = defaite;
	}

	public int getEgalite() {
		return egalite;
	}

	public void setEgalite(int egalite) {
		this.egalite = egalite;
	}

	public Personne getEntraineur() {
		return entraineur;
	}

	public void setEntraineur(Personne entraineur) {
		this.entraineur = entraineur;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getTempsMorts() {
		return tempsMorts;
	}

	public void setTempsMorts(int tempsMorts) {
		this.tempsMorts = tempsMorts;
	}

	public String getLigue() {
		return ligue;
	}

	public void setLigue(String ligue) {
		this.ligue = ligue;
	}

}
