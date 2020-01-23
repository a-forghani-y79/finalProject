package sample.Controllers;


import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.DataCenter.person;

import java.net.URL;
import java.util.ResourceBundle;

public class Student implements Initializable {
    //table choose units
    public TableView tableViewChoose;
    public TableColumn rowChoose;
    public TableColumn lessonCodChoose;
    public TableColumn lessonChoose;
    public TableColumn unitChoose;
    public TableColumn masterChoose;
    public TableColumn classStartTimeChoose;
    public TableColumn timeToTakeTheExamChoose;
    public TableColumn ChooseUnit;
    //table Report
    public TableView taleViewReport;
    public TableColumn rowReport;
    public TableColumn lessonReport;
    public TableColumn unitReport;
    public TableColumn masterReport;
    public TableColumn scoreReport;
    public TableColumn situationReport;
    //table Curriculum
    public TableView tableViewCurriculum;
    public TableColumn rowCurriculum;
    public TableColumn lessonCurriculum;
    public TableColumn unitCurriculum;
    public TableColumn masterCurriculum;
    public TableColumn classStartTimeCurriculum;
    public TableColumn timeToTakeTheExamCurriculum;
    public TableColumn NumberOfََََAbsencesCurriculum;
    //table passed and not Passed
    public TableView tableViewPassed;
    public TableColumn rowPassed;
    public TableColumn lessonPassed;
    public TableColumn unitPassed;
    public TableColumn masterPassed;
    public TableColumn scorePassed;
    //Table Not Passed
    public TableView tableViewNotPassed;
    public TableColumn rowNotPassed;
    public TableColumn lessonNotPassed;
    public TableColumn unitNotPassed;
    //Profile
    public TextField txtCollegeProfile;
    public TextField txtLastNameProfile;
    public TextField txtIdProfile;
    public TextField txtNameProfile;
    public TextField txtPhoneNumberProfile;
    public TextField txtPlaceShenaseProfile;
    public TextField txtFatherNameProfile;
    public TextField txtAddressProfile;
    public TextField txtShenaseCodProfile;
    public TextField txtFatherPhoneNumberProfile;
    public TextField txtGradeProfile;
    public TextField txtFieldProfile;
    public TextField txtDateOfBirthProfile;
    public TextField txtIncomingSemesterProfile;
    public TextField txtProvinceOfBirthProfile;
    public TextField txtCityOfBirthProfile;
    public TextField txtTypeOfDiplomaProfile;
    public TextField txtDiplomaYearProfile;
    public TextField txtCourseProfile;
    public TextField txtNumbeOfDucProfile;
    public TextField txtConditionProfile;
    public TextField txtMaritalStatusProfile;
    public TextField txtPostalCodeProfile;
    public TextField txtEmailProfile;
    public TextField txtNationalCodProfile;
    public TextField txtNationalityProfile;
    public TextField txtReligionProfile;
    public TextField txtReligion2Profile;

    // sample.DataCenter.Student student;

    public void onActionSetProfile(){
        txtAddressProfile.setText("uhjnerxck");
    }
    public void onActionPassed() {
        rowPassed.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonPassed.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitPassed.setCellValueFactory(new PropertyValueFactory<>("unit"));
        masterPassed.setCellValueFactory(new PropertyValueFactory<>("master"));
        scorePassed.setCellValueFactory(new PropertyValueFactory<>("score"));
        tableViewPassed.getItems().add(new sample.DataCenter.person(1, "math", 3, "sahandi", 3.14));
        ///                                             (int row, String lesson, int unit, String master, double score)

    }

    public void onActionNotPassed() {
        rowNotPassed.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonNotPassed.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitNotPassed.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tableViewNotPassed.getItems().add(new person(1,"mabani",3));
//(int row, String lesson, int unit)
    }

    public void onActionCurriculum() {
         rowCurriculum.setCellValueFactory(new PropertyValueFactory<>("row"));
         lessonCurriculum.setCellValueFactory(new PropertyValueFactory<>("lesson"));
         unitCurriculum.setCellValueFactory(new PropertyValueFactory<>("unit"));
         masterCurriculum.setCellValueFactory(new PropertyValueFactory<>("master"));
         classStartTimeCurriculum.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
         timeToTakeTheExamCurriculum.setCellValueFactory(new PropertyValueFactory<>("timeToTakeExam"));
         NumberOfََََAbsencesCurriculum.setCellValueFactory(new PropertyValueFactory<>("numberOfAbsence"));
         tableViewCurriculum.getItems().add(new person(1,"mabani",2,"tanha","12/2/4","1/3/5",3));
         //(int row, String lesson, int unit, String master, String classStartTime, String timeToTakeExam, int numberOfAbsence)
    }

    public void onActionReport() {

         rowReport.setCellValueFactory(new PropertyValueFactory<>("row"));
         lessonReport.setCellValueFactory(new PropertyValueFactory<>("lesson"));
         unitReport.setCellValueFactory(new PropertyValueFactory<>("unit"));
         masterReport.setCellValueFactory(new PropertyValueFactory<>("master"));
         scoreReport.setCellValueFactory(new PropertyValueFactory<>("score"));
         situationReport.setCellValueFactory(new PropertyValueFactory<>("situation"));
         taleViewReport.getItems().add(new person(1,"farsi",3,"khtijeh",12.9,"درحال تحصیل"));
      //  (int row, String lesson, int unit, String master, double Score, String situation)
    }

    public void onActionChooseUnit() {


        JFXButton btn = new JFXButton("choose");
        btn.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("1234");
            }
        });
        rowChoose.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonChoose.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        lessonCodChoose.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        unitChoose.setCellValueFactory(new PropertyValueFactory<>("unit"));
        masterChoose.setCellValueFactory(new PropertyValueFactory<>("master"));
        classStartTimeChoose.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        timeToTakeTheExamChoose.setCellValueFactory(new PropertyValueFactory<>("timeToTakeExam"));
        ChooseUnit.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
        tableViewChoose.getItems().add(new sample.DataCenter.person(1, "math", 123456, "tanha", 3, "32,45,76", "8234869", btn));
//                                        (int row, String lesson, long lessonCode, String master, int unit, String classStartTime, String timeToTakeExam, Button btnChooseUnit)


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onActionChooseUnit();
        onActionPassed();
        onActionNotPassed();
        onActionCurriculum();
        onActionReport();
        onActionSetProfile();
    }
}
