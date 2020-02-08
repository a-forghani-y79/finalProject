package sample.TestTools.RAndD.Navigation_Drawer_Menu;

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
        loader.setLocation(getClass().getResource("/sample/TestTools/RAndD/Navigation_Drawer_Menu/main.fxml"));
        root = loader.load();
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}