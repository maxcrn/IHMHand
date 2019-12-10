package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class direct1Controller {
	
	
	
	int i = 0;
	
	@FXML
	public void initialize() {
		
		Text[] tituText = {t11, t12, t13, t14, t15, t16, t17, t21, t22, t23, t24, t25, t26, t27};
		Text[] rempText = {r11, r12, r13, r14, r15, r16, r17, r21, r22, r23, r24, r25, r26, r27};
		Joueur[] tituJoueur = {titu11, titu12, titu13, titu14, titu15, titu16, titu17, titu21, titu22, titu23, titu24, titu25, titu26, titu27};
		Joueur[] rempJoueur = {remp11, remp12, remp13, remp14, remp15, remp16, remp17, remp21, remp22, remp23, remp24, remp25, remp26, remp27};
		
		for(i = 0; i < 14; i++) {
			tituText[i].setText(tituJoueur[i].getNumero() + " " + tituJoueur[i].getPrenom().substring(0, 1) + ". " + tituJoueur[i].getNom());
			rempText[i].setText(rempJoueur[i].getNumero() + " " + rempJoueur[i].getPrenom().substring(0, 1) + ". " + rempJoueur[i].getNom());
		}
	}
	

///////////  CHRONOMETRE  /////////////
	
	@FXML
	private Text seconds_chrono, minutes_chrono;
	@FXML
	private ImageView start_chrono, pause_chrono;
	
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
		tempsMortD.setDisable(false);
		tempsMortG.setDisable(false);
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
		tempsMortD.setDisable(true);
		tempsMortG.setDisable(true);
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
        	else if(seconds >= 60){
        		seconds = 0;
        		changeText(seconds_chrono, "00");
        		minutes ++;
        	}
        	if(minutes < 10) {
        		changeText(minutes_chrono, "0" + Integer.toString(minutes));
			}
        	else{
        		changeText(minutes_chrono, Integer.toString(minutes));
        	}
        }
    };
	
    // Mettre à jour le texte du chrono
	public void changeText(Text text, String newTxt){
		text.setText(newTxt);
	}
	
	
	// TEMPS MORTS //
	
	
	@FXML
	private Text seconds_tm, minutes_tm;
	@FXML
	private Button tempsMortD, tempsMortG, tempsMortAnnuleD, tempsMortAnnuleG;
	@FXML
	private Pane tmPane;
	@FXML
	private ImageView tm1Equipe1, tm2Equipe1, tm3Equipe1, tm1Equipe2, tm2Equipe2, tm3Equipe2;
	
	
	private int secondsTM = 0;
	private int minutesTM = 0;
	private int secondsTemp = 0;
	private ScheduledExecutorService execTM;
	// A changer avec Equipe.TempsMort
	private int TMEquipe1 = 3;
	private int TMEquipe2 = 3;
	
	public void pressTM1(MouseEvent event) {
		startTM();
		TMEquipe1 --;
		tempsMortG.setVisible(false);
		tempsMortAnnuleG.setVisible(true);
		tempsMortD.setDisable(true);
		if(TMEquipe1 == 2) {
			tm1Equipe1.setVisible(false);
		}
		else if(TMEquipe1 == 1) {
			tm2Equipe1.setVisible(false);
		}
		else if(TMEquipe1 == 0) {
			tm3Equipe1.setVisible(false);
			tempsMortG.setDisable(true);
		}
	}
	
	public void pressTM2(MouseEvent event) {
		startTM();
		TMEquipe2 --;
		tempsMortD.setVisible(false);
		tempsMortAnnuleD.setVisible(true);
		tempsMortG.setDisable(true);
		if(TMEquipe2 == 2) {
			tm1Equipe2.setVisible(false);
		}
		else if(TMEquipe2 == 1) {
			tm2Equipe2.setVisible(false);
		}
		else if(TMEquipe2 == 0) {
			tm3Equipe2.setVisible(false);
			tempsMortD.setDisable(true);
		}
	}
	
	public void startTM() {
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
        	if(secondsTM == 5) {
        		FinTM();
        		
        	}
        }
    };
    
    public void FinTM() {
    	secondsTM = 0;
		minutesTM = 0;
		startChrono();
		tmPane.setVisible(false);
		changeText(seconds_tm, "0" + Integer.toString(secondsTM));
		changeText(minutes_tm, "0" + Integer.toString(minutesTM));
		execTM.shutdown();
		tempsMortAnnuleD.setVisible(false);
		tempsMortAnnuleG.setVisible(false);
    	tempsMortD.setVisible(true);
    	tempsMortG.setVisible(true);
    	tempsMortD.setDisable(false);
    	tempsMortG.setDisable(false);
    }
    
    public void PressAnnuleTM1(MouseEvent event) {
    	tempsMortAnnuleG.setVisible(false);
    	tempsMortG.setVisible(true);
    	TMEquipe1++;
    	if(TMEquipe1 == 3) {
			tm1Equipe1.setVisible(true);
		}
		else if(TMEquipe1 == 2) {
			tm2Equipe1.setVisible(true);
		}
		else if(TMEquipe1 == 1) {
			tm3Equipe1.setVisible(true);
			tempsMortG.setDisable(false);
		}
    	FinTMAnnule();
    }
    
    public void PressAnnuleTM2(MouseEvent event) {
    	tempsMortAnnuleD.setVisible(false);
    	tempsMortD.setVisible(true);
    	TMEquipe2++;
    	if(TMEquipe2 == 3) {
			tm1Equipe2.setVisible(true);
		}
		else if(TMEquipe2 == 2) {
			tm2Equipe2.setVisible(true);
		}
		else if(TMEquipe2 == 1) {
			tm3Equipe2.setVisible(true);
			tempsMortD.setDisable(false);
		}
    	FinTMAnnule();
    }
    
    
    public void FinTMAnnule() {
    	seconds += secondsTM;
    	if(seconds > 60) {
    		secondsTemp = seconds-60;
    		seconds = secondsTemp;
    		minutes++;
    	}
    	FinTM();
    }
    
