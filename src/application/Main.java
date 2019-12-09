package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		// Liste joueurs équipe 1
		Gardien g11 = new Gardien("SEGO", "Marin", "Montpellier", "#1");
		Gardien g12 = new Gardien("BONNEFOI", "Kévin", "Montpellier", "#12");
		JoueurChamp j11 = new JoueurChamp("AFGOUR", "Benjamin", "Montpellier", "#33");
		JoueurChamp j12 = new JoueurChamp("BOS", "Julien", "Montpellier", "#13");
		JoueurChamp j13 = new JoueurChamp("DUARTE", "Gilberto", "Montpellier", "#90");
		JoueurChamp j14 = new JoueurChamp("GUIRAUDOU", "Paul Louis", "Montpellier", "#2");
		JoueurChamp j15 = new JoueurChamp("LENNE", "Yanis", "Montpellier", "#32");
		JoueurChamp j16 = new JoueurChamp("MENGON", "Marco", "Montpellier", "#15");
		JoueurChamp j17 = new JoueurChamp("PETTERSSON", "Fréderic", "Montpellier", "#18");
		JoueurChamp j18 = new JoueurChamp("PORTE", "Valentin", "Montpellier", "#28");
		JoueurChamp j19 = new JoueurChamp("RICHARDSON", "Melvyn", "Montpellier", "#22");
		JoueurChamp j110 = new JoueurChamp("SIMONET", "Diego", "Montpellier", "#4");
		JoueurChamp j111 = new JoueurChamp("SOUSSI", "Mohammed", "Montpellier", "#39");
		JoueurChamp j112 = new JoueurChamp("TRUCHANOVICIUS", "Jonas", "Montpellier", "#7");
		
		// Liste joueurs équipe 2
		Gardien g21 = new Gardien("LETTENS", "Jef", "Toulouse", "#1");
		Gardien g22 = new Gardien("GEHIN", "Théo", "Toulouse", "#12");
		JoueurChamp j21 = new JoueurChamp("LEVENTOUX", "Rémi", "Toulouse", "#2");
		JoueurChamp j22 = new JoueurChamp("CHELLE", "Pierrick", "Toulouse", "#3");
		JoueurChamp j23 = new JoueurChamp("OLSSON", "Markus", "Toulouse", "#4");
		JoueurChamp j24 = new JoueurChamp("GARCIA", "Arnau", "Toulouse", "#9");
		JoueurChamp j25 = new JoueurChamp("GILBERT", "Maxime", "Toulouse", "#10");
		JoueurChamp j26 = new JoueurChamp("SOLE", "Ferran", "Toulouse", "#14");
		JoueurChamp j27 = new JoueurChamp("ILIC", "Nemanja", "Toulouse", "#19");
		JoueurChamp j28 = new JoueurChamp("STEINS", "Luc", "Toulouse", "#22");
		JoueurChamp j29 = new JoueurChamp("TRIBILLON", "Gaël", "Toulouse", "#33");
		JoueurChamp j210 = new JoueurChamp("BONILAURI", "Jordan", "Toulouse", "#47");
		JoueurChamp j211 = new JoueurChamp("ABDI", "Ayoub", "Toulouse", "#87");
		JoueurChamp j212 = new JoueurChamp("GIRAUDEAU", "Romain", "Toulouse", "#11");
		
		
		
		try {
			primaryStage.setScene(new javafx.scene.Scene(javafx.fxml.FXMLLoader.load(getClass().getResource("accueil.fxml"))));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		launch(args);
	}
	

}
