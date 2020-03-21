package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataCenter.*;
import sample.DataCenter.TablesDataModel.AbsenceListMaster;
import sample.DataCenter.TablesDataModel.AddFieldMaster;
import sample.DataCenter.TablesDataModel.InsertGradeMaster;
import sample.DataCenter.TablesDataModel.WeeklyScheduleMaster;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

public class MasterController implements Initializable {

    public TableView tableAddField;
    public TableColumn addLessonMaster;
    public TableColumn addLessonCodeMaster;
    public TableColumn addUnitMaster;
    public TableColumn addPlaceMaster;
    public TableColumn addMaster;

    public TableView newWeekMaster;
    public TableColumn rowNewWeekMaster;
    public TableColumn lessonNewWeekMaster;
    public TableColumn LessonCodeNewWeekMaster;
    public TableColumn UnitNewWeekTableMaster;
    public TableColumn numberStudentNewWeekMaster;
    public TableColumn startTimeNewWeekTableMaster;

    public TableView insertGradeMaster;
    public TableColumn rowInsertGrade;
    public TableColumn lastNameInsetGrade;
    public TableColumn FirstNameInssertGrade;
    public TableColumn IdInsertGrade;
    public TableColumn genderInsertGrade;
    public TableColumn insertGradeMasterCLM;

    public TableView TableViewPrAbMaster;
    public TableColumn LastNamePrAbMaster;
    public TableColumn FirstNamePrAbMaster;
    public TableColumn RadifPrAbMaster;
    public TableColumn IDPrAbMaster;
    public TableColumn AbsentPrAbMaster;

    private long currentLesson;

    public TextField txtNameMaster;
    public TextField txtFamilyMaster;
    public TextField txtPersonalCodeMaster;
    public TextField txtNationalCodeMater;
    public ImageView MasterFaceImage;
    public ArchiveDataCenter archive;
    public ComboBox combolessonMaster;
    public JFXButton backButtonMaster1;
    public ComboBox comboLessonMaster2;
    public JFXButton finalConfirmAdd;
    public Label lblAlert;
    public Tab newWeektableMaster;
    private MasterDataCenter master;
    private StudentDataCenter student;
    private ArrayList<StudentDataCenter> findStudent;
    private ArrayList<FieldDataCenter> listStd;
    private ArrayList<Double> passedNumber;
    private long lessonCode;
    private long lessonCodePrAb;
    private ArrayList<String> comboItem = new ArrayList<>();
    ArrayList<FieldDataCenter> fields = new ArrayList<>();
    private int numberOfPassedStudent = 0;

    public MenuButton personalInfoMenu;
    public MenuItem personalInfoMenuItem;
    public MenuItem historyMenuItem;
    //
    public MenuButton weeklyMenu;
    public MenuItem weeklyMenuItem;
    public MenuItem ChoseUnitMenuItem;
    //
    public MenuButton studentsMenu;
    public MenuItem insertGradeMenuItem;
    public MenuItem presentAbsentMenuItem;
    //
    public AnchorPane mainAnchorPane;

    public void setMaster(MasterDataCenter master) {
        this.master = master;
    }

    public void UnVisible() {
        insertGradeMaster.setVisible(false);
    }

