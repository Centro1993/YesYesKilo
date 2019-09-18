package sample;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Controller {
    public GridPane grid = null;

    private int cols = 15;
    private int rows = 15;

    void load() {
        grid.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        this.setGridSize(this.cols, this.rows);
    }

    void setGridSize(int cols, int rows) {
        // clear gridpane
        grid.getColumnConstraints().removeAll();
        grid.getRowConstraints().removeAll();

        for(int col = 0; col < cols; col++) {
            grid.getColumnConstraints().add(new ColumnConstraints(50));
        }
        for(int row = 0; row < rows; row++) {
            grid.getRowConstraints().add(new RowConstraints(50));
        }
    }
}
