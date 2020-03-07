package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.layout.AnchorPane;
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

    public TableView newWeekMaster;
    public TableColumn rowNewWeekMaster;
    public TableColumn lessonNewWeekMaster;
    public TableColumn LessonCodeNewWeekMaster;
    public TableColumn UnitNewWeekTableMaster;
    public TableColumn numberStudentNewWeekMaster;
    public TableColumn startTimeNewWeekTableMaster;

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
    public JFXButton backButtonMaster1;
    public ComboBox comboLessonMaster2;
    public JFXButton finalConfirmAdd;
    public Label lblAlert;
    public Tab newWeektableMaster;
    private MasterDataCenter master;
    private StudentDataCenter student;
    private ArrayList<StudentDataCenter> findStudent;
    private ArrayList<FieldDataCenter> MField;
    private ArrayList<FieldDataCenter> masField;
    private ArrayList<personDataCenterMaster> masterChosedUnits;
    private ArrayList<FieldDataCenter> listStd;
    private ArrayList<Double> passedNumber;
    private long lessonCode;
    private long lessonCodePrAb;
    private String[] comboItem;
    ArrayList<personDataCenterMaster> personDataCenters = new ArrayList<>();
    ArrayList<FieldDataCenter> fields = new ArrayList<>();
    private  int numberOfPassedStudent = 0;

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

    // history table of master
    public void WeeklyTable() {
        if(masterChosedUnits!=null) {
            MasterLessonsWeeklyRecord.setCellValueFactory(new PropertyValueFactory<>("teachedLessonHistory"));
            LessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("teachedLessonCodeHistory"));
            LessonUnitMasterRecord.setCellValueFactory(new PropertyValueFactory<>("teachedLessonUnitHistory"));
            StudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("numberOfStudentTeachedLesson"));
            PassedStudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("numberOfPassedStudentTeachedLesson"));


            for (int i = 0; i < masterChosedUnits.size(); i++) {

                weeklyTableView.getItems().add(new personDataCenterMaster(personDataCenters.get(i).getMasterChosedLesson(), personDataCenters.get(i).getMasterChosedLessonCode(), personDataCenters.get(i).getMasterChosedLessonUnit(), numberOfStudent(personDataCenters.get(i).getMasterChosedLessonCode()), numberOfPassedStudent));

            }
        }


    }

    public void newWeekMaster() {
        if(masterChosedUnits!=null) {

            rowNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("rowNewWeeklyTable"));
            lessonNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("masterChosedLesson"));
            LessonCodeNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("masterChosedLessonCode"));
            UnitNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<>("masterChosedLessonUnit"));
            numberStudentNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("numberOfStudentMasterChosedLesson"));
            startTimeNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<>("classTartTimeMasterChosedLesson"));
            if (masterChosedUnits.get(0).getPresentedLesson() != null) {
                for (int i = 0; i < masterChosedUnits.size(); i++) {
                    newWeekMaster.getItems().add(new personDataCenterMaster(1 + i, masterChosedUnits.get(i).getPresentedLesson(), masterChosedUnits.get(i).getPresentedLessonCode(), masterChosedUnits.get(i).getPresentedLessonUnit(), 45, masterChosedUnits.get(i).getPresentedLessonStartTime(), ""));
                }
            }
        }

    }



    public void AddFields() {
        FieldDataCenter fieldDataCenter = new FieldDataCenter();

         ArrayList<FieldDataCenter> fieldMaster = archive.readAllFields();



        addLessonMaster.setCellValueFactory(new PropertyValueFactory<>("presentedLesson"));
        addLessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("presentedLessonCode"));
        addUnitMaster.setCellValueFactory(new PropertyValueFactory<>("presentedLessonUnit"));
        addPlaceMaster.setCellValueFactory(new PropertyValueFactory<>("presentedLessonStartTime"));
        addMaster.setCellValueFactory(new PropertyValueFactory<>("addPresentedLessonToggleButton"));


        for (int i = 0; i < fieldMaster.size(); i++) {
            AddTableMaster.getItems().add(new personDataCenterMaster(fieldMaster.get(i).getFieldName(), fieldMaster.get(i).getFieldNumber() ,fieldMaster.get(i).getUnit(), fieldMaster.get(i).getClassStartTime(), new JFXToggleButton()));


        }
    }



    public void insertGrade() {
        if(masterChosedUnits!=null) {

            rowInsertGrade.setCellValueFactory(new PropertyValueFactory<>("rowInsertGradeTable"));
            lastNameInsetGrade.setCellValueFactory(new PropertyValueFactory<>("studentLastName"));
            FirstNameInssertGrade.setCellValueFactory(new PropertyValueFactory<>("studentFirstName"));
            IdInsertGrade.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            genderInsertGrade.setCellValueFactory(new PropertyValueFactory<>("studentGender"));
            insertGradeMasterCLM.setCellValueFactory(new PropertyValueFactory<>("txtInsertGradeForMaster"));
            for (int i = 0; i < findStudent.size(); i++) {
                if (findStudent.get(i).getLastName() != null)
                    insertGradeMaster.getItems().add(new sample.DataCenter.personDataCenterMaster(i + 1, findStudent.get(i).getLastName(), findStudent.get(i).getFirstName(), findStudent.get(i).getStudentNumber(), findStudent.get(i).getGender(), (JFXTextField) new TextField()));
            }
        }
    }

    public void tablePrAb() {
        if(masterChosedUnits!=null) {
            RadifPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("rowPresentAbsence"));
            LastNamePrAbMaster.setCellValueFactory(new PropertyValueFactory<>("studentLastName"));
            FirstNamePrAbMaster.setCellValueFactory(new PropertyValueFactory<>("studentFirstName"));
            IDPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            AbsentPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("txtInsertAbsenceNumberOfStudent"));
            for (int i = 0; i < findStudent.size(); i++) {
                TableViewPrAbMaster.getItems().add(new sample.DataCenter.personDataCenterMaster(i + 1, findStudent.get(i).getLastName(), findStudent.get(i).getFirstName(), findStudent.get(i).getStudentNumber(), (JFXTextField) new TextField()));

            }
        }
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


    // finding the list of  student that choose the lesson that master search it
    public ArrayList<StudentDataCenter> findListOfStudents(long lessonCode) {
        ArrayList<StudentDataCenter> students = new ArrayList<StudentDataCenter>();
        ArrayList<StudentDataCenter> foundedStudents = new ArrayList<StudentDataCenter>();
        ArchiveDataCenter archiveDataCenter = new ArchiveDataCenter();
        students.addAll(archiveDataCenter.readAllStudents());
        for (int i = 0; i < students.size(); i++) {
            ArrayList<FieldDataCenter> Field = students.get(i).getFieldsListForChooseUnit();
            for (int j = 0; j < Field.size(); j++) {
                if (Field.get(j).getFieldNumber() == lessonCode) {
                    foundedStudents.add(students.get(i));
                    break;
                }
            }
        }
        return foundedStudents;
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

    //chose unit
    public void ConfirmAddingFieldMaster() {

        int tableSize = AddTableMaster.getItems().size();
        ArrayList<personDataCenterMaster> personDataCenters = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            personDataCenterMaster person = (personDataCenterMaster) AddTableMaster.getItems().get(i);
            JFXToggleButton jfxToggleButton = person.getAddPresentedLessonToggleButton();
            if (jfxToggleButton.isSelected()) {
                personDataCenters.add(person);


                 fields.addAll(archive.readAllFields());

                // putting master name in the field Object
                for (int j = 0; j <fields.size() ; j++) {
                    if(person.getPresentedLessonCode()==fields.get(j).getFieldNumber()){
                        fields.get(j).setMasterName(master.getFirstName() + " " +master.getLastName());

                    }
                }





            }

        }

        masterChosedUnits.addAll(personDataCenters);

        newWeekMaster();
        WeeklyTable();


    }

    //
    public void choseFieldForInsertingGrade() {
        int ind = combolessonMaster.getSelectionModel().getSelectedIndex();
        if (ind > 0) {
            lessonCode = masterChosedUnits.get(ind).getPresentedLessonCode();
            findStudent.addAll(findListOfStudents(lessonCode));
            insertGrade();
        }
    }

    public void choseFieldForInsertingAbsenceNumber() {
        int ind = comboLessonMaster2.getSelectionModel().getSelectedIndex();
        if (ind > 0) {
            lessonCodePrAb = masterChosedUnits.get(ind).getPresentedLessonCode();
            findStudent.addAll(findListOfStudents(lessonCode));
            tablePrAb();
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        archive = new ArchiveDataCenter();
        findStudent = new ArrayList<>();
        masField = new ArrayList<>();
        masterChosedUnits = new ArrayList<>();
        listStd = new ArrayList<>();
        passedNumber = new ArrayList<>();
        master.setMasField(archive.readAllFields());



        for (int i = 0; i < masterChosedUnits.size(); i++) {
            comboItem[i] = masterChosedUnits.get(i).getPresentedLesson();

        }
        combolessonMaster.getItems().add(comboItem);
        comboLessonMaster2.getItems().add(comboItem);

// setting the name of Master
        setName();
//setting the image of Master
        setImage();
// showing presented Lessons for choosing them(chose unit)
        AddFields();

    }


    // the process of confirming the insertedGrades
    public void confirmInsertedGrades(MouseEvent mouseEvent) {
        int tableSize = insertGradeMaster.getItems().size();
     //   ArrayList<personDataCenterMaster> personDataCenters = new ArrayList<>();
// putting rows in an Arraylist

        for (int i = 0; i < tableSize; i++) {
            personDataCenterMaster person = (personDataCenterMaster) insertGradeMaster.getItems().get(i);
            Double grade = Double.parseDouble(person.getTxtInsertGradeForMaster().getText());
//counting PassedStudentsNumber
            if (grade >= 10) {
               numberOfPassedStudent++;
            }
            personDataCenters.add(person);

//clearing the txtInsertGrade
            person.getTxtInsertGradeForMaster().setText("");
            long id = person.getStudentId();
            student = archive.readStudent(id);
//searching for the student that have choosedUnitMasterLessonCode and putting the grade in the object of student
            for (int j = 0; j < student.getFieldsListForChooseUnit().size(); j++) {
                if (student.getFieldsListForChooseUnit().get(i).getFieldNumber() == lessonCode) {
                    student.getFieldsListForChooseUnit().get(i).setScore(grade);
                }
            }
        }

    }

    // counting the number of student for every lesson
    public int numberOfStudent(long lessonCode) {
        ArrayList<StudentDataCenter> allStudent = new ArrayList<>();
        allStudent.addAll(archive.readAllStudents());
        int numberOfStudent = 0;
        for (int i = 0; i < allStudent.size(); i++) {
            ArrayList<FieldDataCenter> fieldDataCenters = new ArrayList<>();
            fieldDataCenters.addAll(allStudent.get(i).getFieldsListForChooseUnit());
            for (int j = 0; j < fieldDataCenters.size(); j++) {
                if (fieldDataCenters.get(j).getFieldNumber() == lessonCode) {
                    numberOfStudent++;
                    break;
                }
            }
        }

        return numberOfStudent;
    }
   public void confirmInsertAbsenceNumber(){
       int tableSize = TableViewPrAbMaster.getItems().size();


       for (int i = 0; i < tableSize; i++) {
           personDataCenterMaster person = (personDataCenterMaster) TableViewPrAbMaster.getItems().get(i);
           int Absence = Integer.parseInt(person.getTxtInsertGradeForMaster().getText());

           personDataCenters.add(person);


           person.getTxtInsertGradeForMaster().setText("");
           long id = person.getStudentId();
           student = archive.readStudent(id);

           for (int j = 0; j < student.getFieldsListForChooseUnit().size(); j++) {
               if (student.getFieldsListForChooseUnit().get(i).getFieldNumber() == lessonCodePrAb) {
                   student.getFieldsListForChooseUnit().get(i).setNumberOfAbsence(Absence);

               }

           }

       }




   }




}
