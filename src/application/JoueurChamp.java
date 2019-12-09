package application;

import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JoueurChamp extends Joueur {
	
	private int tirs;
	private int buts;
	
	//Constructeur
	public JoueurChamp(String nom, String prenom, String equipe, String numero) {
		super(nom, prenom, equipe, numero);
		this.tirs = 0;
		this.buts = 0;
	}
	
	public int getTirs() {
		return tirs;
	}

	public void setTirs(int tirs) {
		this.tirs = tirs;
	}

	public int getButs() {
		return buts;
	}

	public void setButs(int buts) {
		this.buts = buts;
	}
	
	
}
