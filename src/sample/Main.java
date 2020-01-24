package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataCenter.NewStudent;
import sample.DataCenter.Student;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        NewStudent std = new NewStudent();
        FXMLLoader loader = new FXMLLoader();
        Parent root;
        std.setGender(0);
        std.setDay_night(true);
        std.setField("کامپیدنر");
        std.setFileNumber(31222213);
        std.setFirstName("علی");
        std.setRate(1800);
        std.setID(1362942138);
        std.setLastName("فرقانی");
        sample.Controllers.NewStudent newStudent = new sample.Controllers.NewStudent();
        newStudent.setStd(std);

        loader.setController(newStudent);
        loader.setLocation(getClass().getResource("/sample/FXML/NewStudent.fxml"));

        root = loader.load();


      //  primaryStage.setTitle("سیستم سما");

        primaryStage.setScene(new Scene(root, 1058, 600));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
