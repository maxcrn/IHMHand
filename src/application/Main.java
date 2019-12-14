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
		
		try {
			primaryStage.setScene(new javafx.scene.Scene(javafx.fxml.FXMLLoader.load(getClass().getResource("accueil.fxml"))));
			primaryStage.show();
			primaryStage.setMaximized(true);
			primaryStage.setTitle("LNH Game Manager");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		launch(args);
	}
	

}
