package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SSim_Mode extends Scene {
	CreateGrid GPane = new CreateGrid();
	double comPASSDATA = 0;
	double cC5 = 0;
	GridPane GPane0, GPane1, GPane2, GPane2_2, GPane3, GPane4, GPane5, GPane6, GPane7, GPane8, GPane9, GPane10, GPane11,
			GPane12, GPane13, GPane131, GPane14, GPane15, GPane16, GPane17, GPane18, GPane19, GPane20, GPane21, GPane22;
	GridPane GPane41, GPane42, GPane43, GPane44, GPane45, GPane46, GPane47, GPane48;
	GridPane GPane50, GPane51, GPane52, GPane53;
	GridPane GPaneGRF1, GPaneGRF2, GPaneGRF3, GPaneGRF4;
	GridPane GPaneBtnC, GPaneBtnD;
	GridPane GPane1_2, GPane1_3, GPane1_4;
	BorderPane BPane1;
	VBox VB0, VB1, VB2, VB3, VB4, VB5, VB6, VB7, VB8, VB8A, VB9, VB10, VB11, VB12, VB13, VB14, VB15, VB16, VB17, VB18,
			VB19;
	HBox HB0, HB1, HB2, HB3, HB4, HB5, HB6, HB7, HB8, HB8A, HB9, HB10, HB11, HB12, HB13, HB14, HB15, HB16, HB17, HB18,
			HB19;
	VBox VBu1, VBu2, VBu3, VBu4, VBu5, VBu6, VBu7, VBu8, VBu9, VBu10;
	// FIGURAS
	ShapesFX cS = new ShapesFX();
	// BATERIA-SHAPES
	Rectangle R1, R2;
	HBox HBSR1;
	VBox VBSR1;
	BorderPane BPaneSR1;
	// TASK
	Circle C1, C2, C3, C4, C5;
	VBox VBS1, VBS2, VBS3, VBS4;
	HBox HBS1, HBS2;
	Circle CE1, CE2, CE3, CE4, CE5, CE6;
	Rectangle RS_1,RS_2,RSB_1_2,RSB_1_2_3,RSB_1_2_3_4,RS_2_1,RS_1_2;
	VBox VBC1, VBC2, VBC3, VBC4, VBC5;
	// MODE OF OPERATION
	ImageView imageView = new ImageView(new Image("IMG/btnQ.png"));
	// BOTONES-REFRESH-CALI-BUZZ
	GridPane GPbuttons = new GridPane();
	HBox bpR = new HBox();
	HBox bpC = new HBox();
	HBox bpB = new HBox();
	HBox bpRP = new HBox();
	HBox bpCSV = new HBox();

	ImageView imageViewR = new ImageView(new Image("IMG/btnRCS.png"));
	ImageView imageViewC = new ImageView(new Image("IMG/btnCCS.png"));
	ImageView imageViewB = new ImageView(new Image("IMG/btnBuzzS.png"));
	ImageView imageViewRP = new ImageView(new Image("IMG/btnRPS.png"));
	ImageView imageViewCSV = new ImageView(new Image("IMG/btnCSV.png"));

	// PINTING IMAGE
	ImageView imageViewP1 = new ImageView(new Image("IMG/oraSIM1.png"));
	ImageView imageViewP = new ImageView(new Image("IMG/oraSIM2.png"));
//    Font Font1 = Font.loadFont(SF_mode.class.getResourceAsStream("/FONTS/CascadiaCode-Regular-VTT.ttf"), 20);
	// TEXT

	Font Font1 = new Font("/FONTS/CascadiaCode-Regular-VTT.ttf", 18);

	Fuentes tipoFuente;
//    Font Font1 = Font.loadFont("FONTS/MESLO LG L BOLD NERD FONT COMPLETE MONO.TTF.ttf",45);
//    Font Font1 = new Font("Cascadia Code",19);

	// RELOJS MESLO
	Text Temperature;
	Text Altitude;
	Text Pressure;
	Text Acceleration;

	// POINTING Y LA BATERIA MESLO
	Text Compass;
	Text Voltage;

	// Text Panel CASCADIA
	Text Tilt_X;
	Text Tilt_Y;
	Text Gps_Time;
	Text Gps_Altitude;
	Text Gps_Latitude;
	Text Gps_Longitude;
	Text Gps_Sats;


	//
	VBox VBIMGv1;
	HBox HBIMGv1;
	DropShadow shadow = new DropShadow();
	
	//DATA SEND
	static ArrayList<String> datos = new ArrayList<>();
	static ArrayList<String> senData = new ArrayList<>();
	static int contador1=0;
	static int contador2=0;
	static int ValorSinTitulo=0;
	static int ValorEnviado;
	static Thread hilo2;

	// SERIAL Y CMD
	Font font = Font.loadFont("C:\\Users\\r2d2\\Downloads\\FJX\\RadioSpace-zZ80.otf", 45);
	ImageView imageViewConnect = new ImageView(new Image("IMG/btnCSIM.png"));
	ImageView imageViewDisconnect = new ImageView(new Image("IMG/btnDSIM.png"));
	ImageView imageViewSend = new ImageView(new Image("IMG/btnSSIM.png"));
	ImageView imgP = new ImageView(new Image("IMG/prueba.png"));
	Button porT = new Button("Connect");
	Button porT2 = new Button("Send");
	ObservableList<String> listPort = FXCollections.observableArrayList();
	static ComboBox cbX = new ComboBox();
	static ObservableList<String> listComm = 
			FXCollections.observableArrayList
			(
					"CMD,1040,FLY,ACTIVATE",
					"CMD,1040,CX,ON",
					"CMD,1040,CX,OFF",
					"CMD,1040,SIM,ENABLE",
					"CMD,1040,SIM,ACTIVATE",
					"CMD,1040,POLOLU,RELEASE",
					"CMD,1040,POLOLU,CONF",
					"CMD,1040,POLOLU,STOP",
					"CMD,1040,POLOLU,AEROBRAKE",
					"CMD,1040,CAMERA,ABCONF",
					"CMD,1040,POLOLU,ABSTOP",
					"CMD,1040,CAMERA,ON",
					"CMD,1040,CAMERA,STOP",
					"CMD,1040,BUZZ,ACTIVATE",
					"CMD,1040,BUZZ,STOP",
					"CMD,1040,TIME",
					"CMD,1040,CALIBRATION",
					"CMD,1040,SIMULATION",
					"CMD,1040,EXIT"
			);	static ComboBox cbX2 = new ComboBox(listComm);
	static SerialPort Porto;
	public static long t0;
	public static long t;
	
	//Clock
    static boolean ActiveClock = false;
    static Thread clock;
    static Text timer = new Text("00:00:00");
    static String missionTime = "";
    static long initialTime=0,currentTime;
	static long hora,seg,min;
	String line = "";
	CSVfile csv;

	// ARC
	Arc arc1;
	Arc arc2;
	Arc arc3;
	Arc arc4;
	Arc arc5;
	Arc arc6;
	Arc arc7;
	Arc arc8;

	// GRAFICAS
	// Temperatura
	static XYChart.Series GRF1 = new XYChart.Series();
	// ACELEROMETRO
	static XYChart.Series GRF2 = new XYChart.Series();
	// ALTITUD
	static XYChart.Series GRF3 = new XYChart.Series();
	static XYChart.Series GRF4 = new XYChart.Series();
	static XYChart.Series GRF5 = new XYChart.Series();
	// presion
	static XYChart.Series GRF6 = new XYChart.Series();

	

	//VARIABLES
	double dataBattery;
	double dataWRect;
	double dataTemp;
	double dataWArc2;
	double dataAlt;
	double dataPress;
	double dataAccel;
	String dataState;
	
    static AudioClip cbxS= new AudioClip(Paths.get("src/sonidos/008827425_prev.mp3").toUri().toString());
    static AudioClip btnPORTO= new AudioClip(Paths.get("src/sonidos/bonito.mp3").toUri().toString());
    static AudioClip lobby2= new AudioClip(Paths.get("src/sonidos/argumento_1.mp3").toUri().toString());

	// Definimos el método de la escena.
	public SSim_Mode(Pane root, int x, int y) {
		super(root, x, y);
		dataWRect = x*0.12;
		dataWArc2 = 300;
		// DIVISIOINES
		GPane0 = new GridPane();
		GPane1 = new GridPane();
		GPane1_2 = new GridPane();
		GPane1_3 = new GridPane();
		GPane1_4 = new GridPane();
		GPane2 = new GridPane();
		GPane2_2 = new GridPane();
		GPane3 = new GridPane();
		GPane4 = new GridPane();
		GPane5 = new GridPane();
		GPane6 = new GridPane();
		GPane7 = new GridPane();
		GPane8 = new GridPane();
		GPane9 = new GridPane();

		GPane10 = new GridPane();
		GPane11 = new GridPane();
		GPane12 = new GridPane();
		GPane13 = new GridPane();
		GPane14 = new GridPane();
		GPane15 = new GridPane();
		GPane16 = new GridPane();
		GPane17 = new GridPane();
		GPane18 = new GridPane();
		GPane19 = new GridPane();
		GPane20 = new GridPane();
		GPane21 = new GridPane();
		GPane22 = new GridPane();

		GPane131 = new GridPane();

		GPane41 = new GridPane();
		GPane42 = new GridPane();
		GPane43 = new GridPane();
		GPane44 = new GridPane();
		GPane45 = new GridPane();
		GPane46 = new GridPane();
		GPane47 = new GridPane();
		GPane48 = new GridPane();

		GPane50 = new GridPane();
		GPane51 = new GridPane();
		GPane52 = new GridPane();
		GPane53 = new GridPane();

		GPaneGRF1 = new GridPane();
		GPaneGRF2 = new GridPane();
		GPaneGRF3 = new GridPane();
		GPaneGRF4 = new GridPane();

		GPaneBtnC = new GridPane();
		GPaneBtnD = new GridPane();

		BPane1 = new BorderPane();

		VB0 = new VBox();
		VB1 = new VBox();
		VB2 = new VBox();
		VB3 = new VBox();
		VB4 = new VBox();
		VB5 = new VBox();

		HB0 = new HBox();
		HB1 = new HBox();
		HB2 = new HBox();
		HB3 = new HBox();
		HB4 = new HBox();
		HB5 = new HBox();

		VB8A = new VBox();
		HB8A = new HBox();

		VB6 = new VBox();
		VB7 = new VBox();
		VB8 = new VBox();
		VB9 = new VBox();
		VB10 = new VBox();
		VB11 = new VBox();
		VB12 = new VBox();
		VB13 = new VBox();

		VBS1 = new VBox();
		VBS2 = new VBox();
		VBS3 = new VBox();
		VBS4 = new VBox();

		HBS1 = new HBox();
		HBS2 = new HBox();

		HB6 = new HBox();
		HB7 = new HBox();
		HB8 = new HBox();
		HB9 = new HBox();
		HB10 = new HBox();
		HB11 = new HBox();
		HB12 = new HBox();
		HB13 = new HBox();

		VB14 = new VBox();
		VB15 = new VBox();
		VB16 = new VBox();
		VB17 = new VBox();
		VB18 = new VBox();
		VB19 = new VBox();

		HB14 = new HBox();
		HB15 = new HBox();
		HB16 = new HBox();
		HB17 = new HBox();
		HB18 = new HBox();
		HB19 = new HBox();

		// TASK
		C1 = new Circle();
		C2 = new Circle();
		C3 = new Circle();
		C4 = new Circle();
		C5 = new Circle();

		// state mission
		CE1 = new Circle();
		CE2 = new Circle();
		CE3 = new Circle();
		CE4 = new Circle();
		CE5 = new Circle();
		CE6 = new Circle();

		VBC1 = new VBox(8);
		VBC2 = new VBox(24);
		VBC3 = new VBox();
		VBC4 = new VBox();
		VBC5 = new VBox();

		VBu1 = new VBox();
		VBu2 = new VBox();
		VBu3 = new VBox();
		VBu4 = new VBox();
		VBu5 = new VBox();
		VBu6 = new VBox();
		VBu7 = new VBox();
		VBu8 = new VBox();
		VBu9 = new VBox();
		VBu10 = new VBox();

		// view
		VBIMGv1 = new VBox();
		HBIMGv1 = new HBox();
		BorderPane bpn = new BorderPane();

		// BOTONES - REFRESH, CAL
		HBox HBbuttons = new HBox();

		// CRACION DE LAS DIVICIONES
		GPane.createGrid(GPane0, x, y, 1, 1);
		GPane.createGrid(GPane1, x, y, 3, 1);
		GPane.createGrid(GPane1_2, x/3, y, 21, 3);
		GPane.createGrid(GPane1_3, x/3, y, 33, 62);
		GPane.createGrid(GPane2, x / 4, y, 2, 1);
		GPane.createGrid(GPane2_2, x / 3, y, 1, 1);
		GPane.createGrid(GPane3, x / 3, y, 1, 4);
		GPane.createGrid(GPane41, x / 4, y, 1, 4);
		GPane.createGrid(GPane42, x * 0.15, y * 0.19, 1, 1);
		GPane.createGrid(GPane43, x * 0.32, y * 0.17, 1, 1);
		GPane.createGrid(GPane44, x * 0.32, y * 0.17, 5, 1);
		GPane.createGrid(GPane45, x * 0.237, y * 0.21, 1, 1);
		GPane.createGrid(GPane46, x * 0.237, y * 0.20, 2, 2);
		GPane.createGrid(GPane47, x * 0.12, y * 0.09, 1, 1);
		GPane.createGrid(GPane48, x * 0.12, y * 0.09, 1, 1);
		// GRIDS INFERIORES
		GPane.createGrid(GPane4, x * 0.69, y * 0.21, 1, 1);
		GPane.createGrid(GPane5, x * 0.65, y * 0.18, 4, 1);
		GPane.createGrid(GPane6, x * 0.12, y * 0.058, 1, 1);
		GPane.createGrid(GPane7, x * 0.14, y * 0.15, 5, 1);
		GPane.createGrid(GPane8, x * 0.14, y * 0.15, 5, 1);
		GPane.createGrid(GPane9, x * 0.14, y * 0.14, 1, 1);

		// GRIDS EN MEDIO
		GPane.createGrid(GPane10, x * 0.681, y * 0.78, 1, 1);
		GPane.createGrid(GPane11, x * 0.65, y * 0.70, 1, 1);
		GPane.createGrid(GPane12, x * 0.34, y * 0.19, 4, 1);
		GPane.createGrid(GPane13, x * 0.34, y * 0.70, 1, 1);
		GPane.createGrid(GPane131, x * 0.30, y * 0.49, 2, 11);
		GPane.createGrid(GPane14, x * 0.34, y * 0.15, 2, 1);
		GPane.createGrid(GPane15, x * 0.064, y * 0.70, 3, 10);
		GPane.createGrid(GPane16, x * 0.34, y * 0.15, 2, 1);
		GPane.createGrid(GPbuttons, x * 0.17, y * 0.15, 3, 1);

		// GRIDS DE LA DERECHA
		GPane.createGrid(GPane17, x * 0.30, y * 0.77, 1, 1);
		GPane.createGrid(GPane18, x * 0.24, y * 0.76, 1, 5);
		GPane.createGrid(GPane19, x * 0.29, y * 0.098, 1, 1);
		GPane.createGrid(GPane20, x * 0.31, y * 0.77, 1, 5);
		GPane.createGrid(GPane21, x * 0.26, y * 0.21, 1, 1);
		GPane.createGrid(GPane22, x * 0.22, y * 0.15, 2, 2);

		// MISSION POINTING ERROR
		GPane.createGrid(GPane50, x * 0.34, y * 0.70, 5, 5);
		GPane.createGrid(GPane51, x * 0.34, y * 0.57, 1, 1);
		GPane.createGrid(GPane52, x * 0.34, y * 0.15, 3, 1);
		GPane.createGrid(GPane53, x * 0.16, y * 0.17, 3, 3);

		// PARA LAS GRAFICAS
		GPane.createGrid(GPaneGRF1, x * 0.19, y * 0.07, 1, 1);
		GPane.createGrid(GPaneGRF2, x * 0.19, y * 0.07, 1, 1);
		GPane.createGrid(GPaneGRF3, x * 0.19, y * 0.07, 1, 1);
		GPane.createGrid(GPaneGRF4, x * 0.19, y * 0.07, 1, 1);

		GPane.createGrid(GPaneBtnC, x * 0.07, y * 0.06, 1, 1);
		GPane.createGrid(GPaneBtnD, x * 0.07, y * 0.06, 1, 1);
		// BATERIA
		R1 = new Rectangle();
		R2 = new Rectangle();
		HBSR1 = new HBox();
		VBSR1 = new VBox();
		BPaneSR1 = new BorderPane();

		arc1 = new Arc();
		arc2 = new Arc();
		arc3 = new Arc();
		arc4 = new Arc();
		arc5 = new Arc();
		arc6 = new Arc();
		arc7 = new Arc();
		arc8 = new Arc();
		shadow.setColor(Color.BROWN);
		DropShadow shadow1 = new DropShadow();
		shadow1.setColor(Color.RED);
		// RELOJS
		Temperature = new Text("0.0\n °C");
		Temperature.setFont(Font.font("Consolas", FontWeight.BOLD, 15));
		cS.createText(Temperature, Color.YELLOW, shadow1, x / 2, y / 2);

		Altitude = new Text("0.0\n  m");
		Altitude.setFont(Font.font("Consolas", FontWeight.BOLD, 15));
		cS.createText(Altitude, Color.YELLOW, shadow1, x / 2, y / 2);
		Pressure = new Text("0.0\nKPa");
		Pressure.setFont(Font.font("Consolas", FontWeight.BOLD, 15));
		cS.createText(Pressure, Color.YELLOW, shadow1, x / 2, y / 2);
		Acceleration = new Text(" 0.0\nm/s^2");
		Acceleration.setFont(Font.font("Consolas", FontWeight.BOLD, 15));
		cS.createText(Acceleration, Color.YELLOW, shadow1, x / 2, y / 2);

		// POINTING
		Compass = new Text(" 0.0°");
		Compass.setFont(Font.font("Consolas", FontWeight.BOLD, 15));
		cS.createText(Compass, Color.YELLOW, shadow1, x / 2, y / 2);
		// BATERIA
		Voltage = new Text("0.0V");
		Voltage.setFont(Font.font("Consolas", FontWeight.BOLD, 15));
		cS.createText(Voltage, Color.YELLOW, shadow1, x / 2, y / 2);

		// Textos
		Tilt_X = new Text("0.00°");

		cS.createText(Tilt_X, Color.BURLYWOOD, shadow1, x / 2, y / 2);
		Tilt_Y = new Text("0.00°");
		cS.createText(Tilt_Y, Color.BURLYWOOD, shadow1, x / 2, y / 2);
		Gps_Time = new Text("00:00:00");
		cS.createText(Gps_Time, Color.BURLYWOOD, shadow1, x / 2, y / 2);
		Gps_Altitude = new Text("0.0m");
		cS.createText(Gps_Altitude, Color.BURLYWOOD, shadow1, x / 2, y / 2);
		Gps_Latitude = new Text("0.00000°N");
		cS.createText(Gps_Latitude, Color.BURLYWOOD, shadow1, x / 2, y / 2);
		Gps_Longitude = new Text("0.00000 °W");
		cS.createText(Gps_Longitude, Color.BURLYWOOD, shadow1, x / 2, y / 2);
		Gps_Sats = new Text("0");
		cS.createText(Gps_Sats, Color.BURLYWOOD, shadow1, x / 2, y / 2);
		Tilt_X.setFont(Font.font("Consolas", FontWeight.LIGHT, 17));
		Tilt_Y.setFont(Font.font("Consolas", FontWeight.LIGHT, 17));
		Gps_Time.setFont(Font.font("Consolas", FontWeight.LIGHT, 17));
		Gps_Altitude.setFont(Font.font("Consolas", FontWeight.LIGHT, 17));
		Gps_Latitude.setFont(Font.font("Consolas", FontWeight.LIGHT, 17));
		Gps_Longitude.setFont(Font.font("Consolas", FontWeight.LIGHT, 17));
		Gps_Sats.setFont(Font.font("Consolas", FontWeight.LIGHT, 17));

		// TIMEMISSION
		timer = new Text("00:00:00");
		timer.setFill(Color.YELLOW);
		timer.setFont(new Font("Consolas", 53));
		timer.setEffect(shadow1);

		Button btn = new Button();
		btn.setText("Change the Sim Mode");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
//                Main.setEscenaDos();
			}
		});

		VB13.getChildren().add(GPane17);
		VB13.setAlignment(Pos.TOP_RIGHT);
		HB13.getChildren().add(VB13);
		HB13.setAlignment(Pos.CENTER_RIGHT);
		GPane0.add(HB13, 0, 0);

		VB16.getChildren().add(GPane20);
		VB16.setAlignment(Pos.TOP_RIGHT);
		HB16.getChildren().add(VB16);
		HB16.setAlignment(Pos.CENTER_RIGHT);
		GPane0.add(HB16, 0, 0);

		VB14.getChildren().add(GPane18);
		VB14.setAlignment(Pos.TOP_CENTER);
		HB14.getChildren().add(VB14);
		HB14.setAlignment(Pos.CENTER);
		GPane17.add(HB14, 0, 0);

		VB15.getChildren().add(GPane19);
		VB15.setAlignment(Pos.BOTTOM_CENTER);
		HB15.getChildren().add(VB15);
		HB15.setAlignment(Pos.BOTTOM_LEFT);
		GPane20.add(HB15, 0, 0);

		GPane0.add(GPane10, 0, 0);
		VB17.getChildren().add(GPane21);
		VB17.setAlignment(Pos.BOTTOM_RIGHT);
		HB17.getChildren().add(VB17);
		HB17.setAlignment(Pos.BOTTOM_RIGHT);
		GPane0.add(HB17, 0, 0);

		VB18.getChildren().add(GPane22);
		VB18.setAlignment(Pos.CENTER);
		HB18.getChildren().add(VB18);
		HB18.setAlignment(Pos.CENTER);
		GPane21.add(HB18, 0, 0);

		// PRIMER PANEL
		VB6.getChildren().add(GPane11);
		VB6.setAlignment(Pos.CENTER);
		HB6.getChildren().add(VB6);
		HB6.setAlignment(Pos.CENTER);
		GPane10.add(HB6, 0, 0);

		VBox VBE1 = new VBox();
		VBox VBE2 = new VBox();
		HBox HBE1 = new HBox();
		HBox HBE2 = new HBox();
		VBox VBE3 = new VBox();
		HBox HBE3 = new HBox();
		VBox VBE4 = new VBox();
		HBox HBE4 = new HBox();
		VBE1.getChildren().add(GPane50);
		VBE1.setAlignment(Pos.CENTER);
		HBE1.getChildren().add(VBE1);
		HBE1.setAlignment(Pos.CENTER_LEFT);
		GPane11.add(HBE1, 0, 0);

		VBE2.getChildren().add(GPane51);
		VBE2.setAlignment(Pos.CENTER);
		HBE2.getChildren().add(VBE2);
		HBE2.setAlignment(Pos.CENTER_LEFT);
		GPane11.add(HBE2, 0, 0);

		VBE3.getChildren().add(GPane52);
		VBE3.setAlignment(Pos.BOTTOM_CENTER);
		HBE3.getChildren().add(VBE3);
		HBE3.setAlignment(Pos.BOTTOM_LEFT);
		GPane51.add(HBE3, 0, 0);

		// POINTING

		imageViewP.setX(0);
		imageViewP.setY(0);
		imageViewP.setFitWidth(y * 0.15);
		imageViewP.setPreserveRatio(true);
		imageViewP1.setX(0);
		imageViewP1.setY(0);
		imageViewP1.setFitWidth(y * 0.15);
		imageViewP1.setPreserveRatio(true);

