package sample.Controllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;
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
    public TextField txtINNumber;
    public TextField txtFatherPhoneNumber;
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
    public JFXComboBox comboFaith;
    public JFXComboBox comboStartSeason;
    public JFXComboBox comboCondition;
    public JFXComboBox comboCourse;
    public JFXComboBox comboNationality;
    public JFXComboBox comboDiplomType;
    public JFXComboBox comboMaterimony;
    public DatePicker DataPicker;
    public JFXComboBox comboCourse1;
    public TextField txtEducation;
    public TextField txtCourse;

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
       txtRate.setText(String.valueOf(std.getRate()));
       txtField.setText(String.valueOf(std.getField()));
       txtFiled1.setText(String.valueOf(std.getField()));
       txtFileNumber.setText(String.valueOf(std.getFileNumber()));
       txtFileNumber1.setText(String.valueOf(std.getFileNumber()));
       txtCourse.setText(String.valueOf(std.isDay_night()));


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
