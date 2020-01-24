package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.DataCenter.MasterDataCenter;
import sample.DataCenter.personDataCenter;

import java.net.URL;
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

    public void setMaster(MasterDataCenter master) {
        this.master = master;
    }

    private MasterDataCenter master;

    public void UnVisible() {

        insertGradeMaster.setVisible(false);

    }


    public void WeeklyTable() {
        MasterLessonsWeeklyRecord.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        LessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        LessonUnitMasterRecord.setCellValueFactory(new PropertyValueFactory<>("unit"));
        StudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        PassedStudentNumberMasterRecord.setCellValueFactory(new PropertyValueFactory<>("passedStudentNumber"));
        weeklyTableView.getItems().add(new personDataCenter("math", 1322, 3, 243, 54));
        weeklyTableView.getItems().add(new personDataCenter("math",1322,3,243,54));

    }


    public void AddFields(){

        addLessonMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        addLessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        addUnitMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
        addPlaceMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        addMaster.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
        AddTableMaster.getItems().add(new personDataCenter("riazi",512,3,"do shanba",new JFXToggleButton()));




    }

    public void DeleteField(){

        DeleteLessonMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        DeleteLessonCodeMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
        DeleteUnitMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
        DeletePlaceMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
        DeleteMaster.setCellValueFactory(new PropertyValueFactory<>("btnChooseUnit"));
        DeleteTableMaster.getItems().add(new personDataCenter("sas",515,5,"seshanbe", new JFXToggleButton()));




    }

   public  void  newWeekMaster(){
       rowNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("row"));
       lessonNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("lesson"));
       LessonCodeNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("lessonCod"));
       UnitNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<>("unit"));
       numberStudentNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
       startTimeNewWeekTableMaster.setCellValueFactory(new PropertyValueFactory<>("classStartTime"));
       placeNewWeekMaster.setCellValueFactory(new PropertyValueFactory<>("classPlace"));
       newWeekMaster.getItems().add(new personDataCenter(1,"sada",5542424,4, 45,"pang","dgbd"));


   }
// do ta table mondeh

    public  void  insertGrade(){
        rowInsertGrade.setCellValueFactory(new PropertyValueFactory<>("row"));
        lastNameInsetGrade.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        FirstNameInssertGrade.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        IdInsertGrade.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        genderInsertGrade.setCellValueFactory(new PropertyValueFactory<>("gender"));
        insertGradeMasterCLM.setCellValueFactory(new PropertyValueFactory<>("txtInsert"));
        insertGradeMaster.getItems().add(new personDataCenter(1,"sada","sss",98536, "Male", new TextField()));

    }

    public  void tablePrAb(){
         RadifPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("row"));
        LastNamePrAbMaster.setCellValueFactory(new PropertyValueFactory<>("lastName"));
         FirstNamePrAbMaster.setCellValueFactory(new PropertyValueFactory<>("firstName"));
         IDPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("studentId"));
         AbsentPrAbMaster.setCellValueFactory(new PropertyValueFactory<>("numberOfAbsence"));
        TableViewPrAbMaster.getItems().add(new sample.DataCenter.person(1,"sada","sss",98536, 1));
    }





   public  void  showDeleteTable(){

        DeleteTableMaster.setVisible(true);


    }


   public  void  setName(){
        txtNameMaster.setText(master.getFirstName());
        txtFamilyMaster.setText(master.getLastName());
        txtNationalCodeMater.setText(master.getNationalNumber()+"");
        txtPersonalCodeMaster.setText(master.getPersonalNumber()+"");
   }

   public  void  setImage(){

       Image imageFM = new Image("./sample/PNG/MasterFM.png");
       Image imageM = new Image("./sample/PNG/MasIcon.png");

    if(master.getGender()==0)
    MasterFaceImage.setImage(imageFM);
    if(master.getGender()==1)
    MasterFaceImage.setImage(imageM);


   }














    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WeeklyTable();
        AddFields();
        DeleteField();
        newWeekMaster();
       // setName();
       // setImage();
        insertGrade();
        tablePrAb();

    }


}
