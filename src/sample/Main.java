package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Master.fxml"));
        //  primaryStage.setTitle("سیستم سما");

        primaryStage.setScene(new Scene(root, 1058, 600));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
