package sample.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Master implements Initializable {

    public TableView insertGradeMaster;
    public TableView weeklyTable;
    public TableColumn MasterLessonsWeeklyRecord;
    public TableColumn LessonCodeMaster;
    public TableColumn LessonUnitMasterRecord;
    public TableColumn StudentNumberMasterRecord;
    public TableColumn PassedStudentNumberMasterRecord;

    public  void UnVisible()
    {

        insertGradeMaster.setVisible(false);

    }



















    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onMouseClick(MouseEvent mouseEvent) {
    }
}
