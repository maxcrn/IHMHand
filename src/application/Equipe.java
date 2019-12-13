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
	private int joues;
	private int diff;
	private int positionClassement;
	
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
	
	public Equipe(int positionClassement, String nomEquipe, int nbPoints, int joues, int victoire, int egalite, int defaite, int diff) {
		this.positionClassement = positionClassement;
		this.nomEquipe = nomEquipe;
		this.nbPoints = nbPoints;
		this.joues = joues;
		this.victoire = victoire;
		this.egalite = egalite;
		this.defaite = defaite;
		this.diff = diff;
	}

	public int getJoues() {
		return joues;
	}

	public void setJoues(int joues) {
		this.joues = joues;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	public int getPositionClassement() {
		return positionClassement;
	}

	public void setPositionClassement(int positionClassement) {
		this.positionClassement = positionClassement;
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
