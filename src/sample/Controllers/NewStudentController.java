package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataCenter.ArchiveDataCenter;
import sample.DataCenter.NewStudentDataCenter;
import sample.DataCenter.StudentDataCenter;
import sample.DataCenter.StudentIdGeneratorDataCenter;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewStudentController implements Initializable {

    public TextField txtNationalID;
    public TextField txtLastName;
    public TextField txtFirstName;
    public TextField txtRate;
    public TextField txtField;
    public TextField txtFileNumber;
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
    public TextField txtSectionEducation;
    public TextField txtFatherPhoneNumber;
    public ImageView Tab1PIC;
    public TextField txtRate1;
    public TextField txtCourse1;
    public JFXComboBox<String> comboDyplomType;
    public TextField txtGender;
    public JFXButton btnSubmit;
    public ImageView imageViewBack;
    public ImageView imageExit1;
    public ImageView imageExit2;
    public ImageView imageBack2;
    public ImageView imageBack3;
    public ImageView imageExit3;
    public JFXButton btnExit1;
    public JFXButton btnBack1;
    public JFXButton btnExit2;
    public JFXButton btnBack2;
    public JFXButton btnExit3;
    public JFXButton btnBack3;
    public TextField txtGender2;
    public TextArea txtArea;
    private NewStudentDataCenter std;
    private StudentDataCenter student;
    private StudentIdGeneratorDataCenter studentIdGeneratorDataCenter;

    public void setStd(sample.DataCenter.NewStudentDataCenter std) {
        this.std = std;
    }


    private void Show() {
        txtFirstName.setText(std.getFirstName());
        txtName1.setText(std.getFirstName());
        txtLastName1.setText(std.getLastName());
        txtLastName.setText(std.getLastName());
        txtNationalID.setText(String.valueOf(std.getID()));
        txtNationalID1.setText(String.valueOf(std.getID()));
        txtRate.setText(String.valueOf(std.getRate()));
        txtRate1.setText(String.valueOf(std.getRate()));
        txtField.setText(String.valueOf(std.getField()));
        txtFiled1.setText(String.valueOf(std.getField()));
        txtFileNumber.setText(String.valueOf(std.getFileNumber()));
        txtFileNumber1.setText(String.valueOf(std.getFileNumber()));
        Image img;
        if (std.getGender() == 0) {
            txtGender.setText("مونث");
            student.setGender(0);
            img = new Image("./sample/PNG/Female_Student-512.png");
            Tab1PIC.setImage(img);
        } else if (std.getGender() == 1) {
            student.setGender(1);
            txtGender.setText("مذکر");
            img = new Image("./sample/PNG/Student.png");
            Tab1PIC.setImage(img);
        }
        if (std.getGender() == 0) {
            txtGender2.setText("مونث");
            student.setGender(0);
        } else if (std.getGender() == 1) {
            student.setGender(1);
            txtGender2.setText("مذکر");
        }
        if (std.isDay_night() == true) {
            txtCourse.setText("روزانه");
            txtCourse1.setText("روزانه");
        } else {
            txtCourse.setText("شبانه");
            txtCourse1.setText("شبانه");
        }
    }

    private int findComboIndex(JFXComboBox Box) {
        int index = Box.getSelectionModel().getSelectedIndex();
        return index;
    }


    private void student() {
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
        student.setZIPCode(Long.parseLong(txtZIPCode.getText()));
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
            student.setFaith("مسیحی");
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
            student.setCondition("فارغ التخصیل");
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
            student.setDiplomType("ریاضی فیزیک");
        }
        if (IndexDyplomType == 1) {
            student.setDiplomType("تجربی");
        }
        if (IndexDyplomType == 2) {
            student.setDiplomType("انسانی");
        }


        LocalDate localDate = DataPicker.getValue();
        student.setBYear(localDate.getYear());
        student.setBMonth(localDate.getMonthValue());
        student.setBDay(localDate.getDayOfMonth());
    }

    private boolean scanner() {
        boolean flag = true;
        LocalDate localDate = DataPicker.getValue();
        if (txtDiplomYear.getText().length() != 4) {
            txtDiplomYear.setStyle(txtDiplomYear.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        }
        try {
            localDate.getYear();
            localDate.getMonth();
            localDate.getDayOfMonth();
        } catch (NullPointerException e) {
            DataPicker.setStyle(DataPicker.getStyle() + "-fx-background-color: #D70406 ;");
            flag = false;
        }
        if (!(emptyFinder(txtIDCardNumber))) {
            txtIDCardNumber.setStyle(txtIDCardNumber.getStyle() + "-fx-background-color: #D70406 ;");
            flag = false;
        } else if (!StringFinder(txtIDCardNumber)) {
            txtIDCardNumber.setStyle(txtIDCardNumber.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtIDCardNumber)) {
            txtIDCardNumber.setStyle(txtIDCardNumber.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (StringFinder(txtIDCardNumber)) {
            txtIDCardNumber.setStyle(txtIDCardNumber.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtPhoneNumber)) {
            txtPhoneNumber.setStyle(txtPhoneNumber.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!StringFinder(txtPhoneNumber)) {
            txtPhoneNumber.setStyle(txtPhoneNumber.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtPhoneNumber)) {
            txtPhoneNumber.setStyle(txtPhoneNumber.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (StringFinder(txtPhoneNumber)) {
            txtPhoneNumber.setStyle(txtPhoneNumber.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtFatherPhoneNumber)) {
            txtFatherPhoneNumber.setStyle(txtFatherPhoneNumber.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!StringFinder(txtFatherPhoneNumber)) {
            txtFatherPhoneNumber.setStyle(txtFatherPhoneNumber.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtFatherPhoneNumber)) {
            txtFatherPhoneNumber.setStyle(txtFatherPhoneNumber.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (StringFinder(txtFatherPhoneNumber)) {
            txtFatherPhoneNumber.setStyle(txtFatherPhoneNumber.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtZIPCode)) {
            txtZIPCode.setStyle(txtZIPCode.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!StringFinder(txtZIPCode)) {
            txtZIPCode.setStyle(txtZIPCode.getStyle() + "-fx-text-inner-color: #D70406;");
        }
        if (emptyFinder(txtZIPCode)) {
            txtZIPCode.setStyle(txtZIPCode.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (StringFinder(txtZIPCode)) {
            txtZIPCode.setStyle(txtZIPCode.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtFileNumber1)) {
            txtFileNumber1.setStyle(txtFileNumber1.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!StringFinder(txtFileNumber1)) {
            txtFileNumber1.setStyle(txtFileNumber1.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtFileNumber1)) {
            txtFileNumber1.setStyle(txtFileNumber1.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (StringFinder(txtFileNumber1)) {
            txtFileNumber1.setStyle(txtFileNumber1.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtDiplomYear)) {
            txtDiplomYear.setStyle(txtDiplomYear.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!StringFinder(txtDiplomYear)) {
            txtDiplomYear.setStyle(txtDiplomYear.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtDiplomYear)) {
            txtDiplomYear.setStyle(txtDiplomYear.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (StringFinder(txtDiplomYear)) {
            txtDiplomYear.setStyle(txtDiplomYear.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtRate)) {
            txtRate.setStyle(txtRate.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!StringFinder(txtRate)) {
            txtRate.setStyle(txtRate.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtRate)) {
            txtRate.setStyle(txtRate.getStyle() + "-fx-background-color:#FFFFFF ;");
        } else if (StringFinder(txtRate)) {
            txtRate.setStyle(txtRate.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtSectionEducation)) {
            txtSectionEducation.setStyle(txtSectionEducation.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!NumberFinder(txtSectionEducation)) {
            txtSectionEducation.setStyle(txtSectionEducation.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtSectionEducation)) {
            txtSectionEducation.setStyle(txtSectionEducation.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (NumberFinder(txtSectionEducation)) {
            txtSectionEducation.setStyle(txtSectionEducation.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtFatherName)) {
            txtFatherName.setStyle(txtFatherName.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!NumberFinder(txtFatherName)) {
            txtFatherName.setStyle(txtFatherName.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtFatherName)) {
            txtFatherName.setStyle(txtFatherName.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (NumberFinder(txtFatherName)) {
            txtFatherName.setStyle(txtFatherName.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtLocalBorn)) {
            txtLocalBorn.setStyle(txtLocalBorn.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!NumberFinder(txtLocalBorn)) {
            txtLocalBorn.setStyle(txtLocalBorn.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtLocalBorn)) {
            txtLocalBorn.setStyle(txtLocalBorn.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (NumberFinder(txtLocalBorn)) {
            txtLocalBorn.setStyle(txtLocalBorn.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtFiled1)) {
            txtFiled1.setStyle(txtFiled1.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!NumberFinder(txtFiled1)) {
            txtFiled1.setStyle(txtFiled1.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtFiled1)) {
            txtFiled1.setStyle(txtFiled1.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (NumberFinder(txtFiled1)) {
            txtFiled1.setStyle(txtFiled1.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtUBorn)) {
            txtUBorn.setStyle(txtUBorn.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!NumberFinder(txtUBorn)) {
            txtUBorn.setStyle(txtUBorn.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtUBorn)) {
            txtUBorn.setStyle(txtUBorn.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (NumberFinder(txtUBorn)) {
            txtUBorn.setStyle(txtUBorn.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtReligion)) {
            txtReligion.setStyle(txtReligion.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!NumberFinder(txtReligion)) {
            txtReligion.setStyle(txtReligion.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtReligion)) {
            txtReligion.setStyle(txtReligion.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (NumberFinder(txtReligion)) {
            txtReligion.setStyle(txtReligion.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtCityBorn)) {
            txtCityBorn.setStyle(txtCityBorn.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!NumberFinder(txtCityBorn)) {
            txtCityBorn.setStyle(txtCityBorn.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtCityBorn)) {
            txtCityBorn.setStyle(txtCityBorn.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (NumberFinder(txtCityBorn)) {
            txtCityBorn.setStyle(txtCityBorn.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtAreaBorn)) {
            txtAreaBorn.setStyle(txtAreaBorn.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
        } else if (!NumberFinder(txtAreaBorn)) {
            txtAreaBorn.setStyle(txtAreaBorn.getStyle() + "-fx-text-inner-color: #D70406;");
            flag = false;
        }
        if (emptyFinder(txtAreaBorn)) {
            txtAreaBorn.setStyle(txtAreaBorn.getStyle() + "-fx-background-color: #FFFFFF;");
        } else if (NumberFinder(txtAreaBorn)) {
            txtAreaBorn.setStyle(txtAreaBorn.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (!emptyFinder(txtAddress)) {
            txtAddress.setStyle(txtAddress.getStyle() + "-fx-background-color: #D70406;");
            flag = false;
//        } else if (!NumberFinder(txtAddress)) {
//            txtAddress.setStyle(txtAddress.getStyle() + "-fx-text-inner-color: #D70406;");
//            flag = false;
        }
        if (emptyFinder(txtAddress)) {
            txtAddress.setStyle(txtAddress.getStyle() + "-fx-background-color: #FFFFFF;");
//        } else if (NumberFinder(txtAddress)) {
//            txtAddress.setStyle(txtAddress.getStyle() + "-fx-text-inner-color: #000000;");
        }
        if (findComboIndex(comboFaith) == -1) {
            comboFaith.setStyle("-fx-background-color: #D70406");
            flag = false;
        } else {
            comboFaith.setStyle("-fx-background-color: #FFFFFF");
        }
        if (findComboIndex(comboStartSeason) == -1) {
            comboStartSeason.setStyle("-fx-background-color: #D70406");
            flag = false;
        } else {
            comboStartSeason.setStyle("-fx-background-color: #FFFFFF");
        }
        if (findComboIndex(comboCondition) == -1) {
            comboCondition.setStyle("-fx-background-color: #D70406");
            flag = false;
        } else {
            comboCondition.setStyle("-fx-background-color: #FFFFFF");
        }

        if (findComboIndex(comboNationality) == -1) {
            comboNationality.setStyle("-fx-background-color: #D70406");
            flag = false;
        } else {
            comboNationality.setStyle("-fx-background-color: #FFFFFF");
        }

        if (findComboIndex(comboMatrimony) == -1) {
            comboMatrimony.setStyle("-fx-background-color: #D70406");
            flag = false;
        } else {
            comboMatrimony.setStyle("-fx-background-color: #FFFFFF");
        }

        if (findComboIndex(comboDyplomType) == -1) {
            comboDyplomType.setStyle("-fx-background-color: #D70406");
            flag = false;
        } else {
            comboDyplomType.setStyle("-fx-background-color: #FFFFFF");
        }
        return flag;
    }

    @FXML
    private void exit() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا می خواهید خارج شوید؟ " , ButtonType.YES, ButtonType.NO);


        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.YES) {
                System.exit(0);
            }
        }
    }

    @FXML
    private void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا می خواهید برگردید؟"  , ButtonType.YES, ButtonType.NO);


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


    public void btnSubmit() {
        if (scanner()) {
            student();
            long id = studentIdGeneratorDataCenter.creatIdStudent();
            student.setStudentNumber(id);
            System.out.println(id);
            ArchiveDataCenter archiveDataCenter = new ArchiveDataCenter();
            archiveDataCenter.writeStudent(student);
            student.setFileNumber(0);
            txtArea.setVisible(true);
            txtArea.setText("ثبت نام شما با موفقیت انجام پذیرفت!!"+
                    "\n"+id +  "شما از این پس با نام کاربری : "+ "\n"+
                  txtNationalID.getText() +  "و با پسورد :");



            //TODO show student number from Generator
        } else {
            //TODO show suitable message
        }

    }


    private boolean emptyFinder(TextField txtField) {
        boolean empty = true;
        if (txtField.getText().equals("")) {
            empty = false;

        }
        return empty;
    }

    private boolean NumberFinder(TextField txtField) {

        boolean exit = true;

        for (int i = 0; i < txtField.getText().length(); i++) {
            int c = txtField.getText().charAt(i);
            if (c >= 48 && c <= 57) {
                exit = false;

            }
        }
        return exit;
    }

    private boolean StringFinder(TextField txtField) {
        boolean exit = true;

        for (int i = 0; i < txtField.getText().length(); i++) {
            int c = txtField.getText().charAt(i);
            if (!(c >= 48 && c <= 57)) {
                exit = false;
            }
        }
        return exit;
    }

    private void setImage() {
        Image img;
        img = new Image("./sample/PNG/Back.png");
        imageViewBack.setImage(img);
        img = new Image("./sample/PNG/Exit.png");
        imageExit1.setImage(img);
        img = new Image("./sample/PNG/Exit.png");
        imageExit2.setImage(img);
        img = new Image("./sample/PNG/Back.png");
        imageBack2.setImage(img);
        img = new Image("./sample/PNG/Exit.png");
        imageExit3.setImage(img);
        img = new Image("./sample/PNG/Back.png");
        imageBack3.setImage(img);
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
        String[] condition = {"فارغ التحصیل", "درحال تحصیل"};
        comboCondition.getItems().addAll(condition);
        String[] diplomType = {"تجربی", "انسانی","ریاضی فیزیک"};
        comboDyplomType.getItems().addAll(diplomType);
        setImage();
        Show();
        studentIdGeneratorDataCenter = new StudentIdGeneratorDataCenter();
        studentIdGeneratorDataCenter.setYearNumber(98);

    }

}
