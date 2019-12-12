package application;



public class Gardien extends Joueur {
	
	private int arrets;
	
	//Constructeur
	public Gardien(String nom, String prenom, Equipe equipe, String numero, boolean titulaire) {
		super(nom, prenom, equipe, numero, titulaire);
		this.arrets = 0;
	}
	
	public int getArrets() {
		return arrets;
	}

	public void setArrets(int arrets) {
		this.arrets = arrets;
	}

}
