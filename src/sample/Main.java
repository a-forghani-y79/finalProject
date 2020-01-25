package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Controllers.StudentController;
import sample.DataCenter.FieldDataCenter;
import sample.DataCenter.NewStudentDataCenter;
import sample.DataCenter.StudentDataCenter;

import java.util.ArrayList;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        StudentController studentController = new StudentController();
        StudentDataCenter student = new StudentDataCenter();
        FieldDataCenter fieldDataCenter = new FieldDataCenter();
        fieldDataCenter.setScore(12);
        fieldDataCenter.setClassStartTime("12-12-12");
        fieldDataCenter.setFieldName("math");
        fieldDataCenter.setFieldNumber(123456);
        fieldDataCenter.setMasterName("tanha");
        fieldDataCenter.setTimeToTakeExam("1398-2-30/12:20");
        fieldDataCenter.setUnit(3);
         ArrayList<FieldDataCenter> listField =new ArrayList<>();
         listField.add(fieldDataCenter);
        student.setFieldsListForChooseUnit(listField);
        student.setAddress("1345fccces");
        student.setAreaBorn("تبزیز");
        student.setFatherName("2");
        student.setLastName("hossein");
        studentController.setStudent(student);

        FXMLLoader loader = new FXMLLoader();
        Parent root;
        loader.setController(studentController);
//
//        loader.setController(newStudent);
        loader.setLocation(getClass().getResource("/sample/FXML/Student.fxml"));

        root = loader.load();

        //  primaryStage.setTitle("سیستم سما");

        primaryStage.setScene(new Scene(root, 1058, 600));
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