///////////  Liste des joueurs  /////////////


    @FXML
	private Text r11, r12, r13, r14, r15, r16, r17;
	@FXML
	private Text r21, r22, r23, r24, r25, r26, r27;
	@FXML
	private Text t11, t12, t13, t14, t15, t16, t17;
	@FXML
	private Text t21, t22, t23, t24, t25, t26, t27;
	@FXML
	private AnchorPane rempEqu1, rempEqu2, tituEqu1, tituEqu2;
	
	Personne entraineur1 = new Personne("CANAYER", "Patrice");
	Equipe equipe1 = new Equipe("Montpellier", entraineur1, "LidlStarligue");
	
	// Liste joueurs equipe 1
	Joueur titu11 = new Gardien("SEGO", "Marin", equipe1, "1", true);
	Joueur remp11 = new Gardien("BONNEFOI", "Kevin", equipe1, "12", false);
	Joueur titu12 = new JoueurChamp("AFGOUR", "Benjamin", equipe1, "33", true);
	Joueur titu13 = new JoueurChamp("BOS", "Julien", equipe1, "13", true);
	Joueur titu14 = new JoueurChamp("DUARTE", "Gilberto", equipe1, "90", true);
	Joueur titu15 = new JoueurChamp("GUIRAUDOU", "Paul Louis", equipe1, "2", true);
	Joueur titu16 = new JoueurChamp("LENNE", "Yanis", equipe1, "32", true);
	Joueur titu17 = new JoueurChamp("MENGON", "Marco", equipe1, "15", true);
	Joueur remp12 = new JoueurChamp("PETTERSSON", "Frederic", equipe1, "18", false);
	Joueur remp13 = new JoueurChamp("PORTE", "Valentin", equipe1, "28", false);
	Joueur remp14 = new JoueurChamp("RICHARDSON", "Melvyn", equipe1, "22", false);
	Joueur remp15 = new JoueurChamp("SIMONET", "Diego", equipe1, "4", false);
	Joueur remp16 = new JoueurChamp("SOUSSI", "Mohammed", equipe1, "39", false);
	Joueur remp17 = new JoueurChamp("GREBILLE", "Mathieu", equipe1, "10", false);
	
	
	Personne entraineur2 = new Personne("GARDENT", "Philippe");
	Equipe equipe2 = new Equipe("Toulouse", entraineur2, "LidlStarligue");
	// Liste joueurs equipe 2
	Joueur titu21 = new Gardien("LETTENS", "Jef", equipe2, "1", true);
	Joueur remp21 = new Gardien("GEHIN", "Theo", equipe2, "12", false);
	Joueur titu22 = new JoueurChamp("LEVENTOUX", "Remi", equipe2, "2", true);
	Joueur titu23 = new JoueurChamp("CHELLE", "Pierrick", equipe2, "3", true);
	Joueur titu24 = new JoueurChamp("OLSSON", "Markus", equipe2, "4", true);
	Joueur titu25 = new JoueurChamp("GARCIA", "Arnau", equipe2, "9", true);
	Joueur titu26 = new JoueurChamp("GILBERT", "Maxime", equipe2, "10", true);
	Joueur titu27 = new JoueurChamp("SOLE", "Ferran", equipe2, "14", true);
	Joueur remp22 = new JoueurChamp("ILIC", "Nemanja", equipe2, "19", false);
	Joueur remp23 = new JoueurChamp("STEINS", "Luc", equipe2, "22", false);
	Joueur remp24 = new JoueurChamp("TRIBILLON", "Gael", equipe2, "33", false);
	Joueur remp25 = new JoueurChamp("BONILAURI", "Jordan", equipe2, "47", false);
	Joueur remp26 = new JoueurChamp("ABDI", "Ayoub", equipe2, "87", false);
	Joueur remp27 = new JoueurChamp("GIRAUDEAU", "Romain", equipe2, "11", false);
	
	@FXML
	Text[] tituText = {t11, t12, t13, t14, t15, t16, t17, t21, t22, t23, t24, t25, t26, t27};
	@FXML
	Text[] rempText = {r11, r12, r13, r14, r15, r16, r17, r21, r22, r23, r24, r25, r26, r27};
	Joueur[] rempJoueur = {remp11, remp12, remp13, remp14, remp15, remp16, remp17, remp21, remp22, remp23, remp24, remp25, remp26, remp27};
	Joueur[] tituJoueur = {titu11, titu12, titu13, titu14, titu15, titu16, titu17, titu21, titu22, titu23, titu24, titu25, titu26, titu27};
    
    public void dragDetected(MouseEvent event) {
    	
    	Text textDragged = (Text) event.getSource();
    	
    	/* allow any transfer mode */
        Dragboard db = textDragged.startDragAndDrop(TransferMode.ANY);
        
        /* put a string on dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(textDragged.getText());
        db.setContent(content);
    }
    
    public void dragOver(DragEvent event) {
    	Text target = (Text) event.getGestureTarget();
    	if (event.getGestureSource() != target && event.getDragboard().hasString()) {
            /* allow for both copying and moving, whatever user chooses */
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
    }
    
    public void dragDropped(DragEvent event) {
    	Joueur tituRemp = titu11;
    	Joueur rempTitu = titu21;
    	Text target = (Text) event.getGestureTarget();
    	Text source = (Text) event.getGestureSource();
    	
        
        for(i = 0; i < 14; i++) {
			if(source.getText().equals(tituJoueur[i].getNumero() + " " + tituJoueur[i].getPrenom().substring(0, 1) + ". " + tituJoueur[i].getNom())) {
				tituRemp = tituJoueur[i];
			}
			else if(source.getText().equals(rempJoueur[i].getNumero() + " " + rempJoueur[i].getPrenom().substring(0, 1) + ". " + rempJoueur[i].getNom())){
				rempTitu = rempJoueur[i];
			}
		}
        for(i = 0; i < 14; i++) {
			if(target.getText().equals(tituJoueur[i].getNumero() + " " + tituJoueur[i].getPrenom().substring(0, 1) + ". " + tituJoueur[i].getNom())) {
				tituRemp = tituJoueur[i];
			}
			else if(target.getText().equals(rempJoueur[i].getNumero() + " " + rempJoueur[i].getPrenom().substring(0, 1) + ". " + rempJoueur[i].getNom())){
				rempTitu = rempJoueur[i];
			}
		}
        
        if(tituRemp.getEquipe() == rempTitu.getEquipe() && rempTitu.isTitulaire() != tituRemp.isTitulaire()) {
        	tituRemp.setTitulaire(!tituRemp.isTitulaire());
        	rempTitu.setTitulaire(!rempTitu.isTitulaire());
        	String tempTxt = target.getText();
        	source.setText(tempTxt);
        	Dragboard db = event.getDragboard();
            if (db.hasString()) {
                target.setText(db.getString());
            }
        }
    }
    
