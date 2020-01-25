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
import java.util.ArrayList;
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
    //delete and add lesson from choose unit section
    public TableColumn rowAddAndDeleteUnitChooseUnit;
    public TableColumn lessonCodeAddAndDeleteUnitChooseUnit;
    public TableColumn lessonAddAndDeleteUnitChooseUnit;
    public TableColumn unitNumberAddAndDeleteUnitChooseUnit;
    public TableColumn chooseUnitAddAndDeleteUnitChooseUnit;
    public TableColumn masterAddAndDeleteUnitChooseUnit;
    public TableColumn classStartTimeAddAndDeleteUnitChooseUnit;
    public TableColumn timeToTakeTheExamAddAndDeleteUnitChooseUnit;
    public TableView tableViewAddAndDeleteUnitChooseUnit;
    private StudentDataCenter student;
    public ArchiveDataCenter archive;

    public void setStudent(StudentDataCenter student) {
        this.student = student;
    }


    //passed lessons
    public void onActionPassed() {
        ArrayList<FieldDataCenter> fieldsList = student.getFieldsList();
        rowPassed.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonPassed.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitPassed.setCellValueFactory(new PropertyValueFactory<>("unit"));
        masterPassed.setCellValueFactory(new PropertyValueFactory<>("master"));
        scorePassed.setCellValueFactory(new PropertyValueFactory<>("score"));
        for (int i = 0; i < fieldsList.size(); i++) {
            if (fieldsList.get(i).getScore() >= 10)
                tableViewPassed.getItems().add(new personDataCenter(i + 1, fieldsList.get(i).getFieldName(), fieldsList.get(i).getUnit(), fieldsList.get(i).getMasterName(), fieldsList.get(i).getScore()));
            ///                                             (int row, String lesson, int unit, String master, double score)
        }
    }

    //TODO
    public void onActionNotPassed() {
        rowNotPassed.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonNotPassed.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitNotPassed.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tableViewNotPassed.getItems().add(new personDataCenter(1, "mabani", 3));
//(int row, String lesson, int unit)
    }

    public void onActionCurriculum() {
        ArrayList<FieldDataCenter> fieldsList = student.getFieldsList();

        rowCurriculum.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonCurriculum.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitCurriculum.setCellValueFactory(new PropertyValueFactory<>("unit"));
        masterCurriculum.setCellValueFactory(new PropertyValueFactory<>("master"));
        classStartTimeCurriculum.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        timeToTakeTheExamCurriculum.setCellValueFactory(new PropertyValueFactory<>("timeToTakeExam"));
        NumberOfََََAbsencesCurriculum.setCellValueFactory(new PropertyValueFactory<>("numberOfAbsence"));
        for (int i = 0; i < fieldsList.size(); i++) {
            tableViewCurriculum.getItems().add(new personDataCenter(i + 1, fieldsList.get(i).getFieldName(), fieldsList.get(i).getUnit(), fieldsList.get(i).getMasterName(), fieldsList.get(i).getClassStartTime(), fieldsList.get(i).getTimeToTakeExam(), fieldsList.get(i).getNumberOfAbsence()));
            //(int row, String lesson, int unit, String master, String classStartTime, String timeToTakeExam, int numberOfAbsence)
        }
    }

    // report for student
    public void onActionReport() {

        ArrayList<FieldDataCenter> fieldsList = student.getFieldsList();
        rowReport.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonReport.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitReport.setCellValueFactory(new PropertyValueFactory<>("unit"));
        masterReport.setCellValueFactory(new PropertyValueFactory<>("master"));
        scoreReport.setCellValueFactory(new PropertyValueFactory<>("score"));
        situationReport.setCellValueFactory(new PropertyValueFactory<>("situation"));
        for (int i = 0; i < fieldsList.size(); i++) {
            taleViewReport.getItems().add(new personDataCenter(i + 1, fieldsList.get(i).getFieldName(), fieldsList.get(i).getUnit(), fieldsList.get(i).getMasterName(), fieldsList.get(i).getScore(), student.getPosition()));
            //                                                  (int row, String lesson, int unit, String master, double Score, String situation)
        }
    }

    public void onActionDeleteAndAddLesson() {
        JFXToggleButton btn = new JFXToggleButton();

        rowAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonCodeAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        lessonAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        unitNumberAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        chooseUnitAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
        masterAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<>("master"));
        classStartTimeAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        timeToTakeTheExamAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<>("timeToTakeExam"));
        tableViewAddAndDeleteUnitChooseUnit.getItems().add(new personDataCenter(1, "math", 1234l, "tanha", 3, "12-12-12", "21-32-34", btn));
        //                                        (int row, String lesson, long lessonCode, String master, int unit, String classStartTime, String timeToTakeExam, Button btnChooseUnit)

    }

    public void onActionChooseUnit() {
        ArrayList<FieldDataCenter> field = student.getFieldsList();

        JFXToggleButton btn = new JFXToggleButton();

        rowChoose.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonChoose.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        lessonCodChoose.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        unitChoose.setCellValueFactory(new PropertyValueFactory<>("unit"));
        masterChoose.setCellValueFactory(new PropertyValueFactory<>("master"));
        classStartTimeChoose.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        timeToTakeTheExamChoose.setCellValueFactory(new PropertyValueFactory<>("timeToTakeExam"));
        ChooseUnit.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
        for (int i = 0; i < field.size(); i++) {
          //  tableViewChoose.getItems().add(new personDataCenter(i + 1, field.get(i).getFieldName(), field.get(i).getFieldNumber(), field.get(i).getMasterName(), field.get(i).getUnit(), field.get(i).getClassStartTime(), field.get(i).getTimeToTakeExam(), btn));
//                                        (int row, String lesson, long lessonCode, String master, int unit, String classStartTime, String timeToTakeExam, Button btnChooseUnit)

        }
    }

    public void onActionSetProfile() {

        txtCollegeProfile.setText(student.getFaculty());
        txtLastNameProfile.setText(student.getLastName());
        txtNameProfile.setText(student.getFirstName());
        txtPhoneNumberProfile.setText(String.valueOf(student.getPhoneNumber()));
        txtFatherNameProfile.setText(student.getFatherName());
        txtAddressProfile.setText(student.getAddress());
        txtFatherPhoneNumberProfile.setText(String.valueOf(student.getFatherPhoneNumber()));
        txtDateOfBirthProfile.setText(student.getBYear() + "-" + student.getBMonth() + "-" + student.getBDay());
        txtProvinceOfBirthProfile.setText(student.getUBorn());
        txtCityOfBirthProfile.setText(student.getCityBorn());
        txtTypeOfDiplomaProfile.setText(student.getDiplomType());
        txtCourseProfile.setText(student.getCourse());
        txtNumbeOfDucProfile.setText(String.valueOf(student.getFileNumber()));
        txtConditionProfile.setText(student.getCondition());
        txtPostalCodeProfile.setText(student.getZIPCode() + "");
        txtEmailProfile.setText(student.getEmail());
        txtNationalityProfile.setText(student.getNationality());
        txtReligionProfile.setText(student.getFaith());
        txtIdProfile.setText(String.valueOf(student.getStudentNumber()));
        txtPlaceShenaseProfile.setText(student.getLocalBorn());
        txtShenaseCodProfile.setText(student.getIDCardNumber() + "");
        txtGradeProfile.setText(student.getSectionEducation());
        txtFieldProfile.setText(student.getField());
        txtIncomingSemesterProfile.setText(student.getStartSeason());
        txtNationalCodProfile.setText(student.getNationalCode() + "");
        txtMaritalStatusProfile.setText(student.getMatrimony());
        txtReligion2Profile.setText(student.getReligion());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        archive = new ArchiveDataCenter(98, ArchiveDataCenter.STUDENT);
        student = new StudentDataCenter();
        student = archive.readStudent(student.getStudentNumber());

        onActionChooseUnit();
        onActionPassed();
        onActionNotPassed();
        onActionCurriculum();
        onActionReport();
        onActionSetProfile();
    }

    //Choose Unit
    public void onMouseCliked(MouseEvent mouseEvent) {
        int sizeOfTable = tableViewChoose.getItems().size();
        ArrayList<personDataCenter> personDataCenters = new ArrayList<>();
        for (int i = 0; i < sizeOfTable; i++) {
            personDataCenter personDataCenter = (personDataCenter) tableViewChoose.getItems().get(i);
            JFXToggleButton jfxToggleButton = personDataCenter.getTogglebtnChooseUnit();
            jfxToggleButton.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (jfxToggleButton.isSelected()) {
                        personDataCenters.add(personDataCenter);
                    }
                }
            });

        }
        long[] lessonCods = new long[personDataCenters.size()];

        for (int i = 0; i < personDataCenters.size(); i++) {
            lessonCods[i] = personDataCenters.get(i).getLessonCod();
        }

        ArchiveDataCenter archiveDataCenter = new ArchiveDataCenter(98, ArchiveDataCenter.FIELD);
        ArrayList<FieldDataCenter> fields = new ArrayList<FieldDataCenter>() {
        };
        fields.addAll(archiveDataCenter.readAllFields());
        for (int i = 0; i < fields.size(); i++) {
            for (int j = 0; j < lessonCods.length; j++) {
                if (lessonCods[j] == fields.get(i).getFieldNumber()) {
              //      fields.get(i).setScore(10);
                    student.addField(fields.get(i));
                }
            }
        }
        ArchiveDataCenter archiveDataCenter1 = new ArchiveDataCenter(98, ArchiveDataCenter.STUDENT);
        archiveDataCenter1.writeStudent(student);
    }

    public void averageUpdate(ArrayList<FieldDataCenter> fields) {
        double average = 0;
        int sumUnit = 0;
        double sumScore = 0;
        for (int i = 0; i < fields.size(); i++) {
            sumUnit += fields.get(i).getUnit();
            sumScore += (fields.get(i).getScore() * fields.get(i).getUnit());
        }
        average = sumScore / sumUnit;
        student.setAverage(average);
    }


    public void deleteAndAddLesson(MouseEvent mouseEvent) {

    }
}