//        Group imgGP = new Group();
//        imgGP.
		StackPane stkp = new StackPane();
		stkp.getChildren().add(imageViewP1);
		VBE4.getChildren().add(imageViewP);
		VBE4.setAlignment(Pos.CENTER);
		HBE4.getChildren().add(VBE4);
		HBE4.setAlignment(Pos.CENTER);
		GPane52.add(stkp, 1, 0);
		GPane52.add(HBE4, 1, 0);
		BorderPane BPS1 = new BorderPane();
		BPS1.setCenter(Compass);
		GPane52.add(BPS1, 1, 0);

//        GPane50.setGridLinesVisible(true);

		VB8.getChildren().add(GPane13);
		VB8.setAlignment(Pos.BOTTOM_CENTER);
		HB8.getChildren().add(VB8);
		HB8.setAlignment(Pos.CENTER_RIGHT);
		GPane11.add(HB8, 0, 0);

		// RELOJS, TEXTOS, BOTONES Y MAPA
		VB8A.getChildren().add(GPane131);
		VB8A.setAlignment(Pos.BOTTOM_CENTER);
		HB8A.getChildren().add(VB8A);
		HB8A.setAlignment(Pos.CENTER_RIGHT);
		GPane13.add(HB8A, 0, 0);

		VB7.getChildren().add(GPane12);
		VB7.setAlignment(Pos.TOP_RIGHT);
		HB7.getChildren().add(VB7);
		HB7.setAlignment(Pos.CENTER_RIGHT);
		GPane13.add(HB7, 0, 0);

		VB12.getChildren().add(GPane16);
		VB12.setAlignment(Pos.BOTTOM_RIGHT);
		HB12.getChildren().add(VB12);
		HB12.setAlignment(Pos.CENTER_RIGHT);
		GPane13.add(HB12, 0, 0);

		GPane16.add(GPbuttons, 1, 0);

		// PANEL ABAJO
		VB0.getChildren().add(GPane4);
		VB0.setAlignment(Pos.BOTTOM_CENTER);
		GPane0.add(VB0, 0, 0);
		VB1.getChildren().add(GPane5);
		VB1.setAlignment(Pos.CENTER);
		HB1.getChildren().add(VB1);
		HB1.setAlignment(Pos.CENTER);

		GPane5.add(GPane53, 0, 0);
		BPane1.setCenter(HB1);
		GPane4.add(BPane1, 0, 0);

		VBox VBB5 = new VBox();
		VBB5.getChildren().add(Voltage);
		VBB5.setAlignment(Pos.CENTER);
		GPane53.add(VBB5, 1, 2);

		VB2.getChildren().add(GPane6);
		VB2.setAlignment(Pos.CENTER);
		HB2.getChildren().add(VB2);
		HB2.setAlignment(Pos.CENTER);
		GPane5.add(HB2, 0, 0);

		VB3.getChildren().add(GPane7);
		VB3.setAlignment(Pos.CENTER);
		HB3.getChildren().add(VB3);
		HB3.setAlignment(Pos.CENTER_RIGHT);
		GPane5.add(HB3, 1, 0);

		VB4.getChildren().add(GPane8);
		VB4.setAlignment(Pos.CENTER);
		HB4.getChildren().add(VB4);
		HB4.setAlignment(Pos.CENTER);
		GPane5.add(HB4, 2, 0);

		VB5.getChildren().add(GPane9);
		VB5.setAlignment(Pos.CENTER);
		HB5.getChildren().add(VB5);
		HB5.setAlignment(Pos.CENTER_RIGHT);
		GPane5.add(HB5, 3, 0);

