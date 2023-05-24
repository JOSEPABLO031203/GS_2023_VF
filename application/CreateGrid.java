package application;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class CreateGrid {
	public void createGrid(GridPane grid, double x, double y, int a, int b) {
		for(int i=0;i<a;i++) {
        	ColumnConstraints colum = new ColumnConstraints(x/a);
        	grid.getColumnConstraints().add(colum);
        }
        for(int i=0;i<b;i++) {
        	RowConstraints row = new RowConstraints(y/b);
        	grid.getRowConstraints().add(row);
        }
	}
}
