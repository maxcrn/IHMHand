package application;


public class Joueur extends Personne {
	
	private boolean titulaire;
	private int carton_rouge;
	private int carton_bleu;
	private int carton_jaune;
	private int deux_min;
	private String equipe;
	private String numero;
	
	//Constructeur
	public Joueur (String nom, String prenom, String equipe, String numero, boolean titulaire) {
		super(nom,prenom);
		this.titulaire = titulaire;
		this.equipe = equipe;
		this.numero = numero;
		this.carton_bleu = 0;
		this.carton_rouge = 0;
		this.carton_jaune = 0;
		this.deux_min = 0;
	}
	
	public boolean isTitulaire() {
		return titulaire;
	}

	public void setTitulaire(boolean titulaire) {
		this.titulaire = titulaire;
	}

	public int getCarton_rouge() {
		return carton_rouge;
	}

	public void setCarton_rouge(int carton_rouge) {
		this.carton_rouge = carton_rouge;
	}

	public int getCarton_bleu() {
		return carton_bleu;
	}

	public void setCarton_bleu(int carton_bleu) {
		this.carton_bleu = carton_bleu;
	}

	public int getCarton_jaune() {
		return carton_jaune;
	}

	public void setCarton_jaune(int carton_jaune) {
		this.carton_jaune = carton_jaune;
	}

	public int getDeux_min() {
		return deux_min;
	}

	public void setDeux_min(int deux_min) {
		this.deux_min = deux_min;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
}
