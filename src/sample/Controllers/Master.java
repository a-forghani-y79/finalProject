package sample.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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

    public  void UnVisible()
    {

        insertGradeMaster.setVisible(false);

    }


    public void WeeklyTable(){
        MasterLessonsWeeklyRecord.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        LessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        LessonUnitMasterRecord.setCellValueFactory(new PropertyValueFactory<>("unit"));
        StudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        PassedStudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("passedStudentNumber"));
        weeklyTableView.getItems().add(new sample.DataCenter.person("math",1322,3,243,54));









    }


















    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WeeklyTable();
    }

    public void onMouseClick(MouseEvent mouseEvent) {
    }
}
