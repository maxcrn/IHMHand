package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {
	private final StringProperty nom;
	private final StringProperty prenom;
	
	public Personne(String nom, String prenom) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
	}
	
	public StringProperty getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}

	public StringProperty getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}
}