    public void fillWeeklyProgramTable() {
        rowNewWeekMaster.setCellValueFactory(new PropertyValueFactory<WeeklyScheduleMaster, String>("row"));
        lessonNewWeekMaster.setCellValueFactory(new PropertyValueFactory<WeeklyScheduleMaster, String>("lessonName"));
        LessonCodeNewWeekMaster.setCellValueFactory(new PropertyValueFactory<WeeklyScheduleMaster, String>("lissonCode"));
        UnitNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<WeeklyScheduleMaster, String>("value"));
        numberStudentNewWeekMaster.setCellValueFactory(new PropertyValueFactory<WeeklyScheduleMaster, String>("numberOfSyudemtd"));
        startTimeNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<WeeklyScheduleMaster, String>("holdingTime"));
        ArrayList<FieldDataCenter> list = master.getMasField();
        if (!list.isEmpty()) {
            final ObservableList<WeeklyScheduleMaster> data = FXCollections.observableArrayList();
            for (int i = 0; i < list.size(); i++)
                data.add(new WeeklyScheduleMaster("" + (i + 1), list.get(i).getFieldName(), "" + list.get(i).getUnit(), "" + list.get(i).getFieldNumber(), "" + 45, list.get(i).getClassStartTime()));
            newWeekMaster.setItems(data);
        }
    }

    public void fillAddFieldsTable() {
        addLessonMaster.setCellValueFactory(new PropertyValueFactory<AddFieldMaster, String>("lessonName"));
        addLessonCodeMaster.setCellValueFactory(new PropertyValueFactory<AddFieldMaster, String>("lessonCode"));
        addUnitMaster.setCellValueFactory(new PropertyValueFactory<AddFieldMaster, String>("value"));
        addPlaceMaster.setCellValueFactory(new PropertyValueFactory<AddFieldMaster, String>("holdingTime"));
        addMaster.setCellValueFactory(new PropertyValueFactory<AddFieldMaster, JFXToggleButton>("add"));
        ArrayList<FieldDataCenter> list = archive.readAllFields();
        final ObservableList<AddFieldMaster> data = FXCollections.observableArrayList();
        if (!list.isEmpty())
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).isPresented())
                    data.add(new AddFieldMaster(list.get(i).getFieldName(), list.get(i).getFieldNumber() + "", list.get(i).getUnit() + "", list.get(i).getClassStartTime(), new JFXToggleButton()));
            }
        tableAddField.setItems(data);
    }

    public void fillGradesTable(long lessonCode) {
        insertGradeMaster.getItems().clear();
        FieldDataCenter lesson = archive.readField(lessonCode);
        if (lesson != null) {
            ArrayList<Long> studentsCode = archive.readField(lessonCode).getStudentsList();
            ArrayList<StudentDataCenter> students = new ArrayList<>();
            for (Long l :
                    studentsCode) {
                students.add(archive.readStudent(l));
            }
            rowInsertGrade.setCellValueFactory(new PropertyValueFactory<InsertGradeMaster, String>("row"));
            lastNameInsetGrade.setCellValueFactory(new PropertyValueFactory<InsertGradeMaster, String>("lastName"));
            FirstNameInssertGrade.setCellValueFactory(new PropertyValueFactory<InsertGradeMaster, String>("firstName"));
            IdInsertGrade.setCellValueFactory(new PropertyValueFactory<InsertGradeMaster, String>("studentNumber"));
            genderInsertGrade.setCellValueFactory(new PropertyValueFactory<InsertGradeMaster, String>("gender"));
            insertGradeMasterCLM.setCellValueFactory(new PropertyValueFactory<InsertGradeMaster, JFXTextField>("insertGrade"));
            final ObservableList<InsertGradeMaster> list = FXCollections.observableArrayList();
            for (int i = 0; i < students.size(); i++)
                list.add(new InsertGradeMaster((i + 1) + "", students.get(i).getLastName(), students.get(i).getFirstName(),
                        students.get(i).getStudentNumber() + "", students.get(i).getGender() != 0 ? "خانم" : "آقا",
                        students.get(i).getGrade(currentLesson) + ""));
            insertGradeMaster.setItems(list);

        }
    }

    public void fillAbsencesTable(long lessonCode) {
        TableViewPrAbMaster.getItems().clear();
        ArrayList<StudentDataCenter> stdList = new ArrayList<>();
        ArrayList<Long> stdCodesList = archive.readField(lessonCode).getStudentsList();
        for (Long l :
                stdCodesList) {
            stdList.add(archive.readStudent(l));
        }
        if (!stdList.isEmpty()) {
            System.out.println("list is not empty");
            RadifPrAbMaster.setCellValueFactory(new PropertyValueFactory<AbsenceListMaster, String>("row"));
            LastNamePrAbMaster.setCellValueFactory(new PropertyValueFactory<AbsenceListMaster, String>("lastName"));
            FirstNamePrAbMaster.setCellValueFactory(new PropertyValueFactory<AbsenceListMaster, String>("firstName"));
            IDPrAbMaster.setCellValueFactory(new PropertyValueFactory<AbsenceListMaster, String>("studentCode"));
            AbsentPrAbMaster.setCellValueFactory(new PropertyValueFactory<AbsenceListMaster, JFXTextField>("numberOfAbsence"));
            final ObservableList<AbsenceListMaster> list = FXCollections.observableArrayList();
            for (int i = 0; i < stdList.size(); i++)
                list.add(new AbsenceListMaster((i + 1) + "", stdList.get(i).getLastName(),
                        stdList.get(i).getFirstName(), stdList.get(i).getStudentNumber()+"",
                        stdList.get(i).getNumberOfAbsence(lessonCode) + ""));

            TableViewPrAbMaster.setItems(list);
        }
    }


    public void setName() {
        txtNameMaster.setText(master.getFirstName());
        txtFamilyMaster.setText(master.getLastName());
        txtNationalCodeMater.setText(master.getNationalNumber() + "");
        txtPersonalCodeMaster.setText(master.getPersonalNumber() + "");
    }

    public void setImage() {
        Image imageFM = new Image("./sample/PNG/master.png");
        Image imageM = new Image("./sample/PNG/MasIcon.png");
        if (master.getGender() == 0)
            MasterFaceImage.setImage(imageFM);
        if (master.getGender() == 1)
            MasterFaceImage.setImage(imageM);
    }

    public void exit() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا میخواهید خارج شوید؟ ", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent())
            if (result.get() == ButtonType.YES)
                System.exit(0);
    }

    public void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا می خواهید به صفحه اصلی برگردید؟ ", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.YES) {
                Parent root;
                try {
                    Stage stage = (Stage) backButtonMaster1.getScene().getWindow();
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

    public void choseFieldForInsertingGrade() {
        int ind = combolessonMaster.getSelectionModel().getSelectedIndex();
        if (ind > -1) {
            long lessonCode = master.getMasField().get(ind).getFieldNumber();
            currentLesson = lessonCode;
            fillGradesTable(lessonCode);
        }
    }

    public void choseFieldForInsertingAbsenceNumber() {
        int ind = comboLessonMaster2.getSelectionModel().getSelectedIndex();
        if (ind > -1) {
            long lessonCode = master.getMasField().get(ind).getFieldNumber();
            currentLesson = lessonCode;
            fillAbsencesTable(lessonCode);
        }
    }

    public void ConfirmAddingFieldMaster() {

        int tableSize = tableAddField.getItems().size();
        ArrayList<FieldDataCenter> allFields = archive.readAllFields();
        ArrayList<FieldDataCenter> list = master.getMasField();
        if (list == null)
            list = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {

            AddFieldMaster addFieldMaster = (AddFieldMaster) tableAddField.getItems().get(i);
            if (addFieldMaster.getAdd().isSelected()) {
                System.out.println(addFieldMaster.getLessonName() + " is selected");
                findLesson:
                for (int j = 0; j < allFields.size(); j++) {
                    if (addFieldMaster.getLessonCode().equals(allFields.get(j).getFieldNumber() + "")) {
                        System.out.println("founded");
                        allFields.get(j).setPresented(true);
                        allFields.get(j).setMasterName(master.getFirstName() + " " + master.getLastName());
                        list.add(allFields.get(j));
                        tableAddField.getItems().remove(i);
                        break findLesson;
                    }
                }
            }
        }
        master.setMasField(list);
        archive.writeMaster(master);
        archive.updateAllFields(list);
        fillWeeklyProgramTable();
    }

    public void confirmInsertedGrades() throws Exception {
        int tableSize = insertGradeMaster.getItems().size();
        for (int i = 0; i < tableSize; i++) {
            InsertGradeMaster table = (InsertGradeMaster) insertGradeMaster.getItems().get(i);
            Long lessonCode = currentLesson;
            long studentCode = Long.parseLong(table.getStudentNumber());
            Double grade = table.getGrade();
            StudentDataCenter student = archive.readStudent(studentCode);
//            student.setGrade(lessonCode, grade);




            student.setGrade(lessonCode,grade);
            archive.writeStudent(student);
        }

    }

    public void confirmInsertAbsenceNumber() {
        int tableSize = TableViewPrAbMaster.getItems().size();
        for (int i = 0; i < tableSize; i++) {
            AbsenceListMaster table = (AbsenceListMaster) TableViewPrAbMaster.getItems().get(i);
            long studentCode = Long.parseLong(table.getStudentCode());
            long lessonCode = currentLesson;
            int numberOfAbsence = table.getAbsence();
            StudentDataCenter student = archive.readStudent(studentCode);
            student.setAbsence(lessonCode, numberOfAbsence);
            archive.writeStudent(student);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        archive = new ArchiveDataCenter();
        findStudent = new ArrayList<>();
        listStd = new ArrayList<>();
        passedNumber = new ArrayList<>();
        fillWeeklyProgramTable();
        if (!master.getMasField().isEmpty())
        for (int i = 0; i < master.getMasField().size(); i++) {
            comboItem.add(master.getMasField().get(i).getFieldName() + " " + master.getMasField().get(i).getFieldNumber());
        }
        combolessonMaster.getItems().add(comboItem);
        comboLessonMaster2.getItems().add(comboItem);


// setting the name of Master
        setName();
//setting the image of Master
        setImage();
// showing presented Lessons for choosing them(chose unit)
        fillAddFieldsTable();


    }
}
