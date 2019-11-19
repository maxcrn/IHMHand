package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class accueilController {
	@FXML
	private Button button_match1;

	// Event Listener on Button[#button_match1].onAction
	@FXML
	public void pageDirect1(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("direct1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Direct LIDL StarLigue");
        stage.setScene(scene);
        stage.show();
		
	}
}