//      BATERIA, posicionamiento
		cS.createRect(R1, GPane6, y * 0.058, x * 0.12, Color.TRANSPARENT, Color.rgb(102, 0, 51), 0, 0);
		cS.createRect(R2, GPane6, y * 0.058, x * 0.00, Color.TRANSPARENT, Color.rgb(255, 192, 0), 0, 0);
		cS.createCirc(C1, C2, C3, GPane7, VBC1, y * 0.021, x * 0.12, Color.rgb(102, 0, 51), Color.rgb(255, 192, 0), 3,
				0);
		cS.createCirc2(C4, C5, GPane8, VBC2, y * 0.021, x * 0.12, Color.rgb(102, 0, 51), Color.rgb(255, 192, 0), 1, 0);
		cS.createCirc3(CE1, GPane50, VBS1, y * 0.020, x * 0.12, Color.rgb(89, 89, 89), Color.rgb(102, 0, 51), 0, 0);
		cS.createCirc7(CE2, GPane50, VBS2, y * 0.020, x * 0.12, Color.rgb(89, 89, 89), Color.rgb(102, 0, 51), 0, 2);
		cS.createCirc4(CE3, GPane50, VBS3, y * 0.020, x * 0.12, Color.rgb(89, 89, 89), Color.rgb(102, 0, 51), 1, 3);
		cS.createCirc4(CE4, GPane50, VBS4, y * 0.020, x * 0.12, Color.rgb(89, 89, 89), Color.rgb(102, 0, 51), 3, 3);
		cS.createCirc5(CE5, GPane50, HBS1, y * 0.020, x * 0.12, Color.rgb(89, 89, 89), Color.rgb(102, 0, 51), 4, 2);
		cS.createCirc6(CE6, GPane50, HBS2, y * 0.020, x * 0.12, Color.rgb(89, 89, 89), Color.rgb(102, 0, 51), 4, 0);
		// MODE OF OPERATION - CHANGE OPERATION

		// ARC
		Group Gp1 = new Group();
		HBox HBgp1 = new HBox();
		cS.createArc(arc1, Color.TRANSPARENT, Color.rgb(45, 70, 84), 8, x / 2, y / 2, 44, 44, 300, 300, shadow1);
		cS.createArc(arc2, Color.TRANSPARENT, Color.YELLOW, 6, x / 2, y / 2, 44, 44, (-1) * 121, (-1) * 0, shadow1);
		Gp1.getChildren().addAll(arc1, arc2);
		HBgp1.getChildren().add(Gp1);
		HBgp1.setAlignment(Pos.CENTER);
		GPane12.add(HBgp1, 0, 0);
		BorderPane BPT1 = new BorderPane();
		BPT1.setCenter(Temperature);
		GPane12.add(BPT1, 0, 0);

		Group Gp2 = new Group();
		HBox HBgp2 = new HBox();
		cS.createArc(arc3, Color.TRANSPARENT, Color.rgb(45, 70, 84), 8, x / 2, y / 2, 44, 44, 300, 300, shadow1);
		cS.createArc(arc4, Color.TRANSPARENT, Color.YELLOW, 6, x / 2, y / 2, 44, 44, (-1) * 121, (-1) * 0, shadow1);
		Gp2.getChildren().addAll(arc3, arc4);
		HBgp2.getChildren().add(Gp2);
		HBgp2.setAlignment(Pos.CENTER);
		BorderPane BPT2 = new BorderPane();
		BPT2.setCenter(Altitude);
		GPane12.add(BPT2, 1, 0);
		GPane12.add(HBgp2, 1, 0);

		Group Gp3 = new Group();
		HBox HBgp3 = new HBox();
		cS.createArc(arc5, Color.TRANSPARENT, Color.rgb(45, 70, 84), 8, x / 2, y / 2, 44, 44, 300, 300, shadow1);
		cS.createArc(arc6, Color.TRANSPARENT, Color.YELLOW, 6, x / 2, y / 2, 44, 44, (-1) * 121, (-1) * 0, shadow1);
		Gp3.getChildren().addAll(arc5, arc6);
		HBgp3.getChildren().add(Gp3);
		HBgp3.setAlignment(Pos.CENTER);
		BorderPane BPT3 = new BorderPane();
		BPT3.setCenter(Pressure);
		GPane12.add(BPT3, 2, 0);
		GPane12.add(HBgp3, 2, 0);

		Group Gp4 = new Group();
		HBox HBgp4 = new HBox();
		cS.createArc(arc7, Color.TRANSPARENT, Color.rgb(45, 70, 84), 8, x / 2, y / 2, 44, 44, 300, 300, shadow1);
		cS.createArc(arc8, Color.TRANSPARENT, Color.YELLOW, 6, x / 2, y / 2, 44, 44, (-1) * 121, (-1) * 0, shadow1);
		Gp4.getChildren().addAll(arc7, arc8);
		HBgp4.getChildren().add(Gp4);
		HBgp4.setAlignment(Pos.CENTER);
		BorderPane BPT4 = new BorderPane();
		BPT4.setCenter(Acceleration);
		GPane12.add(BPT4, 3, 0);
		GPane12.add(HBgp4, 3, 0);

		HBox HBtm = new HBox();
		HBtm.getChildren().add(timer);
		HBtm.setAlignment(Pos.CENTER);
		GPane19.add(HBtm, 0, 0);

		VBox VBTp1 = new VBox();
		VBox VBTp2 = new VBox();
		VBox VBTp3 = new VBox();
		VBox VBTp4 = new VBox();
		VBox VBTp5 = new VBox();
		VBox VBTp6 = new VBox();
		VBox VBTp7 = new VBox();

		VBTp1.getChildren().add(Tilt_X);
		VBTp2.getChildren().add(Tilt_Y);
		VBTp3.getChildren().add(Gps_Time);
		VBTp4.getChildren().add(Gps_Altitude);
		VBTp5.getChildren().add(Gps_Latitude);
		VBTp6.getChildren().add(Gps_Longitude);
		VBTp7.getChildren().add(Gps_Sats);

		VBTp1.setAlignment(Pos.BOTTOM_CENTER);
		VBTp2.setAlignment(Pos.BOTTOM_CENTER);
		VBTp3.setAlignment(Pos.BOTTOM_CENTER);
		VBTp4.setAlignment(Pos.BOTTOM_CENTER);
		VBTp5.setAlignment(Pos.BOTTOM_CENTER);
		VBTp6.setAlignment(Pos.BOTTOM_CENTER);
		VBTp7.setAlignment(Pos.BOTTOM_CENTER);

		GPane131.add(VBTp1, 1, 0);

		GPane131.add(VBTp2, 1, 1);
		GPane131.add(VBTp3, 1, 2);
		GPane131.add(VBTp4, 1, 3);
		GPane131.add(VBTp5, 1, 4);
		GPane131.add(VBTp6, 1, 5);
		GPane131.add(VBTp7, 1, 6);

		final NumberAxis x1 = new NumberAxis();
		final NumberAxis y1 = new NumberAxis();
		final LineChart LineChart1 = new LineChart(x1, y1);

		LineChart1.getData().addAll(GRF1);

		LineChart1.setCreateSymbols(false);
		LineChart1.setLegendVisible(false);
		x1.setAutoRanging(true);
		x1.setForceZeroInRange(false);
		y1.setAutoRanging(true);
		y1.setForceZeroInRange(false);

		final NumberAxis x2 = new NumberAxis();
		final NumberAxis y2 = new NumberAxis();
		final LineChart LineChart2 = new LineChart(x2, y2);

		LineChart2.getData().addAll(GRF2);

		LineChart2.setCreateSymbols(false);
		LineChart2.setLegendVisible(false);
		x2.setAutoRanging(true);
		x2.setForceZeroInRange(false);
		y2.setAutoRanging(true);
		y2.setForceZeroInRange(false);

		final NumberAxis x3 = new NumberAxis();
		final NumberAxis y3 = new NumberAxis();
		final LineChart LineChart3 = new LineChart(x3, y3);

		LineChart3.getData().addAll(GRF3);

		LineChart3.setCreateSymbols(false);
		LineChart3.setLegendVisible(false);
		x3.setAutoRanging(true);
		x3.setForceZeroInRange(false);
		y3.setAutoRanging(true);
		y3.setForceZeroInRange(false);

		final NumberAxis x4 = new NumberAxis();
		final NumberAxis y4 = new NumberAxis();
		final LineChart LineChart4 = new LineChart(x4, y4);

		LineChart4.getData().addAll(GRF4);

		LineChart4.setCreateSymbols(false);
		LineChart4.setLegendVisible(false);
		x4.setAutoRanging(true);
		x4.setForceZeroInRange(false);
		y4.setAutoRanging(true);
		y4.setForceZeroInRange(false);

		imageView.setX(0);
		imageView.setY(0);
		imageView.setFitWidth(y * 0.29);
		imageView.setPreserveRatio(true);
		imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageView.setEffect(shadow);
			}
		});
		imageView.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageView.setEffect(null);
			}
		});
		imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				Main.setEscenaUno();
				System.out.println("CHANGE TO FLY MODE!");
				event.consume();
			}
		});

		LineChart1.setScaleY(0.8);
		LineChart1.setScaleX(1.2);

		LineChart2.setScaleY(0.8);
		LineChart2.setScaleX(1.2);

		LineChart3.setScaleY(0.8);
		LineChart3.setScaleX(1.2);

		LineChart4.setScaleY(0.8);
		LineChart4.setScaleX(1.2);

		LineChart1.getYAxis().setTickLabelsVisible(false);
		LineChart1.getYAxis().setOpacity(0);

		LineChart2.getYAxis().setTickLabelsVisible(false);
		LineChart2.getYAxis().setOpacity(0);

		LineChart3.getYAxis().setTickLabelsVisible(false);
		LineChart3.getYAxis().setOpacity(0);

		LineChart4.getYAxis().setTickLabelsVisible(false);
		LineChart4.getYAxis().setOpacity(0);

		LineChart1.getXAxis().setTickLabelsVisible(false);
		LineChart1.getXAxis().setOpacity(0);

		LineChart2.getXAxis().setTickLabelsVisible(false);
		LineChart2.getXAxis().setOpacity(0);

		LineChart3.getXAxis().setTickLabelsVisible(false);
		LineChart3.getXAxis().setOpacity(0);

		LineChart4.getXAxis().setTickLabelsVisible(false);
		LineChart4.getXAxis().setOpacity(0);

		VBox VBc1 = new VBox();
		VBox VBc2 = new VBox();
		VBox VBc3 = new VBox();
		VBox VBc4 = new VBox();

		HBox VBc11 = new HBox();
		HBox VBc22 = new HBox();
		HBox VBc33 = new HBox();
		HBox VBc44 = new HBox();

		GPaneGRF1.add(LineChart1, 0, 0);
		GPaneGRF2.add(LineChart2, 0, 0);
		GPaneGRF3.add(LineChart3, 0, 0);
		GPaneGRF4.add(LineChart4, 0, 0);

		VBc1.getChildren().add(GPaneGRF1);
		VBc2.getChildren().add(GPaneGRF2);
		VBc3.getChildren().add(GPaneGRF3);
		VBc4.getChildren().add(GPaneGRF4);

		VBc1.setAlignment(Pos.CENTER);
		VBc2.setAlignment(Pos.CENTER);

		VBc3.setAlignment(Pos.CENTER);
		VBc4.setAlignment(Pos.CENTER);

		VBc11.getChildren().add(VBc1);
		VBc22.getChildren().add(VBc2);
		VBc33.getChildren().add(VBc3);
		VBc44.getChildren().add(VBc4);

		VBc11.setAlignment(Pos.CENTER_LEFT);
		VBc22.setAlignment(Pos.CENTER_LEFT);

		VBc33.setAlignment(Pos.CENTER_LEFT);
		VBc44.setAlignment(Pos.CENTER_LEFT);

		GPane18.add(VBc11, 0, 1);
		GPane18.add(VBc22, 0, 2);
		GPane18.add(VBc33, 0, 3);
		GPane18.add(VBc44, 0, 4);

		// POSICIONANDO BOTONES, REFRESH, CAL, BUZZER
		imageViewR.setX(0);
		imageViewR.setY(0);
		imageViewR.setFitWidth(y * 0.11);
		imageViewR.setPreserveRatio(true);
		imageViewR.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewR.setEffect(shadow);
			}
		});
		imageViewR.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewR.setEffect(null);
			}
		});
		imageViewR.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btnPORTO.play();
				System.out.println("REFRESH CHARTS!");
				GRF1.getData().clear();
				GRF2.getData().clear();
				GRF3.getData().clear();
				GRF4.getData().clear();
				GRF5.getData().clear();
				GRF6.getData().clear();
				event.consume();
			}
		});

		imageViewC.setX(0);
		imageViewC.setY(0);
		imageViewC.setFitWidth(y * 0.11);
		imageViewC.setPreserveRatio(true);
		imageViewC.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewC.setEffect(shadow);
			}
		});
		imageViewC.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewC.setEffect(null);
			}
		});
		imageViewC.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btnPORTO.play();
				String cmd = (String) cbX2.getValue();
				System.out.println(cmd + "-> SEND");
                byte[] G = "G".getBytes();
                Porto.writeBytes(G, G.length);
				event.consume();
			}
		});

		imageViewB.setX(0);
		imageViewB.setY(0);
		imageViewB.setFitWidth(y * 0.11);
		imageViewB.setPreserveRatio(true);
		imageViewB.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewB.setEffect(shadow);
			}
		});
		imageViewB.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewB.setEffect(null);
			}
		});
		imageViewB.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btnPORTO.play();
				String cmd = (String) cbX2.getValue();
                byte[] Z = "Z".getBytes();
                Porto.writeBytes(Z, Z.length);
				event.consume();
			}
		});

		imageViewRP.setX(0);
		imageViewRP.setY(0);
		imageViewRP.setFitWidth(y * 0.11);
		imageViewRP.setPreserveRatio(true);
		imageViewRP.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewRP.setEffect(shadow);
			}
		});
		imageViewRP.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewRP.setEffect(null);
			}
		});
		imageViewRP.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				cbX.getItems().clear();
				SP();
				System.out.println(".:|Refresh Ports|:.");
				btnPORTO.play();
				event.consume();
			}
		});
		
		imageViewCSV.setX(0);
		imageViewCSV.setY(0);
		imageViewCSV.setFitWidth(y * 0.11);
		imageViewCSV.setPreserveRatio(true);
		imageViewCSV.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewCSV.setEffect(shadow);
			}
		});
		imageViewCSV.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewCSV.setEffect(null);
			}
		});
		imageViewCSV.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					FileChooser select = new FileChooser();
					select.setTitle("Open the Simulation Archive");
					File file = select.showOpenDialog(new Stage());
					leerArchivo(file);
					addBytes(datos);
				} catch (Exception e) {
					// TODO: handle exception
				}
				event.consume();
			}
		});

		imageViewConnect.setX(0);
		imageViewConnect.setY(0);
		imageViewConnect.setFitWidth(x * 0.08);
		imageViewConnect.setFitHeight(y * 0.08);
		imageViewConnect.setPreserveRatio(true);

		imageViewSend.setX(0);
		imageViewSend.setY(0);
		imageViewSend.setFitWidth(x * 0.08);
		imageViewSend.setFitHeight(y * 0.08);

		imageViewSend.setPreserveRatio(true);

		imageViewDisconnect.setX(0);
		imageViewDisconnect.setY(0);
		imageViewDisconnect.setFitWidth(x * 0.08);
		imageViewDisconnect.setFitHeight(y * 0.08);
		imageViewDisconnect.setPreserveRatio(true);
		imageViewDisconnect.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewDisconnect.setEffect(shadow);
			}
		});
		imageViewDisconnect.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				imageViewDisconnect.setEffect(null);
			}
		});
		imageViewDisconnect.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("ImageView pressed!");

				event.consume();
			}
		});

		GPane0.add(GPane1, 0, 0);
		//RS_1, RS_1_2, RS_2, RS_1
		RS_1 = new Rectangle();
		Rectangle RS_1_1 = new Rectangle();
		RS_1.setHeight(y*0.049);
		RS_1.setWidth(x*0.003);
		RS_1.setStroke(Color.TRANSPARENT);
		RS_1.setFill(Color.rgb(166,166,166)); 
		RS_1.setStrokeLineCap(StrokeLineCap.ROUND);
		DropShadow DP_s = new DropShadow();
		DP_s.setColor(Color.rgb(255, 112, 0));
		RS_1.setEffect(DP_s);
		RS_1_1.setHeight(y*0.049);
		RS_1_1.setWidth(x*0.005);
		RS_1_1.setStroke(Color.TRANSPARENT);
		RS_1_1.setFill(Color.TRANSPARENT); 
		RS_1_1.setStrokeLineCap(StrokeLineCap.ROUND);
		HBox RS_1Hb = new HBox();
		VBox RS_1Vb = new VBox();
		RS_1Vb.getChildren().addAll(RS_1,RS_1_1);
		RS_1Vb.setAlignment(Pos.BOTTOM_CENTER);
		RS_1Hb.getChildren().addAll(RS_1Vb);
		RS_1Hb.setAlignment(Pos.CENTER);
		GPane1_2.add(RS_1Hb, 4, 0);
		
		RS_1_2 = new Rectangle();
		Rectangle RS_1_1_2 = new Rectangle();
		RS_1_2.setHeight(y*0.049);
		RS_1_2.setWidth(x*0.003);
		RS_1_2.setStroke(Color.TRANSPARENT);
		RS_1_2.setFill(Color.rgb(166,166,166)); 
		RS_1_2.setStrokeLineCap(StrokeLineCap.ROUND);
		RS_1_2.setEffect(DP_s);
		RS_1_1_2.setHeight(y*0.058);
		RS_1_1_2.setWidth(x*0.005);
		RS_1_1_2.setStroke(Color.TRANSPARENT);
		RS_1_1_2.setFill(Color.TRANSPARENT); 
		RS_1_1_2.setStrokeLineCap(StrokeLineCap.ROUND);
		HBox RS_1_2Hb = new HBox();
		VBox RS_1_2Vb = new VBox();
		RS_1_2Vb.getChildren().addAll(RS_1_2,RS_1_1_2);
		RS_1_2Vb.setAlignment(Pos.BOTTOM_CENTER);
		RS_1_2Hb.getChildren().addAll(RS_1_2Vb);
		RS_1_2Hb.setAlignment(Pos.CENTER);
		GPane1_2.add(RS_1_2Hb, 18, 0);
		
		RS_2 = new Rectangle();
		Rectangle RS_2_2 = new Rectangle();
		RS_2.setHeight(y*0.078);
		RS_2.setWidth(x*0.003);
		RS_2.setStroke(Color.TRANSPARENT);
		RS_2.setFill(Color.rgb(166,166,166)); 
		RS_2.setStrokeLineCap(StrokeLineCap.ROUND);
		RS_1_2.setEffect(DP_s);
		RS_2_2.setHeight(y*0.035);
		RS_2_2.setWidth(x*0.005);
		RS_2_2.setStroke(Color.TRANSPARENT);
		RS_2_2.setFill(Color.TRANSPARENT); 
		RS_2_2.setStrokeLineCap(StrokeLineCap.ROUND);
		HBox RS_2Hb = new HBox();
		VBox RS_2Vb = new VBox();
		RS_2Vb.getChildren().addAll(RS_2_2,RS_2);
		RS_2Vb.setAlignment(Pos.TOP_CENTER);
		RS_2Hb.getChildren().addAll(RS_2Vb);
		RS_2Hb.setAlignment(Pos.TOP_CENTER);
		GPane1_2.add(RS_2Hb, 4, 1);
		
		RS_2_1 = new Rectangle();
		Rectangle RS_2_2_1 = new Rectangle();
		RS_2_1.setHeight(y*0.077);
		RS_2_1.setWidth(x*0.003);
		RS_2_1.setStroke(Color.TRANSPARENT);
		RS_2_1.setFill(Color.rgb(166,166,166)); 
		RS_2_1.setStrokeLineCap(StrokeLineCap.ROUND);
		RS_2_1.setEffect(DP_s);
		RS_2_2_1.setHeight(y*0.034);
		RS_2_2_1.setWidth(x*0.005);
		RS_2_2_1.setStroke(Color.TRANSPARENT);
		RS_2_2_1.setFill(Color.TRANSPARENT); 
		RS_2_2_1.setStrokeLineCap(StrokeLineCap.ROUND);
		HBox RS_2_1Hb = new HBox();
		VBox RS_2_1Vb = new VBox();
		RS_2_1Vb.getChildren().addAll(RS_2_2_1,RS_2_1);
		RS_2_1Vb.setAlignment(Pos.TOP_CENTER);
		RS_2_1Hb.getChildren().addAll(RS_2_1Vb);
		RS_2_1Hb.setAlignment(Pos.TOP_CENTER);
		GPane1_2.add(RS_2_1Hb, 18, 1);
		
		//////////////////////////////////////
		RSB_1_2 = new Rectangle();
		RSB_1_2.setHeight(y*0.006);
		RSB_1_2.setWidth(x*0.009);
		RSB_1_2.setStroke(Color.TRANSPARENT);
		RSB_1_2.setFill(Color.rgb(166,166,166)); 
		RSB_1_2.setStrokeLineCap(StrokeLineCap.ROUND);
		RSB_1_2.setEffect(DP_s);
		HBox RSB_1_2Hb = new HBox();
		VBox RSB_1_2Vb = new VBox();
		RSB_1_2Vb.getChildren().addAll(RSB_1_2);
		RSB_1_2Vb.setAlignment(Pos.BOTTOM_CENTER);
		RSB_1_2Hb.getChildren().addAll(RSB_1_2Vb);
		RSB_1_2Hb.setAlignment(Pos.BOTTOM_CENTER);
		GPane1_3.add(RSB_1_2Hb, 7, 27);
		
		RSB_1_2_3 = new Rectangle();
		RSB_1_2_3.setHeight(y*0.006);
		RSB_1_2_3.setWidth(x*0.05);
		RSB_1_2_3.setStroke(Color.TRANSPARENT);
		RSB_1_2_3.setFill(Color.rgb(166,166,166)); 
		RSB_1_2_3.setStrokeLineCap(StrokeLineCap.ROUND);
		RSB_1_2_3.setEffect(DP_s);
		HBox RSB_1_2_3Hb = new HBox();
		VBox RSB_1_2_3Vb = new VBox();
		RSB_1_2_3Vb.getChildren().addAll(RSB_1_2_3);
		RSB_1_2_3Vb.setAlignment(Pos.BOTTOM_CENTER);
		RSB_1_2_3Hb.getChildren().addAll(RSB_1_2_3Vb);
		RSB_1_2_3Hb.setAlignment(Pos.BOTTOM_CENTER);
		GPane1_3.add(RSB_1_2_3Hb, 16, 27);
		
		RSB_1_2_3_4 = new Rectangle();
		RSB_1_2_3_4.setHeight(y*0.006);
		RSB_1_2_3_4.setWidth(x*0.008);
		RSB_1_2_3_4.setStroke(Color.TRANSPARENT);
		RSB_1_2_3_4.setFill(Color.rgb(166,166,166)); 
		RSB_1_2_3_4.setEffect(DP_s);
		RSB_1_2_3_4.setStrokeLineCap(StrokeLineCap.ROUND);
		HBox RSB_1_2_3_4Hb = new HBox();
		VBox RSB_1_2_3_4Vb = new VBox();
		RSB_1_2_3_4Vb.getChildren().addAll(RSB_1_2_3_4);
		RSB_1_2_3_4Vb.setAlignment(Pos.BOTTOM_CENTER);
		RSB_1_2_3_4Hb.getChildren().addAll(RSB_1_2_3_4Vb);
		RSB_1_2_3_4Hb.setAlignment(Pos.BOTTOM_LEFT);
		GPane1_3.add(RSB_1_2_3_4Hb, 28, 27);
		
		
		GPane1.add(GPane1_2, 0, 0);
		GPane1.add(GPane1_3, 0, 0);
		GPane1.add(GPane2, 1, 0);
		GPane1.add(GPane2_2, 2, 0);
		GPane2.add(GPane3, 0, 0);
		HBox VBu1h = new HBox();
		VBu1.getChildren().add(GPane43);
		VBu1.setAlignment(Pos.BOTTOM_RIGHT);
		VBu1h.getChildren().add(VBu1);
		VBu1h.setAlignment(Pos.CENTER);
		GPane3.add(VBu1h, 0, 2);
		GPane43.add(GPane44, 0, 0);
		bpR.getChildren().add(imageViewR);
		bpC.getChildren().add(imageViewC);
		bpB.getChildren().add(imageViewB);
		bpRP.getChildren().add(imageViewRP);
		bpCSV.getChildren().add(imageViewCSV);
		bpR.setAlignment(Pos.CENTER);
		bpC.setAlignment(Pos.CENTER);
		bpB.setAlignment(Pos.CENTER);
		bpRP.setAlignment(Pos.CENTER);
		bpCSV.setAlignment(Pos.CENTER);
		GPane44.add(bpCSV, 0, 0);
		GPane44.add(bpB, 1, 0);
		GPane44.add(bpRP, 2, 0);
		GPane44.add(bpC, 3, 0);
		GPane44.add(bpR, 4, 0);
		HBox VBu2h = new HBox();
		VBu2.getChildren().add(GPane42);
		VBu2.setAlignment(Pos.CENTER);
		VBu2h.getChildren().addAll(VBu2);
		VBu2h.setAlignment(Pos.CENTER_RIGHT);
		GPane3.add(VBu2h, 0, 3);
		VBu3.getChildren().add(imageView);
		VBu3.setAlignment(Pos.BOTTOM_RIGHT);
		HB0.getChildren().add(VBu3);
		HB0.setAlignment(Pos.BOTTOM_RIGHT);
		GPane42.add(HB0, 0, 0);

		HBox VBu4h = new HBox();
		VBu4h.getChildren().add(GPane41);
		VBu4h.setAlignment(Pos.CENTER_RIGHT);
		GPane2_2.add(VBu4h, 0, 0);
		VBu4.getChildren().add(GPane45);
		VBu4.setAlignment(Pos.CENTER);
		GPane41.add(VBu4, 0, 3);
		GPane45.add(GPane46, 0, 0);

		VBox VBbtnC = new VBox();
		VBox VBbtnD = new VBox();
		HBox HBbtnC = new HBox();
		HBox HBbtnD = new HBox();

		GPaneBtnC.add(porT, 0, 0);
		GPaneBtnD.add(porT2, 0, 0);

		VBbtnC.getChildren().add(GPaneBtnC);
		VBbtnD.getChildren().add(GPaneBtnD);
		VBbtnC.setAlignment(Pos.BOTTOM_CENTER);
		VBbtnD.setAlignment(Pos.BOTTOM_CENTER);

		HBbtnC.getChildren().add(VBbtnC);
		HBbtnD.getChildren().add(VBbtnD);
		HBbtnC.setAlignment(Pos.CENTER_LEFT);
		HBbtnD.setAlignment(Pos.CENTER_LEFT);

		VBu5.getChildren().add(HBbtnC);
		VBu5.setAlignment(Pos.BOTTOM_CENTER);
		VBu6.getChildren().add(HBbtnD);
		VBu6.setAlignment(Pos.BOTTOM_CENTER);
		GPane46.add(VBu5, 1, 0);
		GPane46.add(VBu6, 1, 1);

		VBu7.getChildren().add(cbX);
		VBu7.setAlignment(Pos.BOTTOM_CENTER);

		cbX.setPrefWidth(y * 0.16);
		cbX.setPrefHeight(y * 0.05);

		VBu9.getChildren().add(cbX2);
		VBu9.setAlignment(Pos.BOTTOM_CENTER);
		cbX2.setPrefWidth(y * 0.16);
		cbX2.setPrefHeight(y * 0.05);

		VBu8.getChildren().add(GPane47);
		VBu8.setAlignment(Pos.CENTER_RIGHT);
		VBu10.getChildren().add(GPane48);
		VBu10.setAlignment(Pos.CENTER_RIGHT);
		GPane46.add(VBu8, 0, 0);
		GPane47.add(VBu7, 0, 0);
		GPane46.add(VBu10, 0, 1);
		GPane48.add(VBu9, 0, 0);

