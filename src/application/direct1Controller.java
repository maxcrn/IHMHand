package application;



import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;

import javafx.scene.text.Text;
import javafx.scene.control.Label;
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
	private Label test;
	Timer timer = new Timer();
	int seconds = 0;
	int minutes = 0;
	// Event Listener on ImageView[#start_chrono].onMouseClicked
	@FXML
	public void startChrono(MouseEvent event){

		Timer timer = new Timer();
	    timer.scheduleAtFixedRate(task,0,1000);
		
		
		
		/*while(seconds < 5 && minutes < 60) {
			System.out.print("courcou");
			//Thread.sleep(1000);
			seconds+=seconds;
			if(seconds < 10) {
				seconds_chrono.setText("0");
				System.out.print("marche");
			}
			seconds_chrono.setText(Integer.toString(seconds));
			if(seconds == 60) {
				minutes+=minutes;
				if(minutes < 10) {
					seconds_chrono.setText("0" + Integer.toString(minutes));
				}
				minutes_chrono.setText(Integer.toString(minutes));
				seconds=0;
			}
		}*/
	}
	@FXML
	public void pauseChrono(MouseEvent event) {
		// TODO Autogenerated
	}
	
	TimerTask task = new TimerTask() {
        @Override
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
	
	public void changeText(Text text, String hello){
		text.setText(hello);
	}
}
