package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root;
        loader.setLocation(getClass().getResource("/sample/FXML/loginPage.fxml"));
        root = loader.load();
        primaryStage.setScene(new Scene(root, 1058, 600));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