//        HBbuttons.getChildren().addAll(imageViewR,imageViewC,imageViewB);
//        HBbuttons.setAlignment(Pos.CENTER);

//        GPbuttons.setGridLinesVisible(true);
//        
//        GPaneBtnC.setGridLinesVisible(true);
//        GPaneBtnD.setGridLinesVisible(true);
//        GPane46.setGridLinesVisible(true);
//        GPane45.setGridLinesVisible(true);
//        GPane41.setGridLinesVisible(true);
//        
		// BATTERY
//        GPane6.setGridLinesVisible(true);
//        //TASK
//        GPane7.setGridLinesVisible(true);
//        //TASK
//        GPane8.setGridLinesVisible(true);    
//        //MODE OF OPERATION (IMG)
//        GPane9.setGridLinesVisible(true);
//        GPane10.setGridLinesVisible(true);
//        //ACCELERATION, TEMP, ARCS
//        GPane12.setGridLinesVisible(true);
//        //TEXTS Tilt, GPS, etc
//        GPane131.setGridLinesVisible(true);
//        //MAP & Buttons (Calibration, Refresh)..
//       
//        GPane16.setGridLinesVisible(true);
//        //GRÁFICAS
//        GPane18.setGridLinesVisible(true);
		// TIME MISSION
//        GPane18.setGridLinesVisible(true);
//        GPane19.setGridLinesVisible(true);
//        //PORTO SERIAL y CMD
//        GPane22.setGridLinesVisible(true);

		// BOTONES FUNCIONIALES
