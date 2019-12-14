package application;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class classement1Controller {

///////////  Classement Ligue /////////////
	
	@FXML
	private Pane classementPane, classementTirPane, classementArretPane, calendrierPane, statsMatchPane, statsEquipePane;
	
	public void classementClick() {
		classementPane.setVisible(true);
		classementTirPane.setVisible(false);
		classementArretPane.setVisible(false);
		calendrierPane.setVisible(false);
		statsMatchPane.setVisible(false);
		statsEquipePane.setVisible(false);
	}
	
	
	@FXML
	public void initialize() {
		classementPane.setVisible(false);
		classementTirPane.setVisible(false);
		classementArretPane.setVisible(false);
		calendrierPane.setVisible(false);
		statsMatchPane.setVisible(false);
		statsEquipePane.setVisible(false);
	}
	
	
///////////  Classement Tirs /////////////
	
	public void classementTirClick() {
		classementPane.setVisible(false);
		classementTirPane.setVisible(true);
		classementArretPane.setVisible(false);
		calendrierPane.setVisible(false);
		statsMatchPane.setVisible(false);
		statsEquipePane.setVisible(false);
	}
	
	
///////////  Classement Arrets /////////////
	
	public void classementArretClick() {
		classementPane.setVisible(false);
		classementTirPane.setVisible(false);
		classementArretPane.setVisible(true);
		calendrierPane.setVisible(false);
		statsMatchPane.setVisible(false);
		statsEquipePane.setVisible(false);
	}
	
///////////  Calendrier /////////////
	
	public void calendrierClick() {
		classementPane.setVisible(false);
		classementTirPane.setVisible(false);
		classementArretPane.setVisible(false);
		calendrierPane.setVisible(true);
		statsMatchPane.setVisible(false);
		statsEquipePane.setVisible(false);
	}
	
	public void statsMatchClick() {
		classementPane.setVisible(false);
		classementTirPane.setVisible(false);
		classementArretPane.setVisible(false);
		calendrierPane.setVisible(false);
		statsMatchPane.setVisible(true);
		statsEquipePane.setVisible(false);
	}
	
	public void statsEquipePaneClick() {
		classementPane.setVisible(false);
		classementTirPane.setVisible(false);
		classementArretPane.setVisible(false);
		calendrierPane.setVisible(false);
		statsMatchPane.setVisible(false);
		statsEquipePane.setVisible(true);
	}
}
