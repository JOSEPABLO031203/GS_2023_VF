package application;

import java.nio.file.Paths;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class LoadScreen extends Scene{
    static AudioClip lobby2= new AudioClip(Paths.get("src/sonidos/transformers-8.mp3").toUri().toString());
    static AudioClip btnPORTO= new AudioClip(Paths.get("src/sonidos/bonito.mp3").toUri().toString());


	public LoadScreen(Pane root, int x, int y) {
		super(root, x, y);
		lobby2.play();
       DropShadow sh = new DropShadow();
       DropShadow sh2 = new DropShadow();
     
       sh.setColor(Color.WHITE);
//        System.out.println(x+","+y);
    	//Se a�ade el Grid a la escena y se le dan las dimensiones nativas de la pantalla.
		GridPane raiz = new GridPane();
		
		//Se divide el grid en un n�mero determinado de filas y columnas
		
        	ColumnConstraints colum = new ColumnConstraints(x);
        	raiz.getColumnConstraints().add(colum);
        
	for(int i=0;i<2;i++) {
        	RowConstraints row = new RowConstraints(y/2);
        	raiz.getRowConstraints().add(row);
	}
        	raiz.getStyleClass().add("mygridStyle");
        	raiz.setGridLinesVisible(false);
        	
        	GridPane Grid_Datos1 = new GridPane();
  	        Grid_Datos1.getStyleClass().add("mygridStyle");
  	      for(int i=0;i<3;i++) {
  	        ColumnConstraints colum2 = new ColumnConstraints(x/3);
  	        Grid_Datos1.getColumnConstraints().add(colum2);
  	      }
  	        
  	      RowConstraints row2= new RowConstraints();
  	       row2.setPercentHeight(100);
  	     
  	        
  	       Grid_Datos1.getRowConstraints().add(row2);
  		 
  	        Grid_Datos1.setGridLinesVisible(false);
  	        raiz.add(Grid_Datos1, 0, 0);	
  	        sh2.setColor(Color.AQUA);
  	      ImageView imageViewL = new ImageView(new Image("IMG/CB.png"));
  	      HBox container1 = new HBox();
  	      ImageView imageViewL2 = new ImageView(new Image("IMG/CA.png"));
  	      ImageView imageViewL3 = new ImageView(new Image("IMG/LOGO_TEST.png"));
				imageViewL.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						imageViewL.setEffect(sh2);
					}
				});
				imageViewL.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						imageViewL.setEffect(null);
					}
				});
				imageViewL.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						 btnPORTO.play();
							Platform.exit();
							System.exit(0);
						System.out.println("EXIT...");
						event.consume();
					}
				});
  	      
  	      
  	        
  	    Grid_Datos1.add(imageViewL, 1,0);
  	    imageViewL.setX(0);
		imageViewL.setY(0);
		imageViewL.setFitWidth(y * 0.35);
		imageViewL.setPreserveRatio(true);
		 GridPane.setHalignment(imageViewL, HPos.CENTER);
		 GridPane.setValignment(imageViewL, VPos.BOTTOM);
		
		HBox hbox = new HBox();
		 Grid_Datos1.add(imageViewL2, 1,0);
	  	    imageViewL2.setX(0);
			imageViewL2.setY(0);
			imageViewL2.setFitWidth(y * 0.35);
			imageViewL2.setPreserveRatio(true);
			 GridPane.setHalignment(imageViewL2, HPos.CENTER);
			 GridPane.setValignment(imageViewL2, VPos.BOTTOM);
			 hbox.getChildren().add(imageViewL3);
			 hbox.setPadding(new Insets(130,0,0,0));
			 Grid_Datos1.add(hbox, 1,0);
		  	    imageViewL3.setX(0);
				imageViewL3.setY(0);
				imageViewL3.setFitWidth(y * 0.25);
				imageViewL3.setPreserveRatio(true);
				hbox.setAlignment(Pos.CENTER);
//				 hbox.setHalignment(hbox, HPos.CENTER);
//				 hbox.setValignment(hbox, VPos.BOTTOM);
		     RotateTransition rt = new RotateTransition(Duration.millis(2000), imageViewL);
		     rt.setByAngle(-160);
		     rt.setCycleCount(Timeline.INDEFINITE);
		     rt.setAutoReverse(false);
		 
		     rt.play();
		        
		     RotateTransition rt2 = new RotateTransition(Duration.millis(1900), imageViewL2);
		     rt2.setByAngle(-360);
		     rt2.setCycleCount(Timeline.INDEFINITE);
		     rt2.setAutoReverse(true);
		 
		     rt2.play();
		     Grid_Datos1.setGridLinesVisible(false);
		 GridPane Grid_Datos2 = new GridPane();
		 Grid_Datos2.getStyleClass().add("mygridStyle");
  	      
  	        ColumnConstraints colum3 = new ColumnConstraints();
  	      colum3.setPercentWidth(45);
  	        ColumnConstraints colum4 = new ColumnConstraints();
  	      colum4.setPercentWidth(10);
  	      ColumnConstraints colum5 = new ColumnConstraints();
  	    colum5.setPercentWidth(45);
  	  Grid_Datos2.getColumnConstraints().addAll(colum3, colum4, colum5);
  	    
  	       
  	 
  	      
  	    for(int i=0;i<2;i++) {
  	    	 RowConstraints row3= new RowConstraints(y/4);
	  	       Grid_Datos2.getRowConstraints().add(row3);
  	      }
  	   
  	     Grid_Datos2.setGridLinesVisible(false);
  	     raiz.add(Grid_Datos2, 0, 1);	
  	     
  	   ImageView imageViewB1 = new ImageView(new Image("IMG/BTNJOS.png"));
  	 imageViewB1.setId("btn");
  	    imageViewB1.setX(0);
		imageViewB1.setY(0);
		imageViewB1.setFitWidth(y * 0.35);
		imageViewB1.setPreserveRatio(true);
		 GridPane.setHalignment(imageViewB1, HPos.RIGHT);
		 GridPane.setValignment(imageViewB1, VPos.BOTTOM);
		 Grid_Datos2.add(imageViewB1, 0, 0);	
			imageViewB1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					imageViewB1.setEffect(sh2);
				}
			});
			imageViewB1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					imageViewB1.setEffect(null);
				}
			});
			imageViewB1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					btnPORTO.play();
					Main.setEscenaUno();
					System.out.println("FLY!");
					event.consume();
				}
			});
		 
		 ImageView imageViewB2 = new ImageView(new Image("IMG/BTNJOS2.png"));
		 imageViewB2.setId("btn");
	  	    imageViewB2.setX(0);
			imageViewB2.setY(0);
			imageViewB2.setFitWidth(y * 0.35);
			imageViewB2.setPreserveRatio(true);
			 GridPane.setHalignment(imageViewB2, HPos.LEFT);
			 GridPane.setValignment(imageViewB2, VPos.BOTTOM);
			 Grid_Datos2.add(imageViewB2, 2, 0);
				imageViewB2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						imageViewB2.setEffect(sh2);
					}
				});
				imageViewB2.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						imageViewB2.setEffect(null);
					}
				});
				imageViewB2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						 btnPORTO.play();
						Main.setEscenaDos();
						System.out.println("SIM!");
						event.consume();
					}
				});
		
		root.getChildren().add(raiz);
	}

}