//        GPane1_3.setGridLinesVisible(true);
//		GPane3.setGridLinesVisible(true);
//     	   GPane2_2.setGridLinesVisible(true); 
//        GPane2.setGridLinesVisible(true);
//        GPane41.setGridLinesVisible(true);
//        GPane42.setGridLinesVisible(true);
//		GPane43.setGridLinesVisible(true);
//		GPane44.setGridLinesVisible(true);
		
//        GPane45.setGridLinesVisible(true);
//        GPane46.setGridLinesVisible(true);
//        GPane47.setGridLinesVisible(true);
//        GPane48.setGridLinesVisible(true);

		GPane1.getStyleClass().add("mygridStyle");
		GPane1_2.getStyleClass().add("mygridStyle");
		GPane2.getStyleClass().add("mygridStyle");
		GPane2_2.getStyleClass().add("mygridStyle");

		GPane3.getStyleClass().add("mygridStyle");
		GPane4.getStyleClass().add("mygridStyle");
		GPane5.getStyleClass().add("mygridStyle");
		GPane6.getStyleClass().add("mygridStyle");
		GPane7.getStyleClass().add("mygridStyle");
		GPane8.getStyleClass().add("mygridStyle");
		GPane9.getStyleClass().add("mygridStyle");
		GPane10.getStyleClass().add("mygridStyle");
		GPane11.getStyleClass().add("mygridStyle");
		GPane12.getStyleClass().add("mygridStyle");
		GPane13.getStyleClass().add("mygridStyle");
		GPane14.getStyleClass().add("mygridStyle");
		GPane15.getStyleClass().add("mygridStyle");
		GPane16.getStyleClass().add("mygridStyle");
		GPane131.getStyleClass().add("mygridStyle");
		GPane17.getStyleClass().add("mygridStyle");
		GPane18.getStyleClass().add("mygridStyle");
		GPane19.getStyleClass().add("mygridStyle");
		GPane20.getStyleClass().add("mygridStyle");
		GPane21.getStyleClass().add("mygridStyle");
		GPane22.getStyleClass().add("mygridStyle");

		GPane41.getStyleClass().add("mygridStyle");
		GPane42.getStyleClass().add("mygridStyle");
		GPane43.getStyleClass().add("mygridStyle");
		GPane44.getStyleClass().add("mygridStyle");
		GPane45.getStyleClass().add("mygridStyle");
		GPane46.getStyleClass().add("mygridStyle");
		GPane47.getStyleClass().add("mygridStyle");
		GPane48.getStyleClass().add("mygridStyle");

		GPaneBtnC.getStyleClass().add("mygridStyle");
		GPaneBtnD.getStyleClass().add("mygridStyle");

		porT.setPrefSize(x * 0.1, y * 0.1);
		porT.setGraphic(imageViewConnect);
		porT.setPadding(Insets.EMPTY);

		porT.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent eventoboton) {

				System.out.println("Conexion establecida");
				if ((porT.getText() == "Connect")) {

					porT.setGraphic(imageViewDisconnect);
					t0 = (System.currentTimeMillis());
					porT.setText("Disconnect");

					try {

						csv = new CSVfile();
						Lectura();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("El error esta en el boton" + e);
					}

				}

				else {
					System.out.println("FINISH THREAD SERIALPORT");
					porT.setGraphic(imageViewConnect);

					csv.close();
					Porto.closePort();

					GRF1.getData().clear();
					GRF2.getData().clear();
					GRF3.getData().clear();
					GRF4.getData().clear();
					GRF5.getData().clear();
					GRF6.getData().clear();

					porT.setText("Connect");
					detener();

				}

			}

		});

		porT2.setPrefSize(x * 0.1, y * 0.1);
		porT2.setGraphic(imageViewSend);
		porT2.setPadding(Insets.EMPTY);

		porT2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent eventoboton) {
				String cmd = (String) cbX2.getValue();
				
				switch (cmd) {
				case "CMD,1040,FLY,ACTIVATE":
					System.out.println(cmd + "-> SEND");
		                byte[] F = "F".getBytes();
		                Porto.writeBytes(F, F.length);

					break;
				case "CMD,1040,CX,OFF":
	                byte[] y = "y".getBytes();
	                Porto.writeBytes(y, y.length);
					System.out.println(cmd + "-> SEND");
					break;
				case "CMD,1040,CX,ON":
	                byte[] Y = "Y".getBytes();
	                Porto.writeBytes(Y, Y.length);
					System.out.println(cmd + "-> SEND");
					break;
				case "CMD,1040,SIM,ENABLE":
					System.out.println(cmd + "-> SEND");
	                byte[] S = "S".getBytes();
	                Porto.writeBytes(S, S.length);
					break;
				case "CMD,1040,SIM,ACTIVATE":
					System.out.println(cmd + "-> SEND");
	                byte[] s = "s".getBytes();
	                Porto.writeBytes(s, s.length);
					break;
				case "CMD,1040,SIMP,93948":
					System.out.println(cmd + "-> SEND");
	                byte[] PD = "PD".getBytes();
	                Porto.writeBytes(PD, PD.length);
					System.out.println(cmd + "-> SEND");
				case "CMD,1040,POLOLU,RELEASE":
					System.out.println(cmd + "-> SEND");
	                byte[] A = "A".getBytes();
	                Porto.writeBytes(A, A.length);

					break;
				case "CMD,1040,POLOLU,CONF":
					System.out.println(cmd + "-> SEND");
	                byte[] B = "B".getBytes();
	                Porto.writeBytes(B, B.length);

					break;
				case "CMD,1040,POLOLU,STOP":
					System.out.println(cmd + "-> SEND");
	                byte[] C = "C".getBytes();
	                Porto.writeBytes(C, C.length);

					break;
				case "CMD,1040,POLOLU,AEROBRAKE":
					System.out.println(cmd + "-> SEND");
	                byte[] a = "a".getBytes();
	                Porto.writeBytes(a, a.length);

					break;
				case "CMD,1040,CAMERA,ABCONF":
					System.out.println(cmd + "-> SEND");
	                byte[] b = "b".getBytes();
	                Porto.writeBytes(b, b.length);

					break;
				case "CMD,1040,POLOLU,ABSTOP":
					System.out.println(cmd + "-> SEND");
	                byte[] c = "c".getBytes();
	                Porto.writeBytes(c, c.length);

					break;
				case "CMD,1040,CAMERA,ON":
					System.out.println(cmd + "-> SEND");
	                byte[] R = "R".getBytes();
	                Porto.writeBytes(R, R.length);

					break;
				case "CMD,1040,CAMERA,STOP":
					System.out.println(cmd + "-> SEND");
	                byte[] T = "T".getBytes();
	                Porto.writeBytes(T, T.length);

					break;
				case "CMD,1040,BUZZ,ACTIVATE":
					System.out.println(cmd + "-> SEND");
	                byte[] Z = "Z".getBytes();
	                Porto.writeBytes(Z, Z.length);

					break;
				case "CMD,1040,BUZZ,STOP":
					System.out.println(cmd + "-> SEND");
	                byte[] z = "z".getBytes();
	                Porto.writeBytes(z, z.length);

					break;
				case "CMD,1040,TIME":
			        LocalDateTime now = LocalDateTime.now();  
			        System.out.println("Before Formatting: " + now);  
			        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");  
			        String formatDateTime = now.format(format);  
			        System.out.println("SET TIME: " + formatDateTime);  
					System.out.println(cmd + "-> SEND");
	                byte[] X = formatDateTime.getBytes();
	                Porto.writeBytes(X, X.length);

					break;
				case "CMD,1040,CAL":
					System.out.println(cmd + "-> SEND");
	                byte[] G = "G".getBytes();
	                Porto.writeBytes(G, G.length);

					break;				
				case "CMD,1040,MAST_RAISED":
					System.out.println(cmd + "-> SEND");
	                byte[] x = "x".getBytes();
	                Porto.writeBytes(x, x.length);
	                
					break;
				case "CMD,1040,EXIT":
	            	Platform.exit();
	            	System.exit(0);
	            	break;
				default:
					break;
				//falta el de comando de presion-
				}

			}

		});

		SP();

		root.getChildren().add(GPane0);
	}

	public void SP() {

		SerialPort[] SPort = SerialPort.getCommPorts();

		for (int i = 0; i < SPort.length; i++) {
			listPort.addAll(SPort[i].getSystemPortName());
			// cbx.getItems().add(SPort[i].getSystemPortName());
			cbX.setItems(listPort);
		}

	}

	//////////////////////////////////////// Lectura

	public void Lectura() {

		System.out.println(cbX.getValue().toString());
		Porto = SerialPort.getCommPort(cbX.getValue().toString());
		Porto.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);

		if (Porto.openPort()) {
			Reloj();
			Task tarea = new Task<Void>() {
				@Override
				protected Void call() throws Exception {
					try (Scanner scanner = new Scanner(Porto.getInputStream())) {
						while (scanner.hasNextLine()) {
							line = (scanner.nextLine());
							String[] tel = line.split(",");
							System.out.println(line);
	                    	contador1++;
	                    	if(ValorEnviado>senData.size()) {
	                			hilo2.stop();
							}
							try {

								if (tel.length >= 20) {

									Platform.runLater(new Runnable() {
										@Override
										public void run() {
											t = (System.currentTimeMillis() - t0) / 1000;

											GRF1.getData().add(new XYChart.Data(t, Float.parseFloat(tel[9])));// ti
                                            GRF2.getData().add(new XYChart.Data(t,Float.parseFloat(tel[21])));//te                                   
											GRF3.getData().add(new XYChart.Data(t, Float.parseFloat(tel[11])));// ti

											GRF4.getData().add(new XYChart.Data(t, Float.parseFloat(tel[5])));// ti

											Temperature.setText(tel[9] + "\n °C");
											Altitude.setText(tel[5] + "\n  m");
											dataAlt = Double.parseDouble(tel[5]);
											Anim_Alt(dataAlt,arc4);

											Pressure.setText(tel[11] + "\nKPa");
											dataPress = Double.parseDouble(tel[11]);
											Anim_Press(dataPress,arc6);

                                            Acceleration.setText(tel[21] + " \nm/s^2");
                                            Compass.setText(tel[22] + " 0.0°");
											Voltage.setText(tel[10] + "V");
											dataBattery = Double.parseDouble(tel[10]);
											Anim_Battery(dataBattery, R2, dataWRect);
											dataTemp = Double.parseDouble(tel[9]);
											Anim_Temp(dataTemp, arc2);
											dataAccel = Double.parseDouble(tel[21]);

											Anim_Acce(dataAccel,arc8);

											Tilt_X.setText(tel[17] + "°");
											Tilt_Y.setText(tel[18] + "°");
											Gps_Time.setText(tel[12]);
											Gps_Altitude.setText(tel[13] + "m");
											Gps_Latitude.setText(tel[14] + "°N");
											Gps_Longitude.setText(tel[15] + " °W");
											Gps_Sats.setText(tel[16]);
											
                                            cC5 = Double.parseDouble(tel[22]);
                                            comPASSDATA = Double.parseDouble(tel[22]);
                                            dataState = tel[4];
                                            StateCanSat(dataState, CE1,RS_1,CE2,RS_2,RSB_1_2,CE3,RSB_1_2_3,CE4,RSB_1_2_3_4,CE5,RS_2_1,CE6,RS_1_2);
                                            TaskCanSatStandBy(tel[4]);
                                            TaskCanSatGPS(tel[23]);
                                            TaskCanSatCamera(tel[20]);
                                            TaskCanSatAerobraking(tel[6]);
                                            TaskCanSatFlagRaised(tel[8]);
                                            Brujula(Compass, comPASSDATA);
                                            double valorC = -1; 
                                            RotateTransition rt = new RotateTransition(Duration.INDEFINITE, imageViewP);
                                                 rt.setByAngle(0);
                                                 rt.setFromAngle(cC5);
                                                 rt.setCycleCount(Timeline.INDEFINITE);
                                                 rt.setAutoReverse(true);
                                             
                                                 rt.play();

										}
									});

								}
								csv.save(line);

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out.println("Error en la linea de elementos" + e);

							}
	                    	contador2++;

						}

					}

					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Error en el metodo general" + e);

					}

					return null;
				}

			};

			Thread thread1 = new Thread(tarea);
			thread1.setDaemon(true);
			thread1.start();

		} else {

			Reloj();
			System.out.println("FINISH THREAD CLOCK");
		}
	}

	/*
	 * 
	 * Metodo para la animación de la brujula.
	 * 
	 * @param s
	 * 
	 * @param c s, el texto que va a iterar c, el dato que se va trabajar
	 * 
	 **/
	private void Brujula(Text s, double c) {

		if (c == 0 || c == 360) {
			s.getText();
			s.setText("NORTE");
//            s.setStroke(Color.ALICEBLUE);
			s.setFont(new Font("OCR A Extended", 23));
		}
	}

	public void Anim_Battery(double data, Rectangle R, double WR) {
		R.setWidth((data*WR)/9);
	}
	public void Anim_Temp(double temp, Arc Arc2) {
		Arc2.setLength(-((2.4*temp)+96));
	}
	public void Anim_Alt(double alt, Arc Arc4) {
		Arc4.setLength(-((0.3*alt)));
	}
	public void Anim_Press(double press, Arc Arc6) {
		Arc6.setLength(-((3.75*press)-112.5));
	}
	public void Anim_Acce(double acce, Arc Arc8) {
		Arc8.setLength(-((1.9113149847095*acce)));
	}
	
	public void btnSelected() {
		String message = "Your chose ";
		message += cbX2.getValue();
		System.out.println(message + "Your choice");
	}
	
	private static void leerArchivo(File arch)throws IOException{
		
		try(BufferedReader in = new BufferedReader(new FileReader(arch))){
			
			String linea=in.readLine();
			System.out.println(linea);
			try {
				while(linea!= null) {
					datos.add(linea);
					System.out.println(linea);
					linea= in.readLine();
				}
			} catch (Exception e) {
				System.out.println("ERROR ---> LINEA");
			}
		}
		
	}
	
