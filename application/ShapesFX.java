package application;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ShapesFX {
	public void createRect(Rectangle R, GridPane GPane, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		R.setHeight(Ht);
		R.setWidth(Wh);
		R.setStroke(colorS);
		R.setFill(colorF); 
		R.setStrokeLineCap(StrokeLineCap.ROUND);
		GPane.add(R, x, y);
	}
	
	public void createCirc(Circle C1, Circle C2, Circle C3, GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		C2.setCenterX(0);
		C2.setCenterY(0);
		C2.setRadius(Ht);
		C2.setFill(colorS);
		C2.setStroke(colorF);
		C3.setCenterX(0);
		C3.setCenterY(0);
		C3.setRadius(Ht);
		C3.setFill(colorS);
		C3.setStroke(colorF);
		VBx.getChildren().addAll(C3,C2,C1);
		VBx.setAlignment(Pos.CENTER);
		GPane.add(VBx, x, y);
	}
	
	public void createCirc2(Circle C1, Circle C2,GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		C2.setCenterX(0);
		C2.setCenterY(0);
		C2.setRadius(Ht);
		C2.setFill(colorS);
		C2.setStroke(colorF);
		VBx.getChildren().addAll(C2,C1);
		VBx.setAlignment(Pos.CENTER);
		GPane.add(VBx, x, y);
	}
	
	public void createCirc3(Circle C1,GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos. BOTTOM_RIGHT);
		GPane.add(VBx, x, y);
	}
	public void createCirc4(Circle C1,GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos.TOP_CENTER);
		GPane.add(VBx, x, y);
	}
	public void createCirc5(Circle C1,GridPane GPane, HBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos.TOP_LEFT);
		GPane.add(VBx, x, y);
	}
	public void createCirc6(Circle C1,GridPane GPane, HBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos.BOTTOM_LEFT);
		GPane.add(VBx, x, y);
	}
	public void createCirc7(Circle C1,GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos.TOP_RIGHT);
		GPane.add(VBx, x, y);
	}
	
	
	
	public void createArc(Arc Arc, Color Color1, Color Color2, double D, double X, double Y, double Rx, double Ry, double Sa, double L, DropShadow Dp) {
		Arc.setFill(Color1);
		Arc.setStroke(Color2);
		Arc.setStrokeWidth(D);
		Arc.setCenterX(X/2);
		Arc.setCenterY(Y/2);
		Arc.setRadiusX(Rx);
		Arc.setRadiusY(Ry);
		Arc.setStartAngle(Sa);
		Arc.setLength(L);
//		Arc.setEffect(Dp);
		
	}
	
	public void createText(Text Text, Color Color1,  DropShadow Dp, double X, double Y){
		Text.setFill(Color1);
		Text.setEffect(Dp);
		Text.setX(X/2);
		Text.setY(Y/2);
	}
	
	
	
	
	//==========
	public void createRect0(Rectangle R, GridPane GPane, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		R.setHeight(Ht);
		R.setWidth(Wh);
		R.setStroke(colorS);
		R.setFill(colorF); 
		R.setStrokeLineCap(StrokeLineCap.ROUND);
		GPane.add(R, x, y);
	}
	
	public void createCirc0(Circle C1, Circle C2, Circle C3, GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		C1.setFill(Color.rgb(138, 0, 138));
		C2.setCenterX(0);
		C2.setCenterY(0);
		C2.setRadius(Ht);
		C2.setFill(colorS);
		C2.setStroke(colorF);
		C3.setCenterX(0);
		C3.setCenterY(0);
		C3.setRadius(Ht);
		C3.setFill(colorS);
		C3.setStroke(colorF);
		
		C3.setFill(Color.rgb(197, 90, 17));
		VBx.getChildren().addAll(C3,C2,C1);
		VBx.setAlignment(Pos.CENTER);
		GPane.add(VBx, x, y);
	}
	
	public void createCirc22(Circle C1, Circle C2,GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		C2.setCenterX(0);
		C2.setCenterY(0);
		C2.setRadius(Ht);
		C2.setFill(colorS);
		C2.setStroke(colorF);
		VBx.getChildren().addAll(C2,C1);
		VBx.setAlignment(Pos.CENTER);
		GPane.add(VBx, x, y);
	}
	
	public void createCirc33(Circle C1,GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos. BOTTOM_RIGHT);
		GPane.add(VBx, x, y);
	}
	public void createCirc44(Circle C1,GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos.TOP_CENTER);
		GPane.add(VBx, x, y);
	}
	public void createCirc55(Circle C1,GridPane GPane, HBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos.TOP_LEFT);
		GPane.add(VBx, x, y);
	}
	public void createCirc66(Circle C1,GridPane GPane, HBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos.BOTTOM_LEFT);
		GPane.add(VBx, x, y);
	}
	public void createCirc77(Circle C1,GridPane GPane, VBox VBx, double Ht, double Wh, Color colorS, Color colorF, int x, int y){
		C1.setCenterX(0);
		C1.setCenterY(0);
		C1.setRadius(Ht);
		C1.setFill(colorS);
		C1.setStroke(colorF);
		VBx.getChildren().addAll(C1);
		VBx.setAlignment(Pos.TOP_RIGHT);
		GPane.add(VBx, x, y);
	}
	
	
	
	public void createArc0(Arc Arc, Color Color1, Color Color2, double D, double X, double Y, double Rx, double Ry, double Sa, double L, DropShadow Dp) {
		Arc.setFill(Color1);
		Arc.setStroke(Color2);
		Arc.setStrokeWidth(D);
		Arc.setCenterX(X/2);
		Arc.setCenterY(Y/2);
		Arc.setRadiusX(Rx);
		Arc.setRadiusY(Ry);
		Arc.setStartAngle(Sa);
		Arc.setLength(L);
//		Arc.setEffect(Dp);
		
	}
	
	public void createText0(Text Text, Color Color1,  DropShadow Dp, double X, double Y){
		Text.setFill(Color1);
		Text.setEffect(Dp);
		Text.setX(X/2);
		Text.setY(Y/2);
	}
	
	
	
}
