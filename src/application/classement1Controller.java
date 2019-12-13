package application;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class classement1Controller {

///////////  Classement Ligue /////////////
	
	@FXML
	private Pane classementPane, classementTirPane, classementArretPane;
	
	public void classementClick() {
		classementPane.setVisible(true);
		classementTirPane.setVisible(false);
		classementArretPane.setVisible(false);
	}
	
	
	@FXML
	public void initialize() {
		
	}
	
	
///////////  Classement Tirs /////////////
	
	public void classementTirClick() {
		classementPane.setVisible(false);
		classementTirPane.setVisible(true);
		classementArretPane.setVisible(false);
	}
	
	
///////////  Classement Arrêts /////////////
	
	public void classementArretClick() {
		classementPane.setVisible(false);
		classementTirPane.setVisible(false);
		classementArretPane.setVisible(true);
	}
}
