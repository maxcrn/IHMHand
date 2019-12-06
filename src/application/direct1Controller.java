package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;

import javafx.scene.text.Text;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

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
	private TableView<String> liste_equipe1;
	@FXML
	private TableView<String> liste_equipe2;
	

///////////   CHRONOMETRE /////////////
	
	private ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
	int seconds = 0;
	int minutes = 0;
	boolean paused = false;
	
	// Event Listener on ImageView[#start_chrono].onMouseClicked
	
	@FXML
	public void startChrono(MouseEvent event) {
	    if(paused) {
	    	exec = Executors.newSingleThreadScheduledExecutor();
	    	exec.scheduleAtFixedRate(stopWatch,0,1000,TimeUnit.MILLISECONDS);
	    }
	    else {
	    	exec.scheduleAtFixedRate(stopWatch,0,1000,TimeUnit.MILLISECONDS);
	    }
	}
	
	@FXML
	public void pauseChrono(MouseEvent event) {
		exec.shutdown();
		paused = true;
	}
	
	
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
	
	public void changeText(Text text, String newTxt){
		text.setText(newTxt);
	}
	

}