///////////  Liste des joueurs actions : 2 mins, cartons et tirs /////////////    
    
    Joueur joueurSelectionne;
    @FXML
    private ImageView cartonEq1, deuxMinEq1, tirEq1, cartonEq2, deuxMinEq2, tirEq2, addRedCard;
    @FXML
    private Pane cardsPane;
    @FXML
    private Text testCarton;
    @FXML
    private Text joueurSelectionne_Text;
    
    public void selectionJoueur(MouseEvent event) {
    	
    	Text textClick = (Text) event.getSource();
    	Text[] tituText = {t11, t12, t13, t14, t15, t16, t17, t21, t22, t23, t24, t25, t26, t27};
    	Text[] rempText = {r11, r12, r13, r14, r15, r16, r17, r21, r22, r23, r24, r25, r26, r27};
    	
    	for(i = 0; i < 14; i++) {
			if(textClick.getText().equals(tituJoueur[i].getNumero() + " " + tituJoueur[i].getPrenom().substring(0, 1) + ". " + tituJoueur[i].getNom())) {
				joueurSelectionne = tituJoueur[i];
				if(textClick.getText().equals(tituText[i].getText())) {
					joueurSelectionne_Text = tituText[i];
				}
				else if(textClick.getText().equals(rempText[i].getText())) {
					joueurSelectionne_Text = rempText[i];
				}
				cartonEq1.setDisable(false);
				deuxMinEq1.setDisable(false);
				tirEq1.setDisable(false);
				cartonEq2.setDisable(false);
				deuxMinEq2.setDisable(false);
				tirEq2.setDisable(false);
			}
			else if(textClick.getText().equals(rempJoueur[i].getNumero() + " " + rempJoueur[i].getPrenom().substring(0, 1) + ". " + rempJoueur[i].getNom())) {
				joueurSelectionne = rempJoueur[i];
				if(textClick.getText().equals(tituText[i].getText())) {
					joueurSelectionne_Text = tituText[i];
				}
				else if(textClick.getText().equals(rempText[i].getText())) {
					joueurSelectionne_Text = rempText[i];
				}
				System.out.println(joueurSelectionne.getNom());
				cartonEq1.setDisable(false);
				deuxMinEq1.setDisable(false);
				tirEq1.setDisable(false);
				cartonEq2.setDisable(false);
				deuxMinEq2.setDisable(false);
				tirEq2.setDisable(false);
			}
			
    	}
    }
    
