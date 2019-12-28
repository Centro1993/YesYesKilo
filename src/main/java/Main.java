import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.tbee.javafx.scene.layout.MigPane;

public class Main extends Application {
    private static final int MAX_DIRECTIVES_COUNT = 8;
    private static final int NONOGRAM_GRID_SIZE = 20;

    MigPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new MigPane("", "[grow][]", "[][][grow][]");
        Scene scene = new Scene(root);
        primaryStage.isResizable();
        primaryStage.setTitle("YesYesKilo");

        // Directive-Panes
        MigPane horizontalNumberPane = new MigPane();
        for ( int h = 1; h <= MAX_DIRECTIVES_COUNT; h++) {
            horizontalNumberPane.add(new Text(), "width 10:20:40");     // Placeholder for upper-left corner
        }
        MigPane verticalNumberPane = new MigPane("wrap 1");

        for (int i = 1; i <= NONOGRAM_GRID_SIZE; i++) {
            MigPane directiveColumn = new MigPane("wrap 1");
            MigPane directiveRow = new MigPane();

            for ( int h = 1; h <= MAX_DIRECTIVES_COUNT; h++) {
                Text numberHori = new Text(10, 20, String.valueOf(h));
                Text numberVert = new Text(10, 20, String.valueOf(h));

                directiveColumn.add(numberHori, "width 10:20:40");
                directiveRow.add(numberVert, "height 10:18:40");
            }

            horizontalNumberPane.add(directiveColumn, "width 10:20:40");
            verticalNumberPane.add(directiveRow, "height 10:18:40");
        }

        root.add(horizontalNumberPane, "dock north");
        root.add(verticalNumberPane, "dock west");

        // Checkbox-Grid
        MigPane checkboxGrid = new MigPane("wrap " + NONOGRAM_GRID_SIZE);
        root.add(checkboxGrid);

        for (int x = 0; x < NONOGRAM_GRID_SIZE; x++) {
            for (int y = 0; y < NONOGRAM_GRID_SIZE; y++) {
                CheckBox box = new CheckBox();
                checkboxGrid.add(box, "width 10:20:40");
            }
        }

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
