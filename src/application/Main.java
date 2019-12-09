package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private ObservableList<JoueurChamp> joueurData = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) {
		
	 	joueurData.add(new JoueurChamp("BERCOT", "Julien", "Hoegaarden", "69"));
	 	
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