//	private static void leerArchivo(File arch) throws IOException{
//		try(BufferedReader in = new BufferedReader(new FileReader(arch))){
//		String linea = in.readLine();
//		while(linea != null){
//			datos.add(linea);
//			linea = in.readLine();
//		}
//		
//		}
//	}
	
	private static void addBytes(ArrayList<String> dat) {
		try {
			String [] campos = {};
			for(int i=2; i<datos.size(); i++)
			{
				System.out.println("IMPRIMIENDO: "+datos.get(i).toString());
				campos = datos.get(i).split(",");
				System.out.println("PRESS: " + campos[3]);
//				System.out.println(campos);
				if(Porto.openPort()) {
					
					senData.add(campos[3]);
					
				}
			}
			hilo2 = new Thread(hiloCsv());
			hilo2.start();
//			System.out.println("sendData: "+senData);
		} catch (Exception e) {
			System.out.println("No se pueden agregar los datos");
		}
	}
	
	
	public static Runnable hiloCsv() {
		return new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					for(ValorEnviado = 0; ValorEnviado<=senData.size() && (contador1-contador2)==0;ValorEnviado++) {
		             	try{
		             		System.out.println(senData.get(ValorEnviado));	
			             	byte[] J = senData.get(ValorEnviado).getBytes();  
			             	byte[] N = ("\n").getBytes();
			             	Porto.writeBytes(J, J.length);
			             	Porto.writeBytes(N, N.length);
			             	
		             	}
		             	catch(Exception e) {
		             		System.out.println("The archive is finished");
		             	}
					 	try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 	}
			 	break;
				}
			}
		};
	}

	private void TaskCanSatStandBy(String data1) {
		
		if(data1.equals("LAUNCH-WAIT") && (!data1.equals("MAST RAISED") ||
				 !data1.equals("ASCENT") || !data1.equals("ROCKET SEPARATION") ||
				 !data1.equals("AEROBRAKING RELEASE")) ) {
			C1.setFill(Color.rgb(153,0,204));
		}else if (data1.equals("MAST RAISED") && (!data1.equals("LAUNCH-WAIT	") ||
				 !data1.equals("ASCENT") || !data1.equals("ROCKET SEPARATION") ||
				 !data1.equals("AEROBRAKING RELEASE"))){
			C1.setFill(Color.LIME);
		}else if(!data1.equals("LAUNCH-WAIT") || !data1.equals("MAST RAISED") ||
				 !data1.equals("ASCENT") || !data1.equals("ROCKET SEPARATION") ||
				 !data1.equals("AEROBRAKING RELEASE")){
			C1.setFill(Color.rgb(102, 0, 51));
		}
	}
	
	private void TaskCanSatGPS(String data1) {
		
		if(data1.equals("YES")) {
			C2.setFill(Color.rgb(197, 90, 17));
		}else {
			C2.setStroke(Color.rgb(102, 0, 51));
		}
	}
	
	private void TaskCanSatCamera(String data1) {
		
		if(data1.equals("ON")) {
			C3.setFill(Color.rgb(197, 90, 17));
		}else {
			C3.setStroke(Color.rgb(102, 0, 51));
		}
	}
	
	private void TaskCanSatFlagRaised(String data1) {
		if(data1.equals("M")) {
			C4.setFill(Color.rgb(197, 90, 17));
		}else {
			C4.setStroke(Color.rgb(102, 0, 51));
		}
	}
	
	private void TaskCanSatAerobraking(String data1) {
		
		if(data1.equals("P")) {
			C5.setFill(Color.rgb(197, 90, 17));
		}else {
			C5.setStroke(Color.rgb(102, 0, 51));
		}
	}

	private void StateCanSat(String data, Circle CE1, Rectangle RS_1, Circle CE2, Rectangle RS_2, Rectangle RSB_1_2,
			Circle CE3, Rectangle RSB_1_2_3, Circle CE4, Rectangle RSB_1_2_3_4, Circle CE5, Rectangle RS_2_1,
			Circle CE6, Rectangle RS_1_2) {

		DropShadow sh = new DropShadow();
		sh.setColor(Color.YELLOW);

		if (data.equals("LAUNCH-WAIT")) {
			CE1.setFill(Color.rgb(197, 90, 17));
			CE1.setStroke(Color.rgb(102, 0, 51));
			CE1.setEffect(sh);
			RS_1.setFill(Color.rgb(197, 90, 17));
			RS_1.setStroke(Color.rgb(102, 0, 51));
		} else if (data.equals("ASCENT")) {
			CE1.setFill(Color.rgb(197, 90, 17));
			CE1.setStroke(Color.rgb(102, 0, 51));
			CE1.setEffect(sh);
			RS_1.setFill(Color.rgb(197, 90, 17));
			RS_1.setStroke(Color.rgb(102, 0, 51));
			RS_1.setEffect(sh);
			CE2.setFill(Color.rgb(197, 90, 17));
			CE2.setStroke(Color.rgb(102, 0, 51));
			CE2.setEffect(sh);
			RS_2.setFill(Color.rgb(197, 90, 17));
			RS_2.setStroke(Color.rgb(102, 0, 51));
			RS_2.setEffect(sh);
			RSB_1_2.setFill(Color.rgb(197, 90, 17));
			RSB_1_2.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2.setEffect(sh);
		} else if (data.equals("ROCKET SEPARATION")) {
			CE1.setFill(Color.rgb(197, 90, 17));
			CE1.setStroke(Color.rgb(102, 0, 51));
			CE1.setEffect(sh);
			RS_1.setFill(Color.rgb(197, 90, 17));
			RS_1.setStroke(Color.rgb(102, 0, 51));
			RS_1.setEffect(sh);
			CE2.setFill(Color.rgb(197, 90, 17));
			CE2.setStroke(Color.rgb(102, 0, 51));
			CE2.setEffect(sh);
			RS_2.setFill(Color.rgb(197, 90, 17));
			RS_2.setStroke(Color.rgb(102, 0, 51));
			RS_2.setEffect(sh);
			RSB_1_2.setFill(Color.rgb(197, 90, 17));
			RSB_1_2.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2.setEffect(sh);
			CE3.setFill(Color.rgb(197, 90, 17));
			CE3.setStroke(Color.rgb(102, 0, 51));
			CE3.setEffect(sh);
			RSB_1_2_3.setFill(Color.rgb(197, 90, 17));
			RSB_1_2_3.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2_3.setEffect(sh);
		} else if (data.equals("DESCENT")) {
			CE1.setFill(Color.rgb(197, 90, 17));
			CE1.setStroke(Color.rgb(102, 0, 51));
			CE1.setEffect(sh);
			RS_1.setFill(Color.rgb(197, 90, 17));
			RS_1.setStroke(Color.rgb(102, 0, 51));
			RS_1.setEffect(sh);
			CE2.setFill(Color.rgb(197, 90, 17));
			CE2.setStroke(Color.rgb(102, 0, 51));
			CE2.setEffect(sh);
			RS_2.setFill(Color.rgb(197, 90, 17));
			RS_2.setStroke(Color.rgb(102, 0, 51));
			RS_2.setEffect(sh);
			RSB_1_2.setFill(Color.rgb(197, 90, 17));
			RSB_1_2.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2.setEffect(sh);
			CE3.setFill(Color.rgb(197, 90, 17));
			CE3.setStroke(Color.rgb(102, 0, 51));
			CE3.setEffect(sh);
			RSB_1_2_3.setFill(Color.rgb(197, 90, 17));
			RSB_1_2_3.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2_3.setEffect(sh);
			CE4.setFill(Color.rgb(197, 90, 17));
			CE4.setStroke(Color.rgb(102, 0, 51));
			CE4.setEffect(sh);
			RSB_1_2_3_4.setFill(Color.rgb(197, 90, 17));
			RSB_1_2_3_4.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2_3_4.setEffect(sh);
		} else if (data.equals("AEROBRAKING RELEASE")) {
			CE1.setFill(Color.rgb(197, 90, 17));
			CE1.setStroke(Color.rgb(102, 0, 51));
			CE1.setEffect(sh);
			RS_1.setFill(Color.rgb(197, 90, 17));
			RS_1.setStroke(Color.rgb(102, 0, 51));
			RS_1.setEffect(sh);
			CE2.setFill(Color.rgb(197, 90, 17));
			CE2.setStroke(Color.rgb(102, 0, 51));
			CE2.setEffect(sh);
			RS_2.setFill(Color.rgb(197, 90, 17));
			RS_2.setStroke(Color.rgb(102, 0, 51));
			RS_2.setEffect(sh);
			RSB_1_2.setFill(Color.rgb(197, 90, 17));
			RSB_1_2.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2.setEffect(sh);
			CE3.setFill(Color.rgb(197, 90, 17));
			CE3.setStroke(Color.rgb(102, 0, 51));
			CE3.setEffect(sh);
			RSB_1_2_3.setFill(Color.rgb(197, 90, 17));
			RSB_1_2_3.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2_3.setEffect(sh);
			CE4.setFill(Color.rgb(197, 90, 17));
			CE4.setStroke(Color.rgb(102, 0, 51));
			CE4.setEffect(sh);
			RSB_1_2_3_4.setFill(Color.rgb(197, 90, 17));
			RSB_1_2_3_4.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2_3_4.setEffect(sh);
			CE5.setFill(Color.rgb(197, 90, 17));
			CE5.setStroke(Color.rgb(102, 0, 51));
			CE5.setEffect(sh);
			RS_2_1.setFill(Color.rgb(197, 90, 17));
			RS_2_1.setStroke(Color.rgb(102, 0, 51));
			RS_2_1.setEffect(sh);
		} else if (data.equals("MAST RAISED")) {
			CE1.setFill(Color.rgb(197, 90, 17));
			CE1.setStroke(Color.rgb(102, 0, 51));
			CE1.setEffect(sh);
			RS_1.setFill(Color.rgb(197, 90, 17));
			RS_1.setStroke(Color.rgb(102, 0, 51));
			RS_1.setEffect(sh);
			CE2.setFill(Color.rgb(197, 90, 17));
			CE2.setStroke(Color.rgb(102, 0, 51));
			CE2.setEffect(sh);
			RS_2.setFill(Color.rgb(197, 90, 17));
			RS_2.setStroke(Color.rgb(102, 0, 51));
			RS_2.setEffect(sh);
			RSB_1_2.setFill(Color.rgb(197, 90, 17));
			RSB_1_2.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2.setEffect(sh);
			CE3.setFill(Color.rgb(197, 90, 17));
			CE3.setStroke(Color.rgb(102, 0, 51));
			CE3.setEffect(sh);
			RSB_1_2_3.setFill(Color.rgb(197, 90, 17));
			RSB_1_2_3.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2_3.setEffect(sh);
			CE4.setFill(Color.rgb(197, 90, 17));
			CE4.setStroke(Color.rgb(102, 0, 51));
			CE4.setEffect(sh);
			RSB_1_2_3_4.setFill(Color.rgb(197, 90, 17));
			RSB_1_2_3_4.setStroke(Color.rgb(102, 0, 51));
			RSB_1_2_3_4.setEffect(sh);
			CE5.setFill(Color.rgb(197, 90, 17));
			CE5.setStroke(Color.rgb(102, 0, 51));
			CE5.setEffect(sh);
			RS_2_1.setFill(Color.rgb(197, 90, 17));
			RS_2_1.setStroke(Color.rgb(102, 0, 51));
			RS_2_1.setEffect(sh);
			CE6.setFill(Color.rgb(197, 90, 17));
			CE6.setStroke(Color.rgb(102, 0, 51));
			CE6.setEffect(sh);
			RS_1_2.setFill(Color.rgb(197, 90, 17));
			RS_1_2.setStroke(Color.rgb(102, 0, 51));
			RS_1_2.setEffect(sh);
		}

	}
	
	//Cronommeter
	public static void Reloj() {
		ActiveClock = !ActiveClock;
		clock = new Thread(new Runnable(){
			@Override 
			public void run() {
				Runnable updater = new Runnable() {
					@Override
					public void run() {
						timer.setText(missionTime);
						t = currentTime/1000;
					}
				};
				while(ActiveClock){
					if(ActiveClock){
						try {
							Thread.sleep(250);
							missionTime="";
							if(initialTime==0)
								initialTime=System.currentTimeMillis();
							else {
							currentTime=System.currentTimeMillis()-initialTime;
							}
							
							hora=(long) (currentTime/3600000);
							min=(long) ((currentTime-(hora*3600000))/60000);
							seg=(long)((currentTime-((hora*3600000)+(min*60000)))/1000);
							
							if (hora<10){
								missionTime+= "0" + Long.toString(hora)+":";
							}else{
								missionTime+=Long.toString(hora)+":";
							}
							if (min<10){
								missionTime+= "0" +Long.toString(min)+":";
							}else{
								missionTime+= Long.toString(min)+":";
							}
							if (seg<10){
								missionTime+= "0" +Long.toString(seg);
							}else{
								missionTime+=Long.toString(seg);
							}
							 Platform.runLater(updater);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}	
				}
			}

		});
		if(ActiveClock) {
			initialTime=0;
			clock.start();	
		}else {
		}
	}
	public static void detener() {
		ActiveClock = false;
	}

}