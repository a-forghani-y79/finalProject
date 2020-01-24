package sample.Controllers;

import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Master implements Initializable {

    public TableView insertGradeMaster;
    public TableColumn MasterLessonsWeeklyRecord;
    public TableColumn LessonCodeMaster;
    public TableColumn LessonUnitMasterRecord;
    public TableColumn StudentNumberMasterRecord;
    public TableColumn PassedStudentNumberMasterRecord;
    public TableView weeklyTable;
    public TableView weeklyTableView;

    public TableView AddTableMaster;
    public TableColumn addLessonMaster;
    public TableColumn addLessonCodeMaster;
    public TableColumn addUnitMaster;
    public TableColumn addPlaceMaster;
    public TableColumn addMaster;


    public TableView DeleteTableMaster;
    public TableColumn DeleteLessonMaster;
    public TableColumn DeleteLessonCodeMaster;
    public TableColumn DeleteUnitMaster;
    public TableColumn DeletePlaceMaster;
    public TableColumn DeleteMaster;



    public TableView newWeekMaster;
    public TableColumn rowNewWeekMaster;
    public TableColumn lessonNewWeekMaster;
    public TableColumn LessonCodeNewWeekMaster;
    public TableColumn UnitNewWeekTableMaster;
    public TableColumn numberStudentNewWeekMaster;
    public TableColumn startTimeNewWeekTableMaster;
    public TableColumn placeNewWeekMaster;

    sample.DataCenter.Master master;
    //
//    public Master(sample.DataCenter.Master master){
//        this.master = master;
//    }
    public void setMaster(sample.DataCenter.Master master) {
        this.master = master;
    }


    public  void UnVisible()
    {

        insertGradeMaster.setVisible(false);

    }


    public void History(){
        MasterLessonsWeeklyRecord.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        LessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        LessonUnitMasterRecord.setCellValueFactory(new PropertyValueFactory<>("unit"));
        StudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        PassedStudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("passedStudentNumber"));
        weeklyTableView.getItems().add(new sample.DataCenter.person("math",1322,3,243,54));

    }


    public void AddFields(){

        addLessonMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        addLessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        addUnitMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
        addPlaceMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        addMaster.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
        AddTableMaster.getItems().add(new sample.DataCenter.person("riazi",512,3,"do shanba",new JFXToggleButton()));




    }

    public void DeleteField(){

        DeleteLessonMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        DeleteLessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        DeleteUnitMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
        DeletePlaceMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        DeleteMaster.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
        DeleteTableMaster.getItems().add(new sample.DataCenter.person("sas",515,5,"seshanbe", new JFXToggleButton()));




    }

   public  void  newWeekMaster(){
       rowNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("row"));
       lessonNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
       LessonCodeNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
       UnitNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
       numberStudentNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
       startTimeNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
       placeNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("classPlace"));
       newWeekMaster.getItems().add(new sample.DataCenter.person(1,"sada",5542424,4, 45,"pang","dgbd"));


   }















    @Override
    public void initialize(URL location, ResourceBundle resources) {
        History();
        AddFields();
        DeleteField();
        newWeekMaster();

    }


}
