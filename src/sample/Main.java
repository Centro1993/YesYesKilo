package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = (Parent)loader.load();
        Controller controller = (Controller)loader.getController();
        controller.load();

        primaryStage.setTitle("Nonogram Solver");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
