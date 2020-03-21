package sample.Controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataCenter.ArchiveDataCenter;
import sample.DataCenter.FieldDataCenter;
import sample.DataCenter.StudentDataCenter;
import sample.DataCenter.TablesDataModel.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    //table choose units//
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
    //table Curriculum//
    public TableView tableViewCurriculum;
    public TableColumn rowCurriculum;
    public TableColumn lessonCurriculum;
    public TableColumn unitCurriculum;
    public TableColumn masterCurriculum;
    public TableColumn classStartTimeCurriculum;
    public TableColumn timeToTakeTheExamCurriculum;
    public TableColumn NumberOfََََAbsencesCurriculum;

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
    public JFXButton btnExit3;
    public Button btnConfirmChoose;
    public ImageView imageExit3;
    public JFXButton btnBack3;
    public ImageView imageBack3;
    public ImageView imageView;
    public ImageView imageBack2;
    public JFXButton btnBack2;
    public ImageView imageExit2;
    public JFXButton btnExit2;
    public ImageView imageBack1;
    public ImageView imageExit1;
    public JFXButton btnBack1;
    public JFXButton btnBack;
    private StudentDataCenter student;
    public ArchiveDataCenter archive;

    public void setStudent(StudentDataCenter student) {
        this.student = student;
    }


    public void setupCurriculum() {
        ArrayList<FieldDataCenter> list = new ArrayList<>();
        student.getGradeReport().forEach((lessonCode, grade) ->
                list.add(archive.readField(lessonCode))
        );
        if (!list.isEmpty()) {
            rowCurriculum.setCellValueFactory(new PropertyValueFactory<CurriculumStudent, String>("row"));
            lessonCurriculum.setCellValueFactory(new PropertyValueFactory<CurriculumStudent, String>("lessonName"));
            unitCurriculum.setCellValueFactory(new PropertyValueFactory<CurriculumStudent, String>("value"));
            masterCurriculum.setCellValueFactory(new PropertyValueFactory<CurriculumStudent, String>("masterName"));
            classStartTimeCurriculum.setCellValueFactory(new PropertyValueFactory<CurriculumStudent, String>("holdingTime"));
            timeToTakeTheExamCurriculum.setCellValueFactory(new PropertyValueFactory<CurriculumStudent, String>("examTime"));
            NumberOfََََAbsencesCurriculum.setCellValueFactory(new PropertyValueFactory<CurriculumStudent, String>("numberOfAbsence"));
            final ObservableList<CurriculumStudent> data = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++) {
                long lessonCode = list.get(i).getFieldNumber();
                int numberOfAbsence = student.getNumberOfAbsence(lessonCode);
                data.add(new CurriculumStudent((i + 1) + "", list.get(i).getFieldName(), list.get(i).getUnit() + "", list.get(i).getMasterName(),
                        list.get(i).getClassStartTime(), list.get(i).getTimeToTakeExam(), numberOfAbsence + ""));
            }
            tableViewCurriculum.setItems(data);
        }
    }

    public void setupReport() {
        HashMap<FieldDataCenter, Double> list = new HashMap<>();
        student.getGradeReport().forEach((aLong, aDouble) ->
                list.put(archive.readField(aLong), aDouble)
        );
        if (!list.isEmpty()) {

            rowReport.setCellValueFactory(new PropertyValueFactory<SimpleStringProperty, String>("row"));
            lessonReport.setCellValueFactory(new PropertyValueFactory<SimpleStringProperty, String>("lessonName"));
            unitReport.setCellValueFactory(new PropertyValueFactory<SimpleStringProperty, String>("value"));
            masterReport.setCellValueFactory(new PropertyValueFactory<SimpleStringProperty, String>("masterName"));
            scoreReport.setCellValueFactory(new PropertyValueFactory<SimpleStringProperty, String>("grade"));
            situationReport.setCellValueFactory(new PropertyValueFactory<SimpleStringProperty, String>("situation"));
            final ObservableList<ReportStudent> data = FXCollections.observableArrayList();
            list.forEach((fieldDataCenter, aDouble) -> {
                if (aDouble >= 10)
                    data.add(new ReportStudent((data.size() + 1) + "", fieldDataCenter.getFieldName(), fieldDataCenter.getUnit() + "", fieldDataCenter.getMasterName(), aDouble + "", "قبول"));
                else
                    data.add(new ReportStudent((data.size() + 1) + "", fieldDataCenter.getFieldName(), fieldDataCenter.getUnit() + "", fieldDataCenter.getMasterName(), aDouble + "", "رد"));
            });
            taleViewReport.setItems(data);

        }
    }

    public void setupAddField() {
        ArrayList<FieldDataCenter> presentedFields = new ArrayList<>();
        ArrayList<FieldDataCenter> allFields = archive.readAllFields();
        for (FieldDataCenter f :
                allFields) {
            if (f.isPresented())
                presentedFields.add(f);
        }
        if (!presentedFields.isEmpty()) {
            rowChoose.setCellValueFactory(new PropertyValueFactory<AddFieldStudent, String>("row"));
            lessonChoose.setCellValueFactory(new PropertyValueFactory<AddFieldStudent, String>("lessonName"));
            lessonCodChoose.setCellValueFactory(new PropertyValueFactory<AddFieldStudent, String>("lessonCode"));
            unitChoose.setCellValueFactory(new PropertyValueFactory<AddFieldStudent, String>("value"));
            masterChoose.setCellValueFactory(new PropertyValueFactory<AddFieldStudent, String>("masterName"));
            classStartTimeChoose.setCellValueFactory(new PropertyValueFactory<AddFieldStudent, String>("holdingTime"));
            timeToTakeTheExamChoose.setCellValueFactory(new PropertyValueFactory<AddFieldStudent, String>("examTime"));
            ChooseUnit.setCellValueFactory(new PropertyValueFactory<AddFieldStudent, JFXToggleButton>("add"));
            final ObservableList<AddFieldStudent> list = FXCollections.observableArrayList();
            for (int i = 0; i < presentedFields.size(); i++) {
                list.add(new AddFieldStudent((i + 1) + "", presentedFields.get(i).getFieldName(), presentedFields.get(i).getFieldNumber() + "",
                        presentedFields.get(i).getUnit() + "", presentedFields.get(i).getMasterName(), presentedFields.get(i).getClassStartTime(), presentedFields.get(i).getTimeToTakeExam()));
            }
            tableViewChoose.setItems(list);
        }
    }

    public void setupProfile() {
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
        txtDiplomaYearProfile.setText(student.getDiplomYear() + "");
    }

    public void setupDeletField() {
        ArrayList<FieldDataCenter> list = new ArrayList<>();
        student.getGradeReport().keySet().iterator().forEachRemaining(aLong -> list.add(archive.readField(aLong)));
        if (!list.isEmpty()) {
            rowAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<DeletFieldStudent, String>("row"));
            lessonCodeAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<DeletFieldStudent, String>("lessonCodee"));
            lessonAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<DeletFieldStudent, String>("lessonName"));
            unitNumberAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<DeletFieldStudent, String>("value"));
            masterAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<DeletFieldStudent, String>("masterName"));
            classStartTimeAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<DeletFieldStudent, String>("holdingTime"));
            timeToTakeTheExamAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<DeletFieldStudent, String>("examTime"));
            chooseUnitAddAndDeleteUnitChooseUnit.setCellValueFactory(new PropertyValueFactory<DeletFieldStudent, JFXToggleButton>("button"));

            final ObservableList<DeletFieldStudent> data = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++)
                data.add(new DeletFieldStudent((i + 1) + "", list.get(i).getFieldNumber() + "", list.get(i).getFieldName(),
                        list.get(i).getUnit() + "", list.get(i).getMasterName(), list.get(i).getClassStartTime(), list.get(i).getTimeToTakeExam()));
            tableViewAddAndDeleteUnitChooseUnit.setItems(data);
        }
    }

    public void confirmAddField() {
        int tableSize = tableViewChoose.getItems().size();
        long studentCode = student.getStudentNumber();
        if (tableSize > 0)
            for (int i = 0; i < tableSize; i++) {
                AddFieldStudent table = (AddFieldStudent) tableViewChoose.getItems().get(i);
                long lessonCode = Long.parseLong(table.getLessonCode());
                FieldDataCenter lesson = archive.readField(lessonCode);
                if (table.getAdd().isSelected()) {
                    student.join(lessonCode);
                    lesson.join(studentCode);
                    archive.writeFields(lesson);
                }
            }
        archive.writeStudent(student);
        updateTables();
    }

    public void confirmDeleteTable(MouseEvent mouseEvent) {
        int tableSize = tableViewAddAndDeleteUnitChooseUnit.getItems().size();
        for (int i = 0; i < tableSize; i++) {
            DeletFieldStudent table = (DeletFieldStudent) tableViewAddAndDeleteUnitChooseUnit.getItems().get(i);
            if (table.getButton().isSelected()) {
                long lessonCode = Long.parseLong(table.getLessonCode());
                long studentCode = student.getStudentNumber();
                FieldDataCenter lesson = archive.readField(lessonCode);
                student.left(lessonCode);
                lesson.left(studentCode);
                archive.writeFields(lesson);
            }
        }
        archive.writeStudent(student);
        updateTables();
    }

    private void updateTables() {
        setupProfile();
        setupAddField();
        setupCurriculum();
        setupReport();
        setupDeletField();
    }

    public void setImage() {
        Image img;
        img = new Image("./sample/PNG/Exit.png");
        imageExit1.setImage(img);
        imageExit2.setImage(img);
        imageExit3.setImage(img);
        img = new Image("./sample/PNG/Back.png");
        imageBack1.setImage(img);
        imageBack2.setImage(img);
        imageBack3.setImage(img);
    }

    @FXML
    private void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا می خواهید برگردید؟ ", ButtonType.YES, ButtonType.NO);


        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.YES) {
                Parent root;
                try {
                    Stage stage = (Stage) btnBack1.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/loginPage.fxml"));
                    root = loader.load();
                    stage = new Stage();
                    Stage finalStage = stage;
                    finalStage.setResizable(false);
                    finalStage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void exit() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا میخواهید خارج شوید؟ ", ButtonType.YES, ButtonType.NO);


        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.YES) {
                System.exit(0);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        archive = new ArchiveDataCenter();
        setImage();
        updateTables();


    }

}
