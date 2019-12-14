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
	private Button button_match1, button_classement1;

	@FXML
	public void pageDirect1() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("direct1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Match en Direct LIDL StarLigue");
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
		
	}
	
	public void pageClassement1() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("classement1.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load(), 1024, 768);
        Stage stage2 = new Stage();
        stage2.setTitle("Classement et Calendrier LIDL StarLigue");
        stage2.setScene(scene2);
        stage2.show();
        //stage2.setMaximized(true);
		
	}
}
