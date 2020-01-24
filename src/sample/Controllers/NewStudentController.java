package sample.Controllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import sample.DataCenter.NewStudentDataCenter;
import sample.DataCenter.StudentDataCenter;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewStudentController implements Initializable {

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

    NewStudentDataCenter std;

    public void setStd(NewStudentDataCenter std) {
        this.std = std;
    }


    public void Show() {
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
        if (std.isDay_night() == true) {
            txtCourse.setText("day");
            txtCourse1.setText("day");

        } else {
            txtCourse.setText("night");
            txtCourse1.setText("night");
        }


    }

    public int findComboIndex(JFXComboBox Box) {
        int index = Box.getSelectionModel().getSelectedIndex();
        return index;
    }

    StudentDataCenter student;

    public void Student() {
        student.setFirstName(txtFirstName.getText());
        student.setLastName(txtLastName.getText());
        student.setNationalCode(Long.parseLong(txtNationalID.getText()));
        student.setRate(Long.parseLong(txtRate.getText()));
        student.setField(txtField.getText());
        if (std.isDay_night() == true) {
            student.setDay(true);


        } else {
            student.setDay(false);
        }
        student.setFileNumber(Long.parseLong(txtFileNumber.getText()));
        student.setPhoneNumber(Long.parseLong(txtPhoneNumber.getText()));
        student.setFatherPhoneNumber(Long.parseLong(txtFatherPhoneNumber.getText()));
        student.setFatherName(txtFatherName.getText());
        student.setFaculty(txtFaculty.getText());
        student.setIDCardNumber(Long.parseLong(txtIDCardNumber.getText()));
        student.setAddress(txtAddress.getText());
        student.setSectionEducation(txtSectionEducation.getText());
        student.setCourse(txtCourse.getText());
        student.setLocalBorn(txtLocalBorn.getText());
        student.setDiplomYear(Integer.parseInt(txtDiplomYear.getText()));
        student.setUBorn(txtUBorn.getText());
        student.setUBorn(txtUBorn.getText());
        student.setReligion(txtReligion.getText());
        student.setCityBorn(txtCityBorn.getText());
        student.setEmail(txtEmail.getText());
        student.setZIPCode(Integer.parseInt(txtZIPCode.getText()));
        student.setAreaBorn(txtAreaBorn.getText());
        student.setFileNumber(Long.parseLong(txtFileNumber.getText()));


        int IndexFaith = findComboIndex(comboFaith);
        if (IndexFaith == 0) {
            student.setFaith("زرتشت");
        }
        if (IndexFaith == 1) {
            student.setFaith("یهودی");
        }
        if (IndexFaith == 2) {
            student.setFaith("مسیهی");
        }
        if (IndexFaith == 3) {
            student.setFaith("مسلمان");
        }
        int IndexStartSeason = findComboIndex(comboStartSeason);
        if (IndexStartSeason == 0) {
            student.setStartSeason("نیمسال اول");
        }
        if (IndexStartSeason == 1) {
            student.setStartSeason("نمیمسال دوم");
        }
        int IndexCondition = findComboIndex(comboCondition);
        if (IndexCondition == 0) {
            student.setCondition("فارق التخصیل");
        }
        if (IndexCondition == 1) {
            student.setCondition("در حال تحصیل");
        }
        int IndexNationality = findComboIndex(comboNationality);
        if (IndexNationality == 0) {
            student.setNationality("بومی");
        }
        if (IndexNationality == 1) {
            student.setNationality("غیر بومی");
        }
        int IndexMatrimony = findComboIndex(comboMatrimony);
        if (IndexMatrimony == 0) {
            student.setMatrimony("مجرد");
        }
        if (IndexMatrimony == 1) {
            student.setMatrimony("متاهل");
        }
        int IndexDyplomType = findComboIndex(comboMatrimony);
        if (IndexDyplomType == 0) {
            student.setDiplomType("قبولی");
        }
        if (IndexDyplomType == 1) {
            student.setDiplomType("ردی");
        }

        LocalDate localDate = DataPicker.getValue();
        student.setBYear(localDate.getYear());
        student.setBMonth(localDate.getMonthValue());
        student.setBDay(localDate.getDayOfMonth());
    }

    public void Scanner() {
        if (!emptyFinder(txtIDCardNumber)) {
            txtIDCardNumber.setStyle("-fx-background-color: D70406");
        } else if (!StringFinder(txtIDCardNumber)) {
            txtIDCardNumber.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtPhoneNumber)) {
            txtPhoneNumber.setStyle("-fx-background-color: D70406");
        } else if (!StringFinder(txtPhoneNumber)) {
            txtPhoneNumber.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtFatherPhoneNumber)) {
            txtFatherPhoneNumber.setStyle("-fx-background-color: D70406");
        } else if (!StringFinder(txtFatherPhoneNumber)) {
            txtFatherPhoneNumber.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtZIPCode)) {
            txtZIPCode.setStyle("-fx-background-color: D70406");
        } else if (!StringFinder(txtZIPCode)) {
            txtZIPCode.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtFileNumber1)) {
            txtFileNumber1.setStyle("-fx-background-color: D70406");
        } else if (!StringFinder(txtFileNumber1)) {
            txtFileNumber1.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtDiplomYear)) {
            txtDiplomYear.setStyle("-fx-background-color: D70406");
        } else if (!StringFinder(txtDiplomYear)) {
            txtDiplomYear.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtRate)) {
            txtRate.setStyle("-fx-background-color: D70406");
        } else if (!StringFinder(txtRate)) {
            txtRate.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtSectionEducation)) {
            txtSectionEducation.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtSectionEducation)) {
            txtSectionEducation.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtFatherName)) {
            txtFatherName.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtFatherName)) {
            txtFatherName.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtLocalBorn)) {
            txtLocalBorn.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtLocalBorn)) {
            txtLocalBorn.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtFiled1)) {
            txtFiled1.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtFiled1)) {
            txtFiled1.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtUBorn)) {
            txtUBorn.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtUBorn)) {
            txtUBorn.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtReligion)) {
            txtReligion.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtReligion)) {
            txtReligion.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtCityBorn)) {
            txtCityBorn.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtCityBorn)) {
            txtCityBorn.setStyle("-fx-text-inner-color: D70406");
        }


        if (!emptyFinder(txtAreaBorn)) {
            txtAreaBorn.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtAreaBorn)) {
            txtAreaBorn.setStyle("-fx-text-inner-color: D70406");
        }

        if (!emptyFinder(txtFaculty)) {
            txtFaculty.setStyle("-fx-background-color: D70406");
        } else if (!NumberFinder(txtFaculty)) {
            txtFaculty.setStyle("-fx-text-inner-color: D70406");
        }


    }


    public boolean emptyFinder(TextField txtField) {
        boolean empty = true;
        if (txtField == null) {
            empty = false;

        }
        return empty;
    }

    public boolean NumberFinder(TextField txtField) {

        boolean exit = true;

        for (int i = 0; i < txtField.getText().length(); i++) {
            int c = txtField.getText().charAt(i);
            if (c >= 48 && c <= 57) {
                exit = false;

            }
        }
        return exit;
    }

    public boolean StringFinder(TextField txtField) {
        boolean exit = true;

        for (int i = 0; i < txtField.getText().length(); i++) {
            int c = txtField.getText().charAt(i);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                exit = false;
            }
        }
        return exit;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        student = new StudentDataCenter();
        String[] Faith = {"زرتشت", "یهودی", "مسیهی", "مسلمان"};
        comboFaith.getItems().addAll(Faith);
        String[] StartSeason = {"نیمسال اول", "نیمسال دوم"};
        comboStartSeason.getItems().addAll(StartSeason);
        String[] Nationality = {"بومی", "غیر بومی"};
        comboNationality.getItems().addAll(Nationality);
        String[] Matrimony = {"مجرد", "متاهل"};
        comboMatrimony.getItems().addAll(Matrimony);
        String[] condition = {"فارق تحصیل", "درحال تحصیل"};
        comboCondition.getItems().addAll(condition);
        String[] diplomType = {"قیولی", "ردی"};
        comboDyplomType.getItems().addAll(diplomType);


    }

}
