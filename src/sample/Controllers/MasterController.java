package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.EventHandler;
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
import sample.DataCenter.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class MasterController implements Initializable {

    public TableView weeklyTableView;
    public TableColumn MasterLessonsWeeklyRecord;
    public TableColumn LessonCodeMaster;
    public TableColumn LessonUnitMasterRecord;
    public TableColumn StudentNumberMasterRecord;
    public TableColumn PassedStudentNumberMasterRecord;


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
    public JFXButton showDeleteTable;
    public TextField txtNameMaster;
    public TextField txtFamilyMaster;
    public TextField txtPersonalCodeMaster;
    public TextField txtNationalCodeMater;

    public ImageView MasterFaceImage;


    public TableView insertGradeMaster;
    public TableColumn rowInsertGrade;
    public TableColumn lastNameInsetGrade;
    public TableColumn FirstNameInssertGrade;
    public TableColumn IdInsertGrade;
    public TableColumn genderInsertGrade;
    public TableColumn lessonCodeInsertGrade;
    public TableColumn insertGradeMasterCLM;
    public TableView TableViewPrAbMaster;
    public TableColumn LastNamePrAbMaster;
    public TableColumn FirstNamePrAbMaster;
    public TableColumn RadifPrAbMaster;
    public TableColumn IDPrAbMaster;
    public TableColumn AbsentPrAbMaster;
    public ArchiveDataCenter archive;
    public ComboBox combolessonMaster;
    public JFXButton exitButtonMaster1;
    public JFXButton backButtonMaster1;
    public JFXButton exitButtonMaster2;
    public JFXButton backButtonMaster2;
    public JFXButton exitButtonMaster3;
    public JFXButton backButtonMaster3;
    public JFXButton exitButtonMaster4;
    public JFXButton backButtonMaster4;
    public JFXButton choseLesson1;
    public JFXButton exitButtonMaster5;
    public JFXButton backButtonMaster5;
    public JFXButton exitButtonMaster6;
    public JFXButton backBittonMaster6;
    public ComboBox comboLessonMaster2;
    public JFXButton choseLesson2;
    public JFXButton finalConfirmAdd;
    public JFXButton finalConfirmDelete;
    public JFXButton btnCompleteInfoMaster;
    public Tab newWeektableMaster;
    public ImageView btnsearchforGrade;
    public JFXButton btnConfirmGrade;
    public ImageView btnSearchPrAb;
    private MasterDataCenter master;
    private StudentDataCenter student;
    private ArrayList<StudentDataCenter> findStudent;
    private ArrayList<FieldDataCenter> MField;
    private ArrayList<FieldDataCenter> masField;
    private ArrayList<personDataCenter> masterChoseUnit;
    private ArrayList<FieldDataCenter> listStd;
    private ArrayList<Double> passedNumber;
    private boolean flag;
    private long lessonCode;

    public void setMaster(MasterDataCenter master) {
        this.master = master;
    }

    public void UnVisible() {
        insertGradeMaster.setVisible(false);
    }


    public void WeeklyTable() {
        MasterLessonsWeeklyRecord.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        LessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        LessonUnitMasterRecord.setCellValueFactory(new PropertyValueFactory<>("unit"));
        StudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        PassedStudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("passedStudentNumber"));
        for (int i = 0; i <masterChoseUnit.size() ; i++) {
            weeklyTableView.getItems().add(new personDataCenter(masterChoseUnit.get(i).getLesson(), masterChoseUnit.get(i).getLessonCod(), masterChoseUnit.get(i).getUnit(),numberOfStudent(masField.get(i).getFieldNumber()) , 0));

        }


    }
    //Takmil
    public void AddFields() {
        ArrayList<FieldDataCenter> fieldMaster = master.getMasField();
        addLessonMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        addLessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        addUnitMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
        addPlaceMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        addMaster.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
        for (int i = 0; i < fieldMaster.size(); i++) {
            AddTableMaster.getItems().add(new personDataCenter(fieldMaster.get(i).getFieldName(), fieldMaster.get(i).getFieldNumber(), fieldMaster.get(i).getUnit(), fieldMaster.get(i).getClassStartTime(), new JFXToggleButton()));

        }
    }

