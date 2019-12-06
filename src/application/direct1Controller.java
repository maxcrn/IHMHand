package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;

import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class direct1Controller {
	@FXML
	private Text seconds_chrono;
	@FXML
	private ImageView start_chrono;
	@FXML
	private ImageView pause_chrono;
	@FXML
	private Text minutes_chrono;
	@FXML
	private Text seconds_tm;
	@FXML
	private Text minutes_tm;
	@FXML
	private Button tempsMortD;
	@FXML
	private Button tempsMortG;
	@FXML
	private Pane tmPane;
	@FXML
	private TableView<String> liste_equipe1;
	@FXML
	private TableView<String> liste_equipe2;
	

///////////  CHRONOMETRE  /////////////
	
	private ScheduledExecutorService execSW = Executors.newSingleThreadScheduledExecutor();
	int seconds = 0;
	int minutes = 0;
	boolean paused = false;
	
	// Bouton start du chrono
	@FXML
	public void pressStart(MouseEvent event) {
	    startChrono();
	}
	
	public void startChrono() {
		if(paused) {
	    	execSW = Executors.newSingleThreadScheduledExecutor();
	    	execSW.scheduleAtFixedRate(stopWatch,1000,1000,TimeUnit.MILLISECONDS);
	    	start_chrono.setScaleX(0);
	    	pause_chrono.setScaleX(1);
	    }
	    else {
	    	execSW.scheduleAtFixedRate(stopWatch,1000,1000,TimeUnit.MILLISECONDS);
	    	start_chrono.setScaleX(0);
	    	pause_chrono.setScaleX(1);
	    }
	}
	
	// Bouton pause du chrono
	@FXML
	public void pressPause(MouseEvent event) {
		pauseChrono();
		pause_chrono.setScaleX(0);
		start_chrono.setScaleX(1);
	}
	
	public void pauseChrono() {
		execSW.shutdown();
		paused = true;
	}
	
	
	// Runnable chrono
	final Runnable stopWatch = new Runnable() {
		
        public void run() {
        	
        	seconds++;
        	if(seconds < 10) {
        		changeText(seconds_chrono, "0" + Integer.toString(seconds));
			}
        	else if(seconds < 60) {
        		changeText(seconds_chrono, Integer.toString(seconds));
        	}
        	else if(seconds == 60){
        		seconds = 0;
        		changeText(seconds_chrono, "00");
        		minutes ++;
        		if(minutes < 10) {
            		changeText(minutes_chrono, "0" + Integer.toString(minutes));
    			}
            	else{
            		changeText(minutes_chrono, Integer.toString(minutes));
            	}
        	}
        }
    };
	
    // Mettre à jour le texte du chrono
	public void changeText(Text text, String newTxt){
		text.setText(newTxt);
	}
	
	
	// TEMPS MORTS //
	
	private int secondsTM = 0;
	private int minutesTM = 0;
	private ScheduledExecutorService execTM;
	
	public void startTM(MouseEvent event) {
		tmPane.setVisible(true);
		execTM = Executors.newSingleThreadScheduledExecutor();
		execTM.scheduleAtFixedRate(stopWatchTM,1000,1000,TimeUnit.MILLISECONDS);
		pauseChrono();
	}
	
final Runnable stopWatchTM = new Runnable() {
		
        public void run() {
        	
        	secondsTM++;
        	if(secondsTM < 10) {
        		changeText(seconds_tm, "0" + Integer.toString(secondsTM));
			}
        	else if(secondsTM < 60) {
        		changeText(seconds_tm, Integer.toString(secondsTM));
        	}
        	else if(secondsTM == 60){
        		secondsTM = 0;
        		changeText(seconds_tm, "00");
        		minutesTM ++;
            	changeText(minutes_tm, "0" + Integer.toString(minutesTM));
        	}
        	if(secondsTM == 2) {
        		secondsTM = 0;
        		minutesTM = 0;
        		startChrono();
        		tmPane.setVisible(false);
        		changeText(seconds_tm, "0" + Integer.toString(secondsTM));
        		changeText(minutes_tm, "0" + Integer.toString(minutesTM));
        		execTM.shutdown();
        	}
        }
    };
	

}
