import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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

        // Menu
        MenuBar menuBar = new MenuBar();

        // --- Menu File
        Menu menuFile = new Menu("File");

        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");

        // --- Menu View
        Menu menuView = new Menu("View");

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        root.add(menuBar, "dock north");

        // Nonogram-Grid
        MigPane nonogramGrid = new MigPane("wrap " + (NONOGRAM_GRID_SIZE + MAX_DIRECTIVES_COUNT));
        root.add(nonogramGrid);

        for (int x = 0; x < NONOGRAM_GRID_SIZE + MAX_DIRECTIVES_COUNT; x++) {
            for (int y = 0; y < NONOGRAM_GRID_SIZE + MAX_DIRECTIVES_COUNT; y++) {
                // add placeholders in the top left corner
                if(x < MAX_DIRECTIVES_COUNT && y < MAX_DIRECTIVES_COUNT) {
                    nonogramGrid.add(new Text(), "width 10:20:40");
                }
                // add directives if above the checkboxes
                else if(x >= MAX_DIRECTIVES_COUNT && y < MAX_DIRECTIVES_COUNT) {
                    Text directiveHorizontal = new Text(10, 20, String.valueOf(y));
                    nonogramGrid.add(directiveHorizontal, "width 10:20:40");
                }
                // add directives to the left of the checkboxes
                else if(x < MAX_DIRECTIVES_COUNT && y >= MAX_DIRECTIVES_COUNT) {
                    Text directiveVertical = new Text(10, 20, String.valueOf(x));
                    nonogramGrid.add(directiveVertical, "width 10:20:40");
                }
                // add checkboxes in the grid area
                else {
                    CheckBox box = new CheckBox();
                    nonogramGrid.add(box, "width 10:20:40");
                }
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