///////////  Cartons : rouge, jaune et bleu /////////////     
    public void cartonEq1_Click(MouseEvent event) {
    	if(joueurSelectionne.getEquipe().getNomEquipe().equals(equipe1.getNomEquipe())) {
    		System.out.println(joueurSelectionne.getNom());
    		cardsPane.setVisible(true);
    		addRedCard.setDisable(false);
    		
    	}
    }
    
    public void addRedCard_Click(MouseEvent event) {
    	System.out.println("redcard");
    	for(i = 0; i < 14; i++) {
    		if(joueurSelectionne_Text == tituText[i]) {
    			System.out.println("j'essaie de changer");
    			//tituText[i].setStyle("-fx-highlight-fill: red;");
    			//testCarton.setStyle("-fx-highlight-fill: red;");
    			//testCarton.getStyleClass().add("-fx-highlight-fill: red;");
    			//testCarton.setId("redcardtext");
    			
    		}
    	}
    	//joueurSelectionne_Text.setStyle("-fx-highlight-fill: red;");
    	// Incrémenter le setCarton_rouge
    }
    
    /*public void addYellowCard_Click(MouseEvent event) {
    	System.out.println("yellowcard");
    	// Incrémenter le setCarton_jaune
    }
    
    public void addBlueCard_Click(MouseEvent event) {
    	System.out.println("bluecard");
    	// Incrémenter le setCarton_bleu
    }*/

    
    
    ///// 2 MINUTES /////
    
    
    @FXML
    private Text deuxMinEq1Min, deuxMinEq1Sec, deuxMinEq2Min, deuxMinEq2Sec;
    @FXML
    private Pane deuxMinEq1Pane, deuxMinEq2Pane;
    
    private ScheduledExecutorService exec2MinEq1, exec2MinEq2;
    private int seconds2MinEq1, minutes2MinEq1, seconds2MinEq2, minutes2MinEq2;
    
    Joueur joueurDeuxMinEq1, joueurDeuxMinEq2;
    @FXML
    Text joueurDeuxMinEq1Text, joueurDeuxMinEq2Text;
    
    public void deuxMinEq1Click(MouseEvent event) {
    	joueurDeuxMinEq1 = joueurSelectionne;
    	joueurDeuxMinEq1Text = joueurSelectionne_Text;
    	joueurDeuxMinEq1.setDeux_min(joueurDeuxMinEq1.getDeux_min()+1);
    	start2Min();
    	cartonEq1.setDisable(true);
		deuxMinEq1.setDisable(true);
		tirEq1.setDisable(true);
		joueurDeuxMinEq1Text.setDisable(true);
    }
    
    public void deuxMinEq2Click(MouseEvent event) {
    	joueurDeuxMinEq2 = joueurSelectionne;
    	joueurDeuxMinEq2Text = joueurSelectionne_Text;
    	joueurDeuxMinEq2.setDeux_min(joueurDeuxMinEq2.getDeux_min()+1);
    	start2Min();
    	cartonEq2.setDisable(true);
		deuxMinEq2.setDisable(true);
		tirEq2.setDisable(true);
		joueurDeuxMinEq2Text.setDisable(true);
    }
    
    private void start2Min() {
    	if(joueurSelectionne.getEquipe() == equipe1) {
    		deuxMinEq1Pane.setVisible(true);
        	exec2MinEq1 = Executors.newSingleThreadScheduledExecutor();
        	exec2MinEq1.scheduleAtFixedRate(stopWatchDeuxMinEq1,1000,1000,TimeUnit.MILLISECONDS);
    	}
    	else if(joueurSelectionne.getEquipe() == equipe2){
    		deuxMinEq2Pane.setVisible(true);
        	exec2MinEq2 = Executors.newSingleThreadScheduledExecutor();
        	exec2MinEq2.scheduleAtFixedRate(stopWatchDeuxMinEq2,1000,1000,TimeUnit.MILLISECONDS);
    	}
    }
    
    private void Fin2MinEq1() {
    	seconds2MinEq1 = 0;
    	minutes2MinEq1 = 0;
		deuxMinEq1Pane.setVisible(false);
		changeText(deuxMinEq1Sec, "0" + Integer.toString(seconds2MinEq1));
		changeText(deuxMinEq1Min, "0" + Integer.toString(minutes2MinEq1));
		exec2MinEq1.shutdown();
		joueurDeuxMinEq1Text.setDisable(false);
    }
    
    private void Fin2MinEq2() {
    	seconds2MinEq2 = 0;
    	minutes2MinEq2 = 0;
		deuxMinEq2Pane.setVisible(false);
		changeText(deuxMinEq2Sec, "0" + Integer.toString(seconds2MinEq1));
		changeText(deuxMinEq2Min, "0" + Integer.toString(minutes2MinEq1));
		exec2MinEq2.shutdown();
		joueurDeuxMinEq2Text.setDisable(false);
    }
    
    
    final Runnable stopWatchDeuxMinEq1 = new Runnable() {
		
        public void run() {
    		seconds2MinEq1++;
        	if(seconds2MinEq1 < 10) {
        		changeText(deuxMinEq1Sec, "0" + Integer.toString(seconds2MinEq1));
			}
        	else if(seconds2MinEq1 < 60) {
        		changeText(deuxMinEq1Sec, Integer.toString(seconds2MinEq1));
        	}
        	else if(seconds2MinEq1 == 60){
        		seconds2MinEq1 = 0;
        		changeText(deuxMinEq1Sec, "00");
        		minutes2MinEq1 ++;
            	changeText(deuxMinEq1Min, "0" + Integer.toString(minutes2MinEq1));
        	}
        	if(seconds2MinEq1 == 5) {
        		Fin2MinEq1();
        		
        	}
        }
    };
    
    final Runnable stopWatchDeuxMinEq2 = new Runnable() {
		
        public void run() {
    		seconds2MinEq2++;
        	if(seconds2MinEq2 < 10) {
        		changeText(deuxMinEq2Sec, "0" + Integer.toString(seconds2MinEq2));
			}
        	else if(seconds2MinEq2 < 60) {
        		changeText(deuxMinEq2Sec, Integer.toString(seconds2MinEq2));
        	}
        	else if(seconds2MinEq2 == 60){
        		seconds2MinEq2 = 0;
        		changeText(deuxMinEq2Sec, "00");
        		minutes2MinEq2 ++;
            	changeText(deuxMinEq2Min, "0" + Integer.toString(minutes2MinEq2));
        	}
        	if(seconds2MinEq2 == 5) {
        		Fin2MinEq2();
        	}
        }
    };
    
}
