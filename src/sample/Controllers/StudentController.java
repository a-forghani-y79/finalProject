package sample.Controllers;


import com.jfoenix.controls.JFXToggleButton;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.DataCenter.ArchiveDataCenter;
import sample.DataCenter.FieldDataCenter;
import sample.DataCenter.StudentDataCenter;
import sample.DataCenter.personDataCenter;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
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


    //
    private StudentDataCenter student;

    public void setStudent(StudentDataCenter student) {
        this.student = student;
    }


    // sample.DataCenter.Student student;
    public ArchiveDataCenter archive;


    public void onActionPassed() {
        rowPassed.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonPassed.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitPassed.setCellValueFactory(new PropertyValueFactory<>("unit"));
        masterPassed.setCellValueFactory(new PropertyValueFactory<>("master"));
        scorePassed.setCellValueFactory(new PropertyValueFactory<>("score"));
        tableViewPassed.getItems().add(new personDataCenter(1, "math", 3, "sahandi", 3.14));
        ///                                             (int row, String lesson, int unit, String master, double score)

    }

    public void onActionNotPassed() {
        rowNotPassed.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonNotPassed.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitNotPassed.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tableViewNotPassed.getItems().add(new personDataCenter(1, "mabani", 3));
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
        tableViewCurriculum.getItems().add(new personDataCenter(1, "mabani", 2, "tanha", "12/2/4", "1/3/5", 3));
        //(int row, String lesson, int unit, String master, String classStartTime, String timeToTakeExam, int numberOfAbsence)
    }

    public void onActionReport() {

        rowReport.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonReport.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitReport.setCellValueFactory(new PropertyValueFactory<>("unit"));
        masterReport.setCellValueFactory(new PropertyValueFactory<>("master"));
        scoreReport.setCellValueFactory(new PropertyValueFactory<>("score"));
        situationReport.setCellValueFactory(new PropertyValueFactory<>("situation"));
        taleViewReport.getItems().add(new personDataCenter(1, "farsi", 3, "khtijeh", 12.9, "درحال تحصیل"));
        //  (int row, String lesson, int unit, String master, double Score, String situation)
    }

    public void onActionChooseUnit() {
        student = archive.readStudent(1234);
        FieldDataCenter[] field = student.getFields();

        JFXToggleButton btn = new JFXToggleButton();
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
        for (int i = 0; i < field.length; i++) {
            tableViewChoose.getItems().add(new personDataCenter(i + 1, field[i].getName(), field[i].getFieldNumber(), field[i].getMaster().getFirstName() + " " + field[i].getMaster().getLastName(), field[i].getUnit(), field[i].getClassStartTime(), field[i].getTimeToTakeExam(), btn));
//                                        (int row, String lesson, long lessonCode, String master, int unit, String classStartTime, String timeToTakeExam, Button btnChooseUnit)

        }
    }

    public void onActionSetProfile() {
        student = archive.readStudent(1234);
        txtCollegeProfile.setText(student.getFaculty());
        txtLastNameProfile.setText(student.getLastName());
        txtNameProfile.setText(student.getFirstName());
        txtPhoneNumberProfile.setText(String.valueOf(student.getPhoneNumber()));
        txtFatherNameProfile.setText(student.getFatherName());
        txtAddressProfile.setText(student.getAddress());
        txtFatherPhoneNumberProfile.setText(String.valueOf(student.getFatherPhoneNumber()));
        //   txtDateOfBirthProfile.setText(student.g());//UBorn
        txtProvinceOfBirthProfile.setText(student.getUBorn());//استان
        txtCityOfBirthProfile.setText(student.getCityBorn());
        txtTypeOfDiplomaProfile.setText(student.getDiplomType());
        // txtDiplomaYearProfile.setText(student.get);//چرا تاریح احذ دیپلم یوخدی
        txtCourseProfile.setText(student.getCourse());
        txtNumbeOfDucProfile.setText(String.valueOf(student.getFileNumber()));
        txtConditionProfile.setText(student.getCondition());
        ///  txtPostalCodeProfile.setText(student.get);
        txtEmailProfile.setText(student.getEmail());
        txtNationalityProfile.setText(student.getNationality());
        txtReligionProfile.setText(student.getReligion());//DIN
        txtIdProfile.setText(String.valueOf(student.getStudentNumber()));
//        public TextField txtPlaceShenaseProfile;
//        public TextField txtShenaseCodProfile;
//        public TextField txtGradeProfile;
//        public TextField txtFieldProfile;
//        public TextField txtDateOfBirthProfile;
//        public TextField txtIncomingSemesterProfile;

//        public TextField txtDiplomaYearProfile;
//        public TextField txtPostalCodeProfile;
//        public TextField txtNationalCodProfile;
//    public TextField txtMaritalStatusProfile;
//        public TextField txtReligion2Profile;//MAZHAB
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        archive = new ArchiveDataCenter(98, ArchiveDataCenter.STUDENT);
        student = new StudentDataCenter();
        onActionChooseUnit();
        onActionPassed();
        onActionNotPassed();
        onActionCurriculum();
        onActionReport();
        onActionSetProfile();
    }
}
