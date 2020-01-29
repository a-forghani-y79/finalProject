package sample.Controllers;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.NodeOrientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataCenter.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManagerController implements Initializable {
    public JFXButton btnBrowse;
    public JFXButton btnConfirm;
    public TextField txtPath;
    public JFXTextField txtFirstNameMaster;
    public JFXTextField txtLastNameMaster;
    public JFXTextField txtNationalNumberMaster;
    public JFXButton btnAddMaster;
    public JFXTextField txtFieldName;
    public JFXTextField txtFieldCode;
    public JFXTextField txtFieldUnit;
    public GridPane gridPaneProgram;
    public JFXButton btnChooseClassTime;
    public JFXTimePicker timePicker;
    public JFXDatePicker datePicker;
    public Label status;
    public JFXComboBox comboChooseMaster;
    public JFXComboBox comboGenderMaster;
    public JFXButton btn10;
    public JFXButton btn11;
    public JFXButton btn12;
    public JFXButton btn13;
    public JFXButton btn14;
    public JFXButton btn20;
    public JFXButton btn21;
    public JFXButton btn22;
    public JFXButton btn23;
    public JFXButton btn24;
    public JFXButton btn30;
    public JFXButton btn31;
    public JFXButton btn32;
    public JFXButton btn33;
    public JFXButton btn34;
    public JFXButton btn40;
    public JFXButton btn41;
    public JFXButton btn42;
    public JFXButton btn43;
    public JFXButton btn44;
    public JFXButton btn50;
    public JFXButton btn51;
    public JFXButton btn52;
    public JFXButton btn53;
    public JFXButton btn54;
    private JFXButton[] btns;
    public JFXButton btnExit1;
    public JFXButton btnBack1;
    public ImageView imageExit1;
    public ImageView imageBack1;
    public JFXButton btnExit2;
    public ImageView imageExit2;
    public JFXButton btnBack2;
    public ImageView imageBack2;
    public JFXButton btnExit3;
    public JFXButton btnBack3;
    public ImageView imageExit3;
    public ImageView imageBack3;
    public Label lblAlert;
    public ColumnConstraints gridPane;
    public Label labelAlert2;
    public Label lblsuc;
    public Label lblAdd;
    public TextArea txtAreaAddMaster;
    public ImageView imageHint2;
    public JFXButton btnHint2;
    public ImageView imageHint1;
    public JFXButton btnHint1;
    public JFXButton btnHint3;
    public ImageView imageHint3;
    public TextArea textHint3;
    public AnchorPane anchorPane3;
    public AnchorPane anchorPane2;
    public AnchorPane anchorPane1;
    public TextArea textHint2;
    public TextArea textHint1;
    TextField txtAddress;
    TextField txtYear;
    private FileChooser fileChooser;
    private Stage stage;
    private File file;
    private String addrCSV = "";
    private ImportNewStudentDataCenter importNewStudent;
    private ArchiveDataCenter archive;


    public boolean[] flag = {true};
    public boolean[] flag2 = {true};
    public boolean[] flag3 = {true};
    public boolean[] flag4 = {true};
    public boolean[] flag5 = {true};
    public boolean[] flagGrid = {false};
    StudentIdGeneratorDataCenter idGenerator;
    //passengers
    MasterDataCenter master;
    FieldDataCenter field;
//TODO complete Label status and use an text field for getting year
    public void onClickAddMaster() {
        archive = new ArchiveDataCenter();
        master = new MasterDataCenter();
        idGenerator = new StudentIdGeneratorDataCenter();
        idGenerator.setYearNumber(98);
        long id = idGenerator.createIdMaster();
        int comboIndex = comboGenderMaster.getSelectionModel().getSelectedIndex();
       // lblAdd.setVisible(false);
        setDefaultColor();
        if (checkTextFieldMaster() && comboChecker(comboGenderMaster)) {
            master.setFirstName(txtFirstNameMaster.getText());
            master.setLastName(txtLastNameMaster.getText());
            master.setGender(comboIndex);
            master.setNationalNumber(Long.parseLong(txtNationalNumberMaster.getText()));
            master.setPersonalNumber(id);
            System.out.println(id);
            archive.writeMaster(master);
           // lblAdd.setVisible(true);
            txtNationalNumberMaster.setText("");
            txtLastNameMaster.setText("");
            txtFirstNameMaster.setText("");
            txtAreaAddMaster.setVisible(true);
            txtAreaAddMaster.setText("استاد با مئفقیت اضافه شد !" +
                    "\n" + id + "شماره پرسنلی استاد :" + "\n");

        }
        //TODO show master personal id && clear text fields
    }

    void setDefaultColor() {
        txtFirstNameMaster.setStyle("");
        txtNationalNumberMaster.setStyle("");
        txtLastNameMaster.setStyle("");
        comboGenderMaster.setStyle("");
    }

    boolean comboChecker(JFXComboBox comboBox) {
        if (comboBox.getSelectionModel().getSelectedIndex() >= 0)
            return true;
        else {
            comboBox.setStyle("-fx-background-color: rgba(255,7,10,0.71);");
            return false;
        }
    }

    boolean checkTextFieldMaster() {
        boolean flag = true;
        if (!emptyChecker(txtFirstNameMaster)) {
            System.out.println("first is empty");
            flag = false;
            txtFirstNameMaster.setStyle("-fx-background-color: rgba(255,7,10,0.71);");
        }
        if (!emptyChecker(txtLastNameMaster)) {
            flag = true;
            txtLastNameMaster.setStyle("-fx-background-color: rgba(255,7,10,0.71);");
        }
        if (!emptyChecker(txtNationalNumberMaster)) {
            flag = true;
            txtNationalNumberMaster.setStyle("-fx-background-color: rgba(255,7,10,0.71);");
        } else if (!(numChecker(txtNationalNumberMaster.getText()))) {
            txtNationalNumberMaster.setStyle("-fx-text-inner-color: rgb(255,0,0);");
            flag = false;
        }
        return flag;
    }

    public void onClickBrowse() {
        stage = (Stage) btnBrowse.getScene().getWindow();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv", "*.CSV"), new FileChooser.ExtensionFilter("Text File", "*.txt"));
        file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            addrCSV = file.getAbsolutePath();
            txtPath.setText(addrCSV);
            if (file.exists())
                btnConfirm.setDisable(false);
        }
    }

    public void onClickConfirm() {
        //String str = txtYear.getText();
        String str = "98";
        System.out.println(numChecker(str));
        if (numChecker(str)) {
            int year = Integer.parseInt(str);
            importNewStudent = new ImportNewStudentDataCenter(addrCSV, year);
            status.setText("عملیات با موفقیت انجام شد .");
        } else {

            status.setText("سال دارای اعتبار نیست !");
        }
    }

    boolean numChecker(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++)
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                flag = false;
                break;
            }
        return flag;
    }

    boolean emptyChecker(JFXTextField textField) {
        boolean flag = true;
        if (textField.getText().equals(""))
            flag = false;
        return flag;
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
        img = new Image("./sample/PNG/Blue_question_mark_icon.svg.png");
        imageHint1.setImage(img);
        imageHint2.setImage(img);
        imageHint3.setImage(img);
    }

    public void onClickGridPane(MouseEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        if (btn.getStyle().equals(""))
            btn.setStyle("-fx-background-color: green;");
        else
            btn.setStyle("");
        if (btn.getId().charAt(4) == '4') {
            flagGrid[0] = true;
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "شنبه");
        } else if (btn.getId().charAt(4) == '3') {
            flagGrid[0] = true;
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "یکشنبه");
        } else if (btn.getId().charAt(4) == '2') {
            flagGrid[0] = true;
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "دو شنبه");
        } else if (btn.getId().charAt(4) == '1') {
            flagGrid[0] = true;
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "سه شنبه");
        } else if (btn.getId().charAt(4) == '0') {
            flagGrid[0] = true;
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "چهار شنبه");
        }
        if (btn.getId().charAt(3) == '4') {
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "14-16");
        } else if (btn.getId().charAt(3) == '3') {
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "12-14");
        } else if (btn.getId().charAt(3) == '2') {
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "10-12");
        } else if (btn.getId().charAt(3) == '1') {
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "8-10");
        } else if (btn.getId().charAt(3) == '5') {
            fieldDataCenter.setClassStartTime(fieldDataCenter.getClassStartTime() + "," + "14-16");
        }
    }

    private void emptyFinder(TextField txtField) {
        if (txtField.getText().equals("")) {
            txtField.setStyle(txtField.getStyle() + "-fx-background-color: red;");
            if (txtField.equals(txtFieldName)) {
                flag[0] = false;
            }
            if (txtField.equals(txtFieldUnit)) {
                flag2[0] = false;
            }
            if (txtField.equals(txtFieldCode)) {
                flag3[0] = false;
            }

        } else {
            txtField.setStyle(txtField.getStyle() + "-fx-background-color: #d6d6d6;");
            if (txtField.equals(txtFieldName)) {
                flag[0] = true;
            }
            if (txtField.equals(txtFieldUnit)) {
                flag2[0] = true;
            }
            if (txtField.equals(txtFieldCode)) {
                flag3[0] = true;
            }
        }

    }

    private void NumberFinder(TextField txtField) {
        for (int i = 0; i < txtField.getText().length(); i++) {
            int c = txtField.getText().charAt(i);
            if (c >= 48 && c <= 57) {
                txtField.setStyle(txtField.getStyle() + "-fx-text-inner-color: #D70406;");
                if (txtField.equals(txtFieldName)) {
                    flag[0] = false;
                }
            } else {
                txtField.setStyle(txtField.getStyle() + "-fx-text-inner-color: #000000;");
                if (txtField.equals(txtFieldName)) {
                    flag[0] = true;
                }
            }
        }
    }

    private void StringFinder(TextField txtField) {
        for (int i = 0; i < txtField.getText().length(); i++) {
            int c = txtField.getText().charAt(i);
            if (!(c >= 48 && c <= 57)) {
                txtField.setStyle(txtField.getStyle() + "-fx-text-inner-color: #D70406;");
                if (txtField.equals(txtFieldUnit)) {
                    flag2[0] = false;
                }
                if (txtField.equals(txtFieldCode)) {
                    flag3[0] = false;
                }
            } else {
                txtField.setStyle(txtField.getStyle() + "-fx-text-inner-color: #000000;");
                if (txtField.equals(txtFieldUnit)) {
                    flag2[0] = true;
                }
                if (txtField.equals(txtFieldCode)) {
                    flag3[0] = true;
                }
            }
        }
    }

    public void gridPne(MouseEvent event) {
        if (!event.getEventType().equals(new JFXButton())) {
            gridPaneProgram.setVisible(false);
        }
    }

    public void gridPaneVisible() {
        gridPaneProgram.setVisible(true);
    }

    public void btnSubmit() {
        emptyFinder(txtFieldCode);
        emptyFinder(txtFieldName);
        emptyFinder(txtFieldUnit);
        NumberFinder(txtFieldName);
        StringFinder(txtFieldUnit);
        StringFinder(txtFieldCode);
        LocalDate localDate = datePicker.getValue();
        LocalTime localTime = timePicker.getValue();
        try {
            localDate.getYear();
            localDate.getMonth();
            localDate.getDayOfMonth();
            datePicker.setStyle(datePicker.getStyle() + "-fx-background-color: #ffffff ;");
            flag4[0] = true;
        } catch (NullPointerException e) {
            datePicker.setStyle(datePicker.getStyle() + "-fx-background-color: #D70406 ;");
            flag4[0] = false;
        }
        try {
            localTime.getHour();
            localTime.getMinute();
            timePicker.setStyle(timePicker.getStyle() + "-fx-background-color: #ffffff ;");
            flag5[0] = true;
        } catch (NullPointerException e) {
            timePicker.setStyle(timePicker.getStyle() + "-fx-background-color: #D70406 ;");
            flag5[0] = false;
        }


        if (flag[0] && flag2[0] && flag3[0] && flag4[0] && flag5[0] && flagGrid[0]) {
            labelAlert2.setVisible(false);
            lblAlert.setVisible(false);
            lblsuc.setVisible(true);
            completeFieldDataCenter();
            txtFieldName.setText("");
            txtFieldCode.setText("");
            txtFieldUnit.setText("");
            cleanGradePane();

        } else if (flag[0] && flag[0] && flag2[0] && flag3[0] && flag4[0] && flag5[0] && !(flagGrid[0])) {
            labelAlert2.setVisible(true);
            lblAlert.setVisible(false);
        } else {
            lblAlert.setVisible(true);
            labelAlert2.setVisible(false);
        }

    }

    FieldDataCenter fieldDataCenter = new FieldDataCenter();

    public void completeFieldDataCenter() {
        fieldDataCenter.setFieldName(txtFieldName.getText());
        fieldDataCenter.setFieldNumber(Long.parseLong(txtFieldCode.getText()));
        fieldDataCenter.setUnit(Integer.parseInt(txtFieldUnit.getText()));
        LocalDate localDate = datePicker.getValue();
        LocalTime localTime = timePicker.getValue();
        fieldDataCenter.setTimeToTakeExam("year :" + localDate.getYear());
        fieldDataCenter.setTimeToTakeExam(fieldDataCenter.getTimeToTakeExam() + "," + "month :" + localDate.getMonth());
        fieldDataCenter.setTimeToTakeExam(fieldDataCenter.getTimeToTakeExam() + "," + "day :" + localDate.getDayOfMonth());
        fieldDataCenter.setTimeToTakeExam(fieldDataCenter.getTimeToTakeExam() + "," + "hour :" + localTime.getHour());
        fieldDataCenter.setTimeToTakeExam(fieldDataCenter.getTimeToTakeExam() + "," + "minute :" + localTime.getMinute());

        archive.writeAllFields(new FieldDataCenter[]{fieldDataCenter});
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
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا می خواهید برگردید؟ "  , ButtonType.YES, ButtonType.NO);
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

    private void setTextInTextArea(){
        textHint1.setText("سپس با انتخاب فایل دانشجویال دکمه تایید را بزنید"+"\n"+ "در این صفحه باید روی دکمه ^ انتخاب فایل ^ کلیک کنید : ");
        textHint2.setText("در این صفحه پس از انتخاب مشخحصات استاد دکمه افزودن را بزنید");
        textHint3.setText("در این صفحه پس از انتخاب مشخحصات هر ذرس دکمه افزودن را بزنید");
    }


    public void hintVisible1() {
        if (!textHint1.isVisible()) {
            textHint1.setVisible(true);
        }
        if (textHint1.isVisible()) {
            textHint1.setVisible(false);
        }
    }

    public void hintVisible2() {
        if (!textHint2.isVisible()) {
            textHint2.setVisible(true);
        }
        if (textHint2.isVisible()) {
            textHint2.setVisible(false);
        }
    }

    public void hintVisible3() {
        if (!textHint3.isVisible()) {
            textHint3.setVisible(true);
        }
        if (textHint3.isVisible()) {
            textHint3.setVisible(false);
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
        btnConfirm.setDisable(true);
        String[] gender = {"خانم", "آقا"};
        comboGenderMaster.getItems().addAll(gender);
        comboGenderMaster.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        setImage();
        gridPaneProgram.setOpacity(1);
        setTextInTextArea();
        btns = new JFXButton[]{btn10, btn11, btn12, btn13, btn14, btn20, btn21, btn22, btn23, btn24, btn30, btn31, btn32, btn33, btn34, btn40, btn41, btn42, btn43, btn44, btn50, btn51, btn52, btn53, btn54};
         archive = new ArchiveDataCenter();
    }

    void cleanGradePane() {
        for (int i = 0; i < btns.length; i++) {
            btns[i].setStyle("");
        }
    }
}