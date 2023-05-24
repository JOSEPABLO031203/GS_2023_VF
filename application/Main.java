package application;
	
import java.io.FileNotFoundException;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;


public class Main extends Application {
    static AudioClip lobby2= new AudioClip(Paths.get("src/sonidos/transformers-8.mp3").toUri().toString());

    private static Stage guiStage;
    private int x=(int) ((int) (Screen.getPrimary().getBounds().getWidth()));
    private int y=(int) ((int) (Screen.getPrimary().getBounds().getHeight()));
    static private SF_mode flight;
    static private SSim_Mode sim;
    static private LoadScreen ldS;
    public static void main(String[] args) {
    	System.out.println(".:|INITIALIZING GROUND STATION 2023|:.");

    	launch(args);

    }



    public static void setEscenaUno(){
        guiStage.setScene(flight);
    }
    public static void setEscenaDos(){
        guiStage.setScene(sim);
    }
    public static void setEscenaLoad() {
    	guiStage.setScene(ldS);
    }

    
    @Override
    public void start(Stage stage) throws FileNotFoundException {
//    	System.out.println(x+","+y);
        sim = new SSim_Mode(new StackPane(), x, y);
        flight = new SF_mode(new StackPane(), x, y);
        ldS = new LoadScreen(new StackPane(), x, y);
//    	System.out.println(x*0.12);
        //Inicializamos el escenario.
        guiStage = stage;	
        stage.setTitle("GCS Cuahtemoc");
        
        sim.getStylesheets().add(getClass().getResource("SIM.css").toExternalForm());
        flight.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        ldS.getStylesheets().add(getClass().getResource("Load.css").toExternalForm());

        
//        stage.initStyle(StageStyle.TRANSPARENT);
        sim.setFill(Color.TRANSPARENT);
        flight.setFill(Color.TRANSPARENT);
        ldS.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        stage.setMaximized(true);
        stage.setScene(ldS);
//		stage.getIcons().add(new Image("application/Icon.png"));
        stage.show();
    }
}
