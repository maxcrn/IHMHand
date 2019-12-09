package application;



public class Gardien extends Joueur {
	
	private int arrets;
	private int buts;
	
	//Constructeur
	public Gardien(String nom, String prenom, String equipe, String numero) {
		super(nom, prenom, equipe, numero);
		this.arrets = 0;
		this.buts = 0;
	}
	
	public int getArrets() {
		return arrets;
	}

	public void setArrets(int arrets) {
		this.arrets = arrets;
	}

	public int getButs() {
		return buts;
	}

	public void setButs(int buts) {
		this.buts = buts;
	}


}
