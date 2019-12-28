import javafx.scene.text.Text;
import org.tbee.javafx.scene.layout.MigPane;

public class Controller {
    private static int nonogramGridSize = 20;

    /* PANES */
    public MigPane mainPanel = null;

    private MigPane horizontalNumberPane = new MigPane();
    private MigPane verticalNumberPane = new MigPane();

    void load() {
        mainPanel.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        for (int i = 0; i < nonogramGridSize; i++) {
            Text number = new Text(10, 20, String.valueOf(i));

            horizontalNumberPane.add(number, "width 10:20:40");
            verticalNumberPane.add(number, "width 10:20:40");
        }

        mainPanel.add(horizontalNumberPane, "dock north");
        mainPanel.add(verticalNumberPane, "dock west");
    }
}