//    public void DeleteField() {
//        DeleteLessonMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
//        DeleteLessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
//        DeleteUnitMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
//        DeletePlaceMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
//        DeleteMaster.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
//        DeleteTableMaster.getItems().add(new personDataCenter("sas", 515, 5, "seshanbe", new JFXToggleButton()));
//    }

    public void newWeekMaster() {
        rowNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("row"));
        lessonNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        LessonCodeNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        UnitNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
        numberStudentNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        startTimeNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        placeNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("classPlace"));
        for (int i = 0; i < masterChoseUnit.size(); i++) {
            newWeekMaster.getItems().add(new sample.DataCenter.personDataCenter(i + 1, masterChoseUnit.get(i).getLesson(), masterChoseUnit.get(i).getLessonCod(), masterChoseUnit.get(i).getUnit(), 45, masterChoseUnit.get(i).getClassStartTime(), masterChoseUnit.get(i).getClassPlace()));
        }
    }

    public void insertGrade() {
        rowInsertGrade.setCellValueFactory(new PropertyValueFactory<>("row"));
        lastNameInsetGrade.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        FirstNameInssertGrade.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        IdInsertGrade.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        genderInsertGrade.setCellValueFactory(new PropertyValueFactory<>("gender"));
        insertGradeMasterCLM.setCellValueFactory(new PropertyValueFactory<>("txtInsert"));
        for (int i = 0; i < findStudent.size(); i++) {
            insertGradeMaster.getItems().add(new sample.DataCenter.personDataCenter(i + 1, findStudent.get(i).getLastName(), findStudent.get(i).getFirstName(), findStudent.get(i).getStudentNumber(), findStudent.get(i).getGender(), new TextField()));
        }
    }

    public void tablePrAb() {
        RadifPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("row"));
        LastNamePrAbMaster.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        FirstNamePrAbMaster.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        IDPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        AbsentPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("numberOfAbsence"));
        for (int i = 0; i < findStudent.size(); i++) {
            TableViewPrAbMaster.getItems().add(new sample.DataCenter.personDataCenter(i + 1, findStudent.get(i).getLastName(), findStudent.get(i).getFirstName(), findStudent.get(i).getStudentNumber(), new TextField()));
        }
    }


    public void showDeleteTable() {
        DeleteTableMaster.setVisible(true);
    }

    public void setName() {
        txtNameMaster.setText(master.getFirstName());
        txtFamilyMaster.setText(master.getLastName());
        txtNationalCodeMater.setText(master.getNationalNumber() + "");
        txtPersonalCodeMaster.setText(master.getPersonalNumber() + "");
    }

    public void setImage() {
        Image imageFM = new Image("./sample/PNG/MasterFM.png");
        Image imageM = new Image("./sample/PNG/MasIcon.png");
        if (master.getGender() == 0)
            MasterFaceImage.setImage(imageFM);
        if (master.getGender() == 1)
            MasterFaceImage.setImage(imageM);
    }


    public void choseField() {
        int ind = combolessonMaster.getSelectionModel().getSelectedIndex();
        if(ind>0) {
            lessonCode = MField.get(ind).getFieldNumber();
            findStudent.addAll(findList(lessonCode));
            insertGrade();
        }
    }

    public ArrayList<StudentDataCenter> findList(long lessonCode) {
        ArrayList<StudentDataCenter> students = new ArrayList<StudentDataCenter>();
        ArrayList<StudentDataCenter> findStudents = new ArrayList<StudentDataCenter>();
        ArchiveDataCenter archiveDataCenter = new ArchiveDataCenter();
        students.addAll(archiveDataCenter.readAllStudents());
        for (int i = 0; i < students.size(); i++) {
            ArrayList<FieldDataCenter> Field = students.get(i).getFieldsListForChooseUnit();
            for (int j = 0; j < Field.size(); j++) {
                if (Field.get(j).getFieldNumber() == lessonCode) {
                    findStudents.add(students.get(i));
                    break;
                }
            }
        }
        return findStudents;
    }

    public void exit() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure " + "?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent())
            if (result.get() == ButtonType.YES)
                System.exit(0);
    }

    public void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure " + "?", ButtonType.YES, ButtonType.NO);
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
//chose unit
    public void finalConfirm() {
        int tableSize = AddTableMaster.getItems().size();
        ArrayList<personDataCenter> personDataCenters = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            personDataCenter person = (personDataCenter) AddTableMaster.getItems().get(i);
            JFXToggleButton jfxToggleButton = person.getTogglebtnChooseUnit();
            jfxToggleButton.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (jfxToggleButton.isSelected()) {
                        personDataCenters.add(person);
                    }
                }
            });
        }
        for (int i = 0; i < personDataCenters.size(); i++) {
            masterChoseUnit.add(personDataCenters.get(i));
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        archive = new ArchiveDataCenter();


        MField = master.getMasField();
        for (int i = 0; i < MField.size(); i++) {
            String comboItem = MField.get(i).getFieldName();
            combolessonMaster.getItems().add(comboItem);
        }
        finalConfirm();
//        if(flag)
        choseField();
        insertGrade();
        WeeklyTable();
        AddFields();
//        DeleteField();
        newWeekMaster();
         setName();
         setImage();
      //  insertGrade();
        tablePrAb();
    }
// braye sabte nomre
    public void confirmGrade(MouseEvent mouseEvent) {
        int tableSize = insertGradeMaster.getItems().size();
        ArrayList<personDataCenter> personDataCenters = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            personDataCenter person = (personDataCenter) insertGradeMaster.getItems().get(i);
            Double grade = Double.parseDouble(person.getTxtInsert().getText());
            if(grade>=10){
                passedNumber.add(grade);
            }
            long id = person.getStudentId();
            student = archive.readStudent(id);
            for (int j = 0; j < student.getFieldsListForChooseUnit().size(); j++) {
                if (student.getFieldsListForChooseUnit().get(i).getFieldNumber() == lessonCode) {
//TODO borda dagigan nia shart goyobsn vli ishladmibsn
                }
            }
        }
    }

    public int numberOfStudent(long lessonCode) {
        ArrayList<StudentDataCenter> allStudent = new ArrayList<>();
        allStudent.addAll(archive.readAllStudents());
        int numberOfStudent = 0;
        for (int i = 0; i < allStudent.size(); i++) {
            ArrayList<FieldDataCenter> fieldDataCenters = new ArrayList<>();
            fieldDataCenters.addAll(allStudent.get(i).getFieldsListForChooseUnit());
            for (int j = 0; j < fieldDataCenters.size(); j++) {
                if (fieldDataCenters.get(i).getFieldNumber() == lessonCode) {
                    numberOfStudent++;
                    break;
                }
            }
        }
        return numberOfStudent;
    }
}
