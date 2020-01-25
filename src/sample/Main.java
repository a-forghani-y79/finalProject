package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Controllers.StudentController;
import sample.DataCenter.FieldDataCenter;
import sample.Controllers.MasterController;
import sample.DataCenter.FieldDataCenter;
import sample.DataCenter.MasterDataCenter;
import sample.DataCenter.NewStudentDataCenter;
import sample.DataCenter.StudentDataCenter;

import java.util.ArrayList;

import java.util.ArrayList;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
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
        ArrayList<FieldDataCenter> listField = new ArrayList<>();
        listField.add(fieldDataCenter);
        student.setFieldsList(listField);
        student.setAddress("1345fccces");
        student.setAreaBorn("تبزیز");
        student.setFatherName("2");
        student.setLastName("hossein");
        studentController.setStudent(student);
    }
//    public void start(Stage primaryStage) throws Exception {
//        MasterController master = new MasterController();
//        MasterDataCenter masterDataCenter = new MasterDataCenter();
//        FieldDataCenter fieldDataCenter = new FieldDataCenter();
//        masterDataCenter.setGender(1);
//        masterDataCenter.setLastName("aliPour");
//        masterDataCenter.setFirstName("ali");
//        fieldDataCenter.setMasterName(masterDataCenter.getFirstName() + " " + masterDataCenter.getLastName());
//        fieldDataCenter.setClassStartTime("21-32-4");
//        fieldDataCenter.setFieldName("math");
//        fieldDataCenter.setFieldNumber(12345l);
//        ArrayList<FieldDataCenter> fields = new ArrayList<>();
//        fields.add(fieldDataCenter);
//        masterDataCenter.setMasField(fields);
//        master.setMaster(masterDataCenter);
//        FXMLLoader loader = new FXMLLoader();
//
//        Parent root;
//        loader.setController(studentController);
////
////        loader.setController(newStudent);
//        loader.setLocation(getClass().getResource("/sample/FXML/Student.fxml"));
//        loader.setController(master);
//        loader.setLocation(getClass().getResource("/sample/FXML/Master.fxml"));
//
//        root = loader.load();
//
//        //  primaryStage.setTitle("سیستم سما");
//
//        primaryStage.setScene(new Scene(root, 1058, 600));
//        //primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.show();
//
//
//    }


    public static void main(String[] args) {
        launch(args);
    }
}
