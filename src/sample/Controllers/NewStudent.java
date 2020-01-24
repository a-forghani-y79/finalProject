package sample.Controllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ResourceBundle;

public class NewStudent implements Initializable {

    public TextField txtNationalID;
    public TextField txtLastName;
    public TextField txtFirstName;
    public TextField txtRate;
    public TextField txtField;
    public TextField txtFileNumber;
    public TextField txtFaculty;
    public TextField txtLastName1;
    public TextField txtName1;
    public TextField txtPhoneNumber;
    public TextField txtLocalBorn;
    public TextField txtFatherName;
    public TextField txtFiled1;
    public TextField txtReligion;
    public TextField txtCityBorn;
    public TextField txtUBorn;
    public TextField txtAreaBorn;
    public TextField txtDiplomYear;
    public TextField txtFileNumber1;
    public TextField txtZIPCode;
    public TextField txtEmail;
    public TextField txtNationalID1;
    public JFXComboBox<String> comboFaith;
    public JFXComboBox<String> comboStartSeason;
    public JFXComboBox<String> comboCondition;

    public JFXComboBox<String> comboNationality;
    public JFXComboBox<String> comboMatrimony;
    public DatePicker DataPicker;
    public TextField txtCourse;
    public TextField txtAddress;
    public TextField txtIDCardNumber;
    public TextField txtFiledNumber;
    public TextField txtSectionEducation;
    public TextField txtFatherPhoneNumber;
    public ImageView Tab1PIC;
    public TextField txtRate1;
    public TextField txtCourse1;
    public JFXComboBox<String> comboDyplomType;


    sample.DataCenter.NewStudent std ;

    NewStudent(sample.DataCenter.NewStudent newStudent) {
        std = newStudent;
    }

    public  void Show() {
       txtFirstName.setText(std.getFirstName());
       txtName1.setText(std.getFirstName());
       txtLastName1.setText(std.getLastName());
       txtLastName.setText(std.getLastName());
       txtNationalID.setText(String.valueOf(std.getID()));
       txtFileNumber1.setText(String.valueOf(std.getID()));
       txtRate.setText(String.valueOf(std.getRate()));
       txtRate1.setText(String.valueOf(std.getRate()));
       txtField.setText(String.valueOf(std.getField()));
       txtFiled1.setText(String.valueOf(std.getField()));
       txtFileNumber.setText(String.valueOf(std.getFileNumber()));
       txtFileNumber1.setText(String.valueOf(std.getFileNumber()));
       if (std.isDay_night()==true){
           txtCourse.setText("day");
            txtCourse1.setText("day");

       }else {
           txtCourse.setText("night");
           txtCourse1.setText("night");
       }


    }

    public void Student()  {
         String firstName;
         String lastName;
         long rate;
         long ID;
         String field;
         boolean isDay; //true for roozaneh
         long fileNumber;
         long PhoneNumber ;
         Long FatherPhoneNumber;
         String FatherName ;
         String Faculty;
         long IDCardNumber ;
         String Address;
         String SectionEducation;
         String Condition;
         String StartSeason;
         String Nationality;
         String Course ;
         String DiplomType;
         String Matrimony;
         String LocalBorn;
         int DiplomYear;
         String UBorn;
         String Faith ;
         String Religion;
         String CityBorn;
         String Email ;
         long ZIPCode ;
         String AreaBorn ;
         String FileNumber1 ;











    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    String [] Faith = {"زرتشت","یهودی","مسیهی","مسلمان"};
    comboFaith.getItems().addAll(Faith);
    String [] StartSeason ={"نیمسال اول","نیمسال دوم"};
    comboStartSeason.getItems().addAll(StartSeason) ;
    String [] Nationality = {"بومی","غیر بومی"};
    comboNationality.getItems().addAll(Nationality);
    String [] Matrimony = {"مجرد","متاهل"};
    comboMatrimony.getItems().addAll(Matrimony);
    String [] condition = {"فارق تحصیل","درحال تحصیل"};
    comboCondition.getItems().addAll(condition);
    String [] diplomType = {"قیولی","ردی"};
    comboDyplomType.getItems().addAll(diplomType);
    }
}